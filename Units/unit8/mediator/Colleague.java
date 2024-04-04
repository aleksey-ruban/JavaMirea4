package unit8.mediator;

abstract public class Colleague {
    protected Mediator mediator;

    public Colleague(Mediator mediator) {
        this.mediator = mediator;
    }

    // Метод для отправки сообщения через посредника
    public void sendMessage(String message) {
        mediator.sendMessage(message, this);
    }

    // Абстрактный метод для получения сообщения
    public abstract void receiveMessage(String message);
}
