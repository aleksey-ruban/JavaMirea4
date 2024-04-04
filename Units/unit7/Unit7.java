package unit7;

import unit7.decorator.BasicCar;
import unit7.decorator.Car;
import unit7.decorator.OutRoad;
import unit7.decorator.SportCar;
import unit7.facade.Facade;

public class Unit7 {

    public static void main(String[] args) {

        // Создание базовыз автомобилей
        Car basicCar1 = new BasicCar();
        Car basicCar2 = new BasicCar();

        // Декорирование базовых автомобилей
        Car sportcar = new SportCar(basicCar1);
        Car outroad = new OutRoad(basicCar2);

        // Вывод информации об объектах
        sportcar.info();
        System.out.println();
        outroad.info();
        System.out.println();


        // Инициализация объекта Facade
        Facade facade = new Facade();

        // Получение информации при помощи паттерна фасад
        System.out.println(facade.getInfo(Facade.SourceType.SERVER, Facade.ContentType.NAME));
        System.out.println(facade.getInfo(Facade.SourceType.DB, Facade.ContentType.NAME));



    }

}
