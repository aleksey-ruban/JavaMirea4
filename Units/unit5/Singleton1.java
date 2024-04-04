package unit5;

public class Singleton1 { // Реализация синглтона с ленивой инициализацией

    private int number; // Переменная с числом

    private static Singleton1 instance; // Статичесткая переменная, содержащая инстанцию класса

    private Singleton1() {} // Приватный конструктор

    public synchronized static Singleton1 getInstance() { // Метод получения инстанции класса
        if (instance == null) { // Если инстанция класса не была создана, создать новую
            instance = new Singleton1();
        }
        return instance; // Вернуть созданную инстанцию
    }

    public int getNumber() { // Геттер для переменной
        return number;
    }

    public void setNumber(int number) { // Сеттер для переменной
        this.number = number;
    }
}
