package lab3.pass;

import java.time.LocalTime;

public class NightSkiPass extends AbstractSkiPass {

    LocalTime start = LocalTime.parse( "19:00:00" );
    LocalTime end = LocalTime.parse( "23:59:59" );

    public NightSkiPass(String cardID, SkiPassType passType) {
        super(cardID, passType);
    }

    public boolean isActive(LocalTime now) {
        return (now.isAfter(start) && now.isBefore(end));
    }

    @Override
    public boolean use(LocalTime now) {
        return !isExpired() && !isBlocked() && isActive(now);
    }

}
