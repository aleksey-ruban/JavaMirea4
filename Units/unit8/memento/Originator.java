package unit8.memento;

public class Originator {

    private String state;

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    // Создаем метод для создания снимка состояния
    public Memento saveStateToMemento() {
        return new Memento(state);
    }

    // Метод для восстановления состояния из снимка
    public void getStateFromMemento(Memento memento) {
        state = memento.getState();
    }

}
