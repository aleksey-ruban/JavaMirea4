package unit7.decorator;

public class SportCar extends CarDecorator {
    public SportCar(Car car) {
        super(car);
    }

    @Override
    public void info() {
        super.info();
        System.out.println("Also it is sport car");
    }
}
