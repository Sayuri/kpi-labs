package lab3.pass;

public abstract class AbstractSkiPass implements SkiPass {
    private final String cardID;
    private boolean isBlocked = false;
    private boolean isExpired = false;
    private SkiPassType passType;

    public AbstractSkiPass(String cardID, SkiPassType passType) {
        this.cardID = cardID;
        this.passType = passType;
    }

    @Override
    public boolean isExpired() {
        return isExpired;
    }

    @Override
    public void setExpired(boolean expired) {
        this.isExpired = expired;
    }

    @Override
    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
        this.isBlocked = blocked;
    }

    @Override
    public String getCardID() {
        return cardID;
    }

    @Override
    public SkiPassType getType() {
        return passType;
    }
}
