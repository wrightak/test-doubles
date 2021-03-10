package missile;

import org.junit.jupiter.api.Test;

import static missile.MissileLauncher.launchMissile;
import static org.junit.jupiter.api.Assertions.assertFalse;

class MissileLauncherTest {

    @Test
    public void givenExpiredLaunchCodes_MissileIsNotLaunched_dummy() {
        UsedLaunchCodes fakeUsedLaunchCodes = new FakeUsedLaunchCodes();
        LaunchCode expiredLaunchCode = new ExpiredLaunchCodeStub();

        launchMissile(new MissileDummy(), expiredLaunchCode, fakeUsedLaunchCodes);
    }

    @Test
    public void givenExpiredLaunchCodes_MissileIsNotLaunched_spy() {
        UsedLaunchCodes fakeUsedLaunchCodes = new FakeUsedLaunchCodes();
        LaunchCode expiredLaunchCode = new ExpiredLaunchCodeStub();
        MissileSpy missileSpy = new MissileSpy();

        launchMissile(missileSpy, expiredLaunchCode, fakeUsedLaunchCodes);

        assertFalse(missileSpy.launchWasCalled());
    }

    @Test
    public void givenExpiredLaunchCodes_CodeRedAbort_mock() {
        UsedLaunchCodes fakeUsedLaunchCodes = new FakeUsedLaunchCodes();
        LaunchCode expiredLaunchCode = new ExpiredLaunchCodeStub();
        MissileMock missileMock = new MissileMock();

        launchMissile(missileMock, expiredLaunchCode, fakeUsedLaunchCodes);

        missileMock.verifyCodeRedAbort();
    }

    @Test
    public void givenUnsignedLaunchCodes_CodeRedAbort_mock() {
        UsedLaunchCodes fakeUsedLaunchCodes = new FakeUsedLaunchCodes();
        LaunchCode unsignedLaunchCode = new UnsignedLaunchCodeStub();
        MissileMock missileMock = new MissileMock();

        launchMissile(missileMock, unsignedLaunchCode, fakeUsedLaunchCodes);

        missileMock.verifyCodeRedAbort();
    }

    @Test
    void reusedLaunchCode_CodeRedAbort_fake() {
        UsedLaunchCodes usedLaunchCodes = new FakeUsedLaunchCodes();
        MissileMock firstMissile = new MissileMock();
        MissileMock secondMissile = new MissileMock();
        ValidLaunchCodeStub validLaunchCode = new ValidLaunchCodeStub();

        launchMissile(firstMissile, validLaunchCode, usedLaunchCodes);
        launchMissile(secondMissile, validLaunchCode, usedLaunchCodes);

        secondMissile.verifyCodeRedAbort();
    }
}