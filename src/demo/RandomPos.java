package demo;

public class RandomPos implements PositionGenerator{
    @Override
    public int getPosition(int max) {
        return Math.subtractExact(0, max);
    }
}
