package tk.chap11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Shop {
    private static Random random = new Random(37);
    private String name;

    public Shop(){
        this.name = "DefaultName";
    }

    public Shop(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public double getPrice(String product){
        return calculatePrice(product);
    }

    public Future<Double> getPriceWithFuture(String product){
        ExecutorService service = Executors.newCachedThreadPool();
        Future<Double> futurePrice = service.submit(() ->calculatePrice(product));

        return futurePrice;
    }

    public Future<Double> getPriceAsync(String product){
        CompletableFuture<Double> futurePrice = new CompletableFuture<>();
        new Thread(()->{
                double price = calculatePrice(product);
                futurePrice.complete(price);
        }).start();

        return futurePrice;
    }

    public Future<Double> getPriceAsyncWithException(String product){
        CompletableFuture<Double> futurePrice = new CompletableFuture<>();
        new Thread(()->{
            try {
                double price = calculatePrice(product);
                futurePrice.complete(price);
            } catch (Exception ex) {
                futurePrice.completeExceptionally(ex);
            }
        }).start();

        return futurePrice;
    }

    //it's the same as getPriceAsyncWithException including the exception handle, but it's simple to code with supplyAsync()
    public Future<Double> getPriceBySupplier(String product){
        return CompletableFuture.supplyAsync(() -> calculatePrice(product));
    }

    private double calculatePrice(String product){
        //delay();
        randomDelay();
        if(product.equals("IPhone11")){
            throw new RuntimeException("Product is not available!");
        }

        return random.nextDouble() * product.charAt(0) + product.charAt(1);
    }

    private void doSomethingElse(){
        System.out.println("Do something else!");
    }

    public void delay(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void randomDelay() {
        int delay = 500 + random.nextInt(2000);
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void testGetPriceWithFuture(String product, Function<String,Future<Double>> getPrice){
        Shop shop = new Shop();
        long start = System.nanoTime();
        Future<Double> futurePrice = getPrice.apply(product);
        long invocationTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("Invocation returned after " + invocationTime + " msecs");

        shop.doSomethingElse();

        try {
            double price = futurePrice.get(1,TimeUnit.SECONDS);
            System.out.printf("Price is %.2f%n", price);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }

        long retrievalTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("Price returned after " + retrievalTime + " msecs");
    }

    public void testGetPrice(String product, Function<String,Double> getPrice){
        Shop shop = new Shop();
        long start = System.nanoTime();
        double price = getPrice.apply(product);
        long invocationTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("Invocation returned after " + invocationTime + " msecs");
        System.out.printf("Price is %.2f%n", price);
        long retrievalTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("Price returned after " + retrievalTime + " msecs");

        shop.doSomethingElse();
    }

    public void testGetPriceWithShops(int n, String product){
        List<Shop> shops = getShops(n);

        long start = System.nanoTime();

        shops.parallelStream().map(shop ->
            String.format("%s price is %.2f\n",shop.getName(),shop.getPrice(product))
        ).collect(Collectors.toList());

        long retrievalTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("Price returned after " + retrievalTime + " msecs");
    }

    public void testGetPriceWithShopsAndFuture(int n, String product){
        List<Shop> shops = getShops(n);

        long start = System.nanoTime();

        List<CompletableFuture<String>> list = shops.stream().map(
                                                shop -> CompletableFuture.supplyAsync(
                                                        () -> shop.getName()+"price is "+shop.calculatePrice(product)+"\n"))
                                            .collect(Collectors.toList());

        //through join, the map process will process the get() of each CompletableFuture one by one
        //it means it will invoke the next get() until previous get() complete
        list.stream().map(CompletableFuture::join).collect(Collectors.toList());

        long retrievalTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("Price returned after " + retrievalTime + " msecs");
    }

    //use self defined Executor to define the number of thread,
    // for default, the number of thread is Runtime.getRuntime().availableProcessors()
    public void testGetPriceWithShopsAndFutureAndExecutor(int n, String product){
        List<Shop> shops = getShops(n);

        Executor executor =
                Executors.newFixedThreadPool(Math.min(shops.size(), 100),
                        new ThreadFactory() {
                            public Thread newThread(Runnable r) {
                                Thread t = new Thread(r);
                                t.setDaemon(true);
                                return t;
                            }
                        });

        long start = System.nanoTime();

        List<CompletableFuture<String>> list = shops.stream().map(
                shop -> CompletableFuture.supplyAsync(
                        () -> shop.getName()+"price is "+shop.calculatePrice(product)+"\n", executor))
                .collect(Collectors.toList());

        list.stream().map(CompletableFuture::join).collect(Collectors.toList());

        long retrievalTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("Price returned after " + retrievalTime + " msecs");
    }

    public static List<Shop> getShops(int n){
        if (n > 0){
            List<Shop> shops = new ArrayList<>(n);
            for(int i=0;i<n;i++)
                shops.add(new Shop());
            return shops;
        }else
            return new ArrayList<Shop>();
    }

    public String getPriceWithDiscount(String product) {
        double price = calculatePrice(product);
        Discount.Code code = Discount.Code.values()[
                random.nextInt(Discount.Code.values().length)];
        return String.format("%s:%.2f:%s", name, price, code);
    }

    public void testGetPriceWithDiscount(int n, String product){
        List<Shop> shops = getShops(n);

        long start = System.nanoTime();
        shops.stream().map(shop -> shop.getPriceWithDiscount(product))
                .map(Quote::parse)
                .map(Discount::applyDiscount)
                .collect(Collectors.toList());
                //.forEach(System.out::println);

        long retrievalTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("Price returned after " + retrievalTime + " msecs");
    }

    public void testGetPriceWithDiscountAndFuture(int n, String product){
        List<Shop> shops = getShops(n);

        Executor executor =
                Executors.newFixedThreadPool(Math.min(shops.size(), 100),
                        new ThreadFactory() {
                            public Thread newThread(Runnable r) {
                                Thread t = new Thread(r);
                                t.setDaemon(true);
                                return t;
                            }
                        });

        long start = System.nanoTime();

        List<CompletableFuture<String>> priceFutures = shops.stream().map(shop ->
                            CompletableFuture.supplyAsync(() -> shop.getPriceWithDiscount(product),executor))
                      .map(future -> future.thenApply(Quote::parse))
                      .map(future -> future.thenCompose(quote -> CompletableFuture.supplyAsync(() -> Discount.applyDiscount(quote),executor)))
                      .collect(Collectors.toList());

        priceFutures.stream().map(CompletableFuture::join).collect(Collectors.toList());

        long retrievalTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("Price returned after " + retrievalTime + " msecs");
    }

    public void testGetPriceWithDiscountAndFutureAndRate(int n, String product){
        List<Shop> shops = getShops(n);

        Executor executor =
                Executors.newFixedThreadPool(Math.min(shops.size(), 100),
                        new ThreadFactory() {
                            public Thread newThread(Runnable r) {
                                Thread t = new Thread(r);
                                t.setDaemon(true);
                                return t;
                            }
                        });

        long start = System.nanoTime();
        //Supplier t = () -> ExchangeService.getRate(ExchangeService.Money.EUR, ExchangeService.Money.USD);
        List<CompletableFuture<String>> priceFutures = shops.stream().map(shop ->
                CompletableFuture.supplyAsync(() -> shop.getPriceWithDiscount(product),executor))
                .map(future -> future.thenApply(Quote::parse))
                .map(future -> future.thenCompose(quote -> CompletableFuture.supplyAsync(() -> Discount.applyDiscount(quote),executor)))
                .map(future -> future.thenCombine(CompletableFuture.supplyAsync(() -> ExchangeService.getRate(ExchangeService.Money.EUR, ExchangeService.Money.USD)),
                                                  (price,rate) -> price +" rate: "+rate))
                .collect(Collectors.toList());

        priceFutures.stream().map(CompletableFuture::join).forEach(System.out::println);

        long retrievalTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("Price returned after " + retrievalTime + " msecs");
    }

    public void testGetPriceWithDiscountAndFutureAndRateWithAccept(int n, String product){
        List<Shop> shops = getShops(n);

        Executor executor =
                Executors.newFixedThreadPool(Math.min(shops.size(), 100),
                        new ThreadFactory() {
                            public Thread newThread(Runnable r) {
                                Thread t = new Thread(r);
                                t.setDaemon(true);
                                return t;
                            }
                        });

        long start = System.nanoTime();

        CompletableFuture[] priceFutures = shops.stream().map(shop ->
                CompletableFuture.supplyAsync(() -> shop.getPriceWithDiscount(product),executor))
                .map(future -> future.thenApply(Quote::parse))
                .map(future -> future.thenCompose(quote -> CompletableFuture.supplyAsync(() -> Discount.applyDiscount(quote),executor)))
                .map(future -> future.thenCombine(CompletableFuture.supplyAsync(() -> ExchangeService.getRate(ExchangeService.Money.EUR, ExchangeService.Money.USD)),
                        (price,rate) -> price +" rate: "+rate))
                .map(future -> future.thenAccept(s ->
                                        System.out.println(s + " (done in " + ((System.nanoTime() - start) / 1_000_000) + " msecs)")))
                .toArray(size -> new CompletableFuture[size]);

        CompletableFuture.allOf(priceFutures).join();

        long retrievalTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("Price returned after " + retrievalTime + " msecs");
    }

    public static void main(String[] args){
        Shop shop = new Shop();
        //shop.testGetPriceWithFuture("IPhone12",shop::getPriceBySupplier);
        //shop.testGetPrice("IPhone12",shop::getPrice);
        System.out.println("testGetPriceWithShops");
        shop.testGetPriceWithShops(20,"IPhone12");
        System.out.println("testGetPriceWithShopsAndFuture");
        shop.testGetPriceWithShopsAndFuture(20,"IPhone12");
        System.out.println("testGetPriceWithShopsAndFutureAndExecutor");
        shop.testGetPriceWithShopsAndFutureAndExecutor(20,"IPhone12");
        System.out.println("testGetPriceWithDiscount");
        shop.testGetPriceWithDiscount(5,"IPhone12");
        System.out.println("testGetPriceWithDiscountAndFuture");
        shop.testGetPriceWithDiscountAndFuture(5,"IPhone12");
        System.out.println("testGetPriceWithDiscountAndFutureAndRate");
        shop.testGetPriceWithDiscountAndFutureAndRate(5,"IPhone12");
        System.out.println("testGetPriceWithDiscountAndFutureAndRateWithAccept");
        shop.testGetPriceWithDiscountAndFutureAndRateWithAccept(5,"IPhone12");
    }
}
