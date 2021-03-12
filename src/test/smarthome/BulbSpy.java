package smarthome;

public class BulbSpy implements Bulb {
    private boolean turnOn_wasCalled = false;
    private boolean turnOff_wasCalled = false;

    @Override
    public void turnOn() {
        turnOn_wasCalled = true;
    }

    @Override
    public void turnOff() {
        turnOff_wasCalled = true;
    }

    public boolean turnOn_wasCalled() {
        return turnOn_wasCalled;
    }

    public boolean turnOff_wasCalled() {
        return turnOff_wasCalled;
    }
}
