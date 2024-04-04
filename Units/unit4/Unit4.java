package unit4;

import java.util.concurrent.Future;

public class Unit4 {

    public static void main(String[] args) {
        MyExecutorService exService = new MyExecutorService(2); // Инициализация exService с 2 рабочими потоками

        Future f = exService.submit(() -> { // Запуск функции в первом потоке
            try {
                Thread.sleep(20000);
                System.out.println("20 seconds sleep");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        exService.submit(() -> { // Запуск функции во втором потоке
            try {
                Thread.sleep(4000);
                System.out.println("4 seconds sleep");
                f.cancel(true); // Отмена выполнения функции в первом потоке
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        exService.submit(() -> { // Запуск функции в первом (теперь свободном) потоке
            try {
                Thread.sleep(3000);
                System.out.println("3 seconds sleep");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        exService.submit(() -> { // Отправка функции в очередь на исполнения каким либо потоком
            try {
                Thread.sleep(2000);
                System.out.println("2 seconds sleep");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        exService.shutdown(); // Завершение exService после выполнения всех функций

    }
}
