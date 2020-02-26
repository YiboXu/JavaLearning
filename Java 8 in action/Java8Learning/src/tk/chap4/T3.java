package tk.chap4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class T3 {
    public static void main(String[] args){
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        System.out.println("Answer1:");
        System.out.println(transactions.stream().filter( t -> t.getYear() == 2011).collect(Collectors.toList()));
        System.out.println("Answer2:");
        System.out.println(transactions.stream().map(Transaction::getTrader).map(Trader::getCity).distinct().collect(Collectors.toList()));
        System.out.println("Answer3:");
        System.out.println(transactions.stream().map(Transaction::getTrader).distinct().filter(t -> t.getCity().equals("Cambridge")).sorted(Comparator.comparing(Trader::getName)).collect(Collectors.toList()));
        System.out.println("Answer4:");
        System.out.println(transactions.stream().map(Transaction::getTrader).distinct().map(Trader::getName).sorted().reduce("",(n1,n2)->n1+n2));
        System.out.println("Answer5:");
        System.out.println(transactions.stream().map(Transaction::getTrader).distinct().anyMatch(t -> t.getCity().equals("Milan")));

        System.out.println("Answer6:");
        System.out.println(transactions.stream().filter(t->t.getTrader().getCity().equals("Cambridge")).map(Transaction::getValue).collect(Collectors.toList()));
        System.out.println("Answer7:");
        System.out.println(transactions.stream().map(Transaction::getValue).reduce(Integer::max));
        System.out.println("Answer8:");
        System.out.println(transactions.stream().reduce((t1,t2)->t1.getValue()<=t2.getValue()?t1:t2));
    }
}
