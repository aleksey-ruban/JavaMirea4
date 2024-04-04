package unit6.factoryMethod;

public class AutoFactory {
    public Auto createAuto(AutoType autoType) {
        Auto auto;
        switch (autoType) {
            case SEDAN:
                auto = new Sedan();
                break;
            case LIFTBACK:
                auto = new Liftback();
                break;
            case CROSSOVER:
                auto = new Crossover();
                break;
            default:
                auto = new Auto();
        }
        return auto;
    }
}
