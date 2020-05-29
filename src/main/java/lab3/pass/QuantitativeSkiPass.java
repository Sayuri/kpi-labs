package lab3.pass;

import java.time.LocalTime;

public class QuantitativeSkiPass extends AbstractSkiPass {

    private int passQuantity;

    public QuantitativeSkiPass(String cardID, int passQuantity, SkiPassType passType) {
        super(cardID, passType);
        this.passQuantity = passQuantity;
    }

    public int getPassQuantity() {
        return passQuantity;
    }

    @Override
    public boolean use(LocalTime now) {
        if (!isExpired() && !isBlocked() && passQuantity > 0) {
            decreasePassQuantityByOne();
            return true;
        }
        return false;
    }

    public void decreasePassQuantityByOne() {
        if(passQuantity > 0) {
            passQuantity--;
        }
    }
}
