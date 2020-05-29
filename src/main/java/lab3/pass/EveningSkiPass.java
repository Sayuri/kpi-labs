package lab3.pass;

import java.time.LocalTime;

public class EveningSkiPass extends AbstractSkiPass {

    LocalTime start = LocalTime.parse("09:00:00");
    LocalTime end = LocalTime.parse("13:59:59");

    public EveningSkiPass(String cardID, SkiPassType passType) {
        super(cardID, passType);
    }

    @Override
    public boolean use(LocalTime now) {
        return !isExpired() && !isBlocked() && isActive(now);
    }

    public boolean isActive(LocalTime now) {
        return (now.isAfter(start) && now.isBefore(end));
    }


}
