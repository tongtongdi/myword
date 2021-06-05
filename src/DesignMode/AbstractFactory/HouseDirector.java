package DesignMode.AbstractFactory;

public class HouseDirector {
    private HouseBuilder builder;

    public HouseDirector(HouseBuilder builder) {
        this.builder = builder;
    }

    public void makeHouse() {
        builder.makeFloor();
        builder.maketop();
        builder.makeWall();
    }
}
