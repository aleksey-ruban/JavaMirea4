package unit7.decorator;

public class OutRoad extends CarDecorator {
    public OutRoad(Car car) {
        super(car);
    }

    @Override
    public void info() {
        super.info();
        System.out.println("Also it is outroader");
    }
}
