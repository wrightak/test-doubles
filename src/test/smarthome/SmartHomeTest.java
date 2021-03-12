package smarthome;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartHomeTest {

    @Test
    public void turnBulbOn_whenSwitchIsOn() {
        BulbSpy bulbSpy = new BulbSpy();
        SwitchOnStub switchOnStub = new SwitchOnStub();

        new SmartHome().run(bulbSpy, switchOnStub);

        assertTrue(bulbSpy.turnOn_wasCalled());
    }

    @Test
    void turnBulbOff_whenSwitchIsOff() {
        BulbSpy bulbSpy = new BulbSpy();
        SwitchOffStub switchOffStub = new SwitchOffStub();

        new SmartHome().run(bulbSpy, switchOffStub);

        assertTrue(bulbSpy.turnOff_wasCalled());
    }
}

// OPTION RETURN - カーソルにあるエラーやWarningのヘルプ

// CTRL SHIFT R - カーソルの位置を参考にして実行
// CTRL R - 前回実行したrun configurationを再実行
// CTRL OPTION R - 今まで実行したrun configurationを選択

// CMD SHIFT T - Testファイルを作ったり、実行とテストを切り替えたりする
