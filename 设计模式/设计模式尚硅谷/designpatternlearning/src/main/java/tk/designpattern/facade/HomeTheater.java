package tk.designpattern.facade;

public class HomeTheater {
    private Movie movie = Movie.getInstance();
    private Video video = Video.getInstance();
    private Chair chair = Chair.getInstance();

    public void open(){
        chair.open();
        movie.open();
        video.open();
    }
    public void pause(){
        chair.pause();
        movie.pause();
        video.pause();
    }
    public void stop(){
        chair.stop();
        movie.stop();
        video.stop();
    }
}
