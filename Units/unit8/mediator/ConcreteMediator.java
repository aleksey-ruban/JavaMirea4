package unit8.mediator;

import java.util.ArrayList;
import java.util.List;

public class ConcreteMediator implements Mediator {
    private List<Colleague> colleagues;

    public ConcreteMediator() {
        colleagues = new ArrayList<>();
    }

    public void addColleague(Colleague colleague) {
        colleagues.add(colleague);
    }

    @Override
    public void sendMessage(String message, Colleague sender) {
        for (Colleague colleague : colleagues) {
            // Игнорируем отправителя сообщения
            if (colleague != sender) {
                colleague.receiveMessage(message);
            }
        }
    }
}
