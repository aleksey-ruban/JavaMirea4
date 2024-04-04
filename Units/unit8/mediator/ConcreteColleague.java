package unit8.mediator;

public class ConcreteColleague extends Colleague {

    private int id;

    public ConcreteColleague(Mediator mediator, int id) {
        super(mediator);
        this.id = id;
    }

    @Override
    public void receiveMessage(String message) {
        System.out.println("Message to " + id + ": " + message);
    }
}
