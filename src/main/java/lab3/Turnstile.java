package lab3;

import lab3.pass.QuantitativeSkiPass;
import lab3.pass.SkiPass;
import lab3.pass.SkiPassType;

import java.time.LocalTime;

public class Turnstile {

    public static boolean isPassAllowed(String cardID, LocalTime time) {
        SkiPass skiPass = CardRegistry.getCard(cardID);
        if (skiPass == null) {
            return false;
        }
        boolean result = skiPass.use(time);
        if (result && skiPass.getType() == SkiPassType.PREFERENTIAL) {
            warn();
        }
        if (result && skiPass.getType() == SkiPassType.VIP) {
            vip();
        }
        return result;
    }

    private static void warn() {
        System.out.println("Check permit");
    }

    private static void vip() {
        System.out.println("Let them pass first");
    }
}
