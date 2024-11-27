package demo;

public enum PosStrategies implements PositionGenerator{
    AI(new RandomPos()),
    HUMAN(new InteractUtil()),
    ;

    private PositionGenerator posGen;

    PosStrategies(PositionGenerator posGen) {
        this.posGen = posGen;
    }

    @Override
    public int getPosition(int max) {
        return  this.posGen.getPosition(max);
    }
}
