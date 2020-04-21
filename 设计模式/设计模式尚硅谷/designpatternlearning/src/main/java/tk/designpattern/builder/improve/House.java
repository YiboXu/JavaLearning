package tk.designpattern.builder.improve;

public class House {
    private String basicPart;
    private String walls;
    private String roof;

    public House() {}

    public String getBasicPart() {
        return basicPart;
    }

    public void setBasicPart(String basicPart) {
        this.basicPart = basicPart;
    }

    public String getWalls() {
        return walls;
    }

    public void setWalls(String walls) {
        this.walls = walls;
    }

    public String getRoof() {
        return roof;
    }

    public void setRoof(String roof) {
        this.roof = roof;
    }

    @Override
    public String toString() {
        return "House{" +
                "basicPart='" + basicPart + '\'' +
                ", walls='" + walls + '\'' +
                ", roof='" + roof + '\'' +
                '}';
    }
}
