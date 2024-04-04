package unit8;

import unit8.mediator.Colleague;
import unit8.mediator.ConcreteColleague;
import unit8.mediator.ConcreteMediator;
import unit8.mediator.Mediator;
import unit8.memento.Caretaker;
import unit8.memento.Originator;

public class Unit8 {
    public static void main(String[] args) {
        Mediator mediator = new ConcreteMediator();

        // Создаем коллег
        Colleague colleague1 = new ConcreteColleague(mediator, 1);
        Colleague colleague2 = new ConcreteColleague(mediator, 2);

        // Регистрируем коллег в посреднике
        ((ConcreteMediator) mediator).addColleague(colleague1);
        ((ConcreteMediator) mediator).addColleague(colleague2);

        // Отправляем сообщение от одного коллеги другому
        colleague1.sendMessage("Hello from colleague 1!");



        // Создаем объект Originator и устанавливаем его состояние
        Originator originator = new Originator();
        originator.setState("State1");

        // Создаем объект Caretaker и сохраняем состояние Originator
        Caretaker caretaker = new Caretaker();
        caretaker.setMemento(originator.saveStateToMemento());

        // Меняем состояние Originator
        originator.setState("State2");

        // Восстанавливаем сохраненное состояние
        originator.getStateFromMemento(caretaker.getMemento());

        System.out.println("Current State: " + originator.getState());
    }
}
