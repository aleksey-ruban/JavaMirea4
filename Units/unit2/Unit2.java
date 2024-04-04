package unit2;

public class Unit2 {
    public static void main(String[] args) {
        HumanStreaming hs = new HumanStreaming(); // Получение объекта для операций

        // Выполнение операций
        hs.sortingBySecondLetter();
        hs.filterByWeight();
        hs.sortingByWeightAndAge();
        hs.multiplicationWeight();
    }
}
