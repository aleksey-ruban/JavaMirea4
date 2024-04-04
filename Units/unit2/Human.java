package unit2;

import java.math.BigInteger;
import java.time.LocalDate;

public class Human {
    int age; // Возраст
    String firstName; // Имя
    String lastName; // Фамилия
    LocalDate birthDate; // Дата рождения
    BigInteger weight; // Вес

    public Human(int age, String firstName, String lastName, LocalDate birthDate, BigInteger weight) { // Конструктор класса
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.weight = weight;
    }
}
