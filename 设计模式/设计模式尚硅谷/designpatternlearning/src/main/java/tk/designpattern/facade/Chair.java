package tk.designpattern.facade;

public class Chair {
    private static Chair instance = new Chair();
    private Chair(){}

    public static Chair getInstance(){return instance;}

    public void open(){
        System.out.println("Chair is open");
    }
    public void pause(){
        System.out.println("Chair is paused");
    }
    public void stop(){
        System.out.println("Chair is stopped");
    }
}
