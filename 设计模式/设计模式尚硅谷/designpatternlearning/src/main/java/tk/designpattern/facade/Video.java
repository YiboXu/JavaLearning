package tk.designpattern.facade;

public class Video {
    private static Video instance = new Video();
    private Video(){}

    public static Video getInstance(){return instance;}

    public void open(){
        System.out.println("Video is open");
    }
    public void pause(){
        System.out.println("Video is paused");
    }
    public void stop(){
        System.out.println("Video is stopped");
    }
}
