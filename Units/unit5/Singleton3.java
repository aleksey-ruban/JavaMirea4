package unit5;

public class Singleton3 { // Реализация синглтона с ранней инициализацией

    private int number; // Переменная с числом

    private static Singleton3 instance = new Singleton3(); // Статичесткая переменная, содержащая инстанцию класса

    private Singleton3() {} // Приватный конструктор

    public synchronized static Singleton3 getInstance() { // Метод получения инстанции класса
        return instance;
    }

    public int getNumber() { // Геттер для переменной
        return number;
    }

    public void setNumber(int number) { // Сеттер для переменной
        this.number = number;
    }
}
