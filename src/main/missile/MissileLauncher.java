package missile;

public class MissileLauncher {
    static void launchMissile(Missile missile, LaunchCode launchCode, UsedLaunchCodes usedLaunchCodes) {
        if (!launchCode.isSigned() ||
                launchCode.isExpired() ||
                usedLaunchCodes.contains(launchCode)) {
            missile.disable();
        } else {
            missile.launch();
            usedLaunchCodes.add(launchCode);
        }
    }
}
