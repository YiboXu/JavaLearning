package tk.designpattern.builder.improve;

public class Client {
    public static void main(String[] args) {
        HouseBuilder houseBuilder = new CommonHouseBuilder();
        HouseDirector director = new HouseDirector(houseBuilder);
        System.out.println(director.contructHouse());

        HouseBuilder highBuildingHouseBuilder = new HighBuildingHouseBuilder();
        director.setHouseBuilder(highBuildingHouseBuilder);
        System.out.println(director.contructHouse());
    }
}
