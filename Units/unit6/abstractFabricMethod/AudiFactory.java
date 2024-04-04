package unit6.abstractFabricMethod;

public class AudiFactory implements AutoFactory {

    @Override
    public Liftback createLiftback() {
        return new AudiLiftback();
    }

    @Override
    public Crossover createCrossover() {
        return new AudiCrossover();
    }
}
