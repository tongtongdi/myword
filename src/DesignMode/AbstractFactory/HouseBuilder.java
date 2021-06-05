package DesignMode.AbstractFactory;

public interface HouseBuilder {

    // 修地板
    public void makeFloor();

    // 修墙
    public void makeWall();

    // 修房顶
    public void maketop();

    public House getHouse();
}
