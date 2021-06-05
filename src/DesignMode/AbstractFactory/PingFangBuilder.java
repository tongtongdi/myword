package DesignMode.AbstractFactory;

public class PingFangBuilder implements  HouseBuilder{
    private House house = new House();

    public PingFangBuilder() {
    }

    public PingFangBuilder(House house) {
        this.house = house;
    }

    @Override
    public void makeFloor() {
        house.setFloor("平房地板");
    }

    @Override
    public void makeWall() {
        house.setWall("平房墙");
    }

    @Override
    public void maketop() {
        house.setHouseTop("平房房顶");
    }

    @Override
    public House getHouse() {
        return house;
    }
}
