package tk.designpattern.builder.improve;

public class HouseDirector {
    private HouseBuilder houseBuilder;

    public HouseDirector() {}

    public HouseDirector(HouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }

    public void setHouseBuilder(HouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }

    //如何构造房子，交给指挥者
    public House contructHouse(){
        houseBuilder.buildBasic();
        houseBuilder.buildWalls();
        houseBuilder.buildRoof();

        return houseBuilder.build();
    }
}
