package unit6;

import unit6.abstractFabricMethod.AudiFactory;
import unit6.abstractFabricMethod.Liftback;
import unit6.abstractFabricMethod.PorscheFactory;
import unit6.factoryMethod.Auto;
import unit6.factoryMethod.AutoFactory;
import unit6.factoryMethod.AutoType;
import unit6.prototype.Smartphone;

public class Unit6 {
    public static void main(String[] args) {

        // Создание фабрики автомобилей
        AutoFactory autoFactory = new AutoFactory();

        // Инициализация различных автомобилей
        Auto sedan = autoFactory.createAuto(AutoType.SEDAN);
        Auto liftback = autoFactory.createAuto(AutoType.LIFTBACK);
        Auto crossover = autoFactory.createAuto(AutoType.CROSSOVER);

        // Вывод классов созданных автомобилей
        System.out.println(sedan.getClass().getName());
        System.out.println(liftback.getClass().getName());
        System.out.println(crossover.getClass().getName() + "\n");


        // Объявление абстрактной фабрики
        unit6.abstractFabricMethod.AutoFactory abstrFactory;

        // Инициализация фабрики как фабрики Ауди и создание авто
        abstrFactory = new AudiFactory();
        Liftback autoLiftback = abstrFactory.createLiftback();

        // Изменение фабрики на производство Porsche и создание авто
        abstrFactory = new PorscheFactory();
        Liftback autoLiftback2 = abstrFactory.createLiftback();

        // Вывод полученных классов разных фабрик
        System.out.println(autoLiftback.getClass().getName());
        System.out.println(autoLiftback2.getClass().getName() + "\n");


        // Инициализация переменной auto с помощью builder'а
        unit6.builder.Auto auto = new unit6.builder.Auto.AutoBuilder().setPower(250)
                .setMaxSpeed(355)
                .setQtyPassengers(2)
                .build();

        // Вывод информации об объекте
        System.out.println("Power: " + auto.getPower() + ", maxSpeed: " + auto.getMaxSpeed() + ", passengers: " + auto.getQtyPassengers() + "\n");


        // Создание прототипа и его клонирование
        Smartphone prototype = new Smartphone(4, 256, 4500, 5.2F);
        Smartphone clone = prototype.clone();
        prototype.setRam(6);

        // Вывод характеристик клона
        System.out.println(clone.toString());
    }
}
