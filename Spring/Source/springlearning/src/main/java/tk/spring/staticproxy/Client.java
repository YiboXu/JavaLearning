package tk.spring.staticproxy;

public class Client{
    public static void main(String[] args){
        Host host = new Host();
        StaticProxy proxy = new StaticProxy(host);
        proxy.rent();
    }
}
