package DesignMode.AbstractFactory;

public class House {
    private String floor;
    private String wall;
    private String houseTop;

    public synchronized String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getWall() {
        return wall;
    }

    public void setWall(String wall) {
        this.wall = wall;
    }

    public String getHouseTop() {
        return houseTop;
    }

    public void setHouseTop(String houseTop) {
        this.houseTop = houseTop;
    }

    @Override
    public String toString() {
        return "House{" +
                "floor='" + floor + '\'' +
                ", wall='" + wall + '\'' +
                ", houseTop='" + houseTop + '\'' +
                '}';
    }
}
