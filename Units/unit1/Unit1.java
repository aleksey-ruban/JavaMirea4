package unit1;

import javafx.util.Pair;

import java.util.Scanner;
import java.util.function.Function;

public class Unit1 implements Function<Pair<Integer, Integer>, Integer> {
    @Override
    public Integer apply(Pair<Integer, Integer> p) { // Имплементация интерфейса Function
        int a = p.getKey(); // Получение переданных значений
        int b = p.getValue();
        return gcd(a, b); // Возврат НОД
    }

    private int gcd(int a, int b) { // Функция для вычисления наибольшего общего делителя
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a; // Возврат результата
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Unit1 unit1 = new Unit1(); // Получение инстанции класса
        int a = sc.nextInt();
        int b = sc.nextInt();
        Pair<Integer, Integer> pair = new Pair<>(a, b); // Создание пары для передачи в аргументы
        System.out.println(unit1.apply(pair)); // Вывод результата функции
    }

}