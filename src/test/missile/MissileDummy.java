package missile;

public class MissileDummy implements Missile {
    @Override
    public void launch() {
        throw new RuntimeException();
    }

    @Override
    public void disable() {

    }
}
