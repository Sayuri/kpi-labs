package lab3.pass;

import java.time.LocalTime;

public interface SkiPass {
    boolean use(LocalTime now);
    boolean isExpired();
    void setExpired(boolean expired);
    boolean isBlocked();
    void setBlocked(boolean blocked);
    String getCardID();
    SkiPassType getType();
}
