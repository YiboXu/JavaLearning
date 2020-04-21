package tk.designpattern.builder.improve;

public class HighBuildingHouseBuilder extends HouseBuilder {
    @Override
    public void buildBasic() {
        System.out.println("**基础搭建**");
        super.house.setBasicPart("**基础搭建完成**");
    }

    @Override
    public void buildWalls() {
        System.out.println("**搭建围墙**");
        super.house.setWalls("**搭建围墙完成**");
    }

    @Override
    public void buildRoof() {
        System.out.println("**搭建屋顶**");
        super.house.setRoof("**搭建屋顶完成**");
    }
}
