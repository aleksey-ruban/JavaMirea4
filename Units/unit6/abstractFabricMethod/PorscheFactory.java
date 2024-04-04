package unit6.abstractFabricMethod;

public class PorscheFactory implements AutoFactory {
    @Override
    public Liftback createLiftback() {
        return new PorscheLiftback();
    }

    @Override
    public Crossover createCrossover() {
        return new PorscheCrossover();
    }
}
