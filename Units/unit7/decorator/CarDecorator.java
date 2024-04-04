package unit7.decorator;

public abstract class CarDecorator implements Car {

    protected Car car;

    public CarDecorator(Car car) {
        this.car = car;
    }

    @Override
    public void info() {
        this.car.info();
    }
}
