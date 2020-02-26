package tk.spring.staticproxy;

public class StaticProxy implements Rent {
    private Host host;
    public void setHost(Host host){
        this.host = host;
    }

    public StaticProxy(){}

    public StaticProxy(Host host){
        this.host = host;
    }

    @Override
    public void rent() {
        seeHouse();
        host.rent();
        fare();
    }

    public void seeHouse(){
        System.out.println("租客看房");
    }

    public void fare(){
        System.out.println("交中介费");
    }
}
