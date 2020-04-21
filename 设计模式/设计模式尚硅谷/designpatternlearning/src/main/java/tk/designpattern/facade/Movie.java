package tk.designpattern.facade;

public class Movie {
    private static Movie instance = new Movie();
    private Movie(){}

    public static Movie getInstance(){return instance;}

    public void open(){
        System.out.println("Movie is open");
    }
    public void pause(){
        System.out.println("Movie is paused");
    }
    public void stop(){
        System.out.println("Movie is stopped");
    }
}
