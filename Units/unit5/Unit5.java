package unit5;

public class Unit5 {

    public static void main(String[] args) {

        Singleton1 s11 = Singleton1.getInstance(); // Инициализация ленивого синглтона
        s11.setNumber(5); // Изменение значения переменной
        Singleton1 s12 = Singleton1.getInstance(); // Инициализация второго ленивого синглтона

        System.out.println(s12.getNumber()); // Вывод значения переменной через вторую инстанцию синглтона

        Singleton2 s21 = Singleton2.INSTANCE; // Инициализация синглтона
        s21.number = 3; // Изменение значения переменной
        Singleton2 s22 = Singleton2.INSTANCE; // Инициализация второго синглтона

        System.out.println(s22.number); // Вывод значения переменной через вторую инстанцию синглтона

        Singleton3 s31 = Singleton3.getInstance(); // Инициализация раннего синглтона
        s31.setNumber(8); // Изменение значения переменной
        Singleton3 s32 = Singleton3.getInstance(); // Инициализация второго раннего синглтона

        System.out.println(s32.getNumber()); // Вывод значения переменной через вторую инстанцию синглтона

    }

}
