package DesignMode.AbstractFactory;

public class VipBuilder implements HouseBuilder {
    House house = new House();
    @Override
    public void makeFloor() {
        house.setFloor("黄金地板");
    }

    @Override
    public void makeWall() {
        house.setWall("黄金墙");
    }

    @Override
    public void maketop() {
        house.setHouseTop("黄金楼顶");
    }

    @Override
    public House getHouse() {
        return house;
    }
}
