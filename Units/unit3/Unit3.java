package unit3;

public class Unit3 {

    public static void main(String[] args) throws InterruptedException {
        SetUnit3<Integer> set = new SetUnit3<>(); // Инициализация синхронизированного множества

        Thread oneSet = new Thread(() -> { // Создание первого потока
            for (int i = 0; i < 1000; i++) {
                set.add(i); // Добавление значения в множество
            }
        });

        Thread twoSet = new Thread(() -> { // Создание второго потока
            for (int i = 0; i < 1000; i++) {
                set.add(i + 1000); // Добавление значения в множество
            }
        });

        // Запуск потоков
        oneSet.start();
        twoSet.start();
        Thread.sleep(3000); // Ожидание
        System.out.println("Set contains " + set.size() + " values"); // Вывод результата

        MapUnit3<String, Integer> map = new MapUnit3<>(); // инициализация словаря

        Thread oneMap = new Thread(() -> { // Создание первого потока
           for (int i = 0; i < 1000; i++) {
               map.put("key" + i, i); // Добавление ключа и значеиня
           }
        });

        Thread twoMap = new Thread(() -> { // Создание второго потока
            for (int i = 0; i < 1000; i++) {
                map.put("key" + i + 1000, i + 1000); // Добавление ключа и значеиня
            }
        });

        // Запуск потоков
        oneMap.start();
        twoMap.start();
        Thread.sleep(3000); // Ожидание
        System.out.println("Map contains " + map.size() + " keys and values"); // Вывод результатов
    }
}
