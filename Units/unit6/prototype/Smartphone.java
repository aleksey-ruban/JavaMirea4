package unit6.prototype;

public class Smartphone implements Cloneable {

    private int ram;
    private int storage;
    private int battery;
    private float displayDiagonal;


    public Smartphone(int ram, int storage, int battery, float displayDiagonal) {
        this.ram = ram;
        this.storage = storage;
        this.battery = battery;
        this.displayDiagonal = displayDiagonal;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public int getBattery() {
        return battery;
    }

    public void setBattery(int battery) {
        this.battery = battery;
    }

    public float getDisplayDiagonal() {
        return displayDiagonal;
    }

    public void setDisplayDiagonal(float displayDiagonal) {
        this.displayDiagonal = displayDiagonal;
    }

    @Override
    public Smartphone clone() {
        try {
            return (Smartphone) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public String toString() {
        return "Smartphone{" +
                "ram=" + ram +
                ", storage=" + storage +
                ", battery=" + battery +
                ", displayDiagonal=" + displayDiagonal +
                '}';
    }
}
