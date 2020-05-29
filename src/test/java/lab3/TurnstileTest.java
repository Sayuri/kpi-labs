package lab3;

import lab3.pass.SkiPass;
import lab3.pass.SkiPassTimeBasedType;
import lab3.pass.SkiPassType;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

public class TurnstileTest {

    @Test
    void isPassAllowedForTimeBasedCardsTest() {
        SkiPass testSkiPassMorning = CardRegistry.issueTimeBasedCard("test-morning-pass-id",
                SkiPassTimeBasedType.MORNING,
                SkiPassType.BASIC);
        assertTrue(Turnstile.isPassAllowed("test-morning-pass-id", LocalTime.NOON));
        assertFalse(Turnstile.isPassAllowed("test-morning-pass-id", LocalTime.MIDNIGHT));

        SkiPass testSkiPassNight = CardRegistry.issueTimeBasedCard("test-night-pass-id",
                SkiPassTimeBasedType.NIGHT,
                SkiPassType.BASIC);
        assertFalse(Turnstile.isPassAllowed("test-night-pass-id", LocalTime.NOON));

    }

    @Test
    void isPassAllowedForQuantityBasedCardsTest() {
        SkiPass testSkiPassQuantity = CardRegistry.issueQuantityBasedCard("test-quantity-pass-id",
                10,
                SkiPassType.BASIC);
        assertTrue(Turnstile.isPassAllowed("test-quantity-pass-id", LocalTime.now()));
    }

    @Test
    void passIsNotAllowedForQuantityBasedCardsWithNoQuantity() {
        SkiPass testSkiPassQuantity = CardRegistry.issueQuantityBasedCard("test--no-quantity-pass-id",
                0,
                SkiPassType.BASIC);
        assertFalse(Turnstile.isPassAllowed("test-quantity-pass-id", LocalTime.now()));
    }

}
