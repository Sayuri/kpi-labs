package lab3;

import lab3.pass.*;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CardRegistry {

    private static List<PassLogEntry> log = new ArrayList<>();

    private static Map<String, SkiPass> skiPasses = new HashMap<String, SkiPass>() {{
        put("ranok-1533", new MorningSkiPass("ranok-1533", SkiPassType.PREFERENTIAL));
        put("vechir-4758", new EveningSkiPass("vechir-4758", SkiPassType.BASIC));
        put("nich-8891", new NightSkiPass("nich-8891", SkiPassType.BASIC));
        put("kilk-0334", new QuantitativeSkiPass("kilk-0334",10, SkiPassType.VIP));
    }};

    public static SkiPass getCard(String cardID) {
        return skiPasses.get(cardID);
    }

    public static void logAttempt(SkiPass pass, LocalTime now, boolean success) {
        PassLogEntry.LogEntryType type = success
                ? PassLogEntry.LogEntryType.ALLOWED
                : PassLogEntry.LogEntryType.REFUSED;
        log.add(new PassLogEntry(type, now, pass));
    }

    public static void blockCard(String cardId) {
        SkiPass skiPass = skiPasses.get(cardId);
        if (skiPass != null) {
            skiPass.setBlocked(true);
        }
    }

    private static SkiPass createTimeBasedCard(String cardID,
                                               SkiPassTimeBasedType timeBasedType,
                                               SkiPassType passType) {
        switch (timeBasedType) {
            case MORNING: return new MorningSkiPass(cardID, passType);
            case EVENING: return new EveningSkiPass(cardID, passType);
            case NIGHT: return new NightSkiPass(cardID, passType);
        }

        throw new RuntimeException("Invalid time-based pass type");
    }

    public static SkiPass issueTimeBasedCard(String cardID,
                                             SkiPassTimeBasedType timeBasedType,
                                             SkiPassType passType) {
        SkiPass pass = createTimeBasedCard(cardID, timeBasedType, passType);
        skiPasses.put(cardID, pass);
        return pass;
    }

    public static SkiPass issueQuantityBasedCard(String cardID,
                                                 int quantity,
                                                 SkiPassType passType) {
        QuantitativeSkiPass pass = new QuantitativeSkiPass(cardID, quantity, passType);
        skiPasses.put(cardID, pass);
        return pass;
    }

    public static List<PassLogEntry> getLog() {
        return log;
    }

    public static List<PassLogEntry> getLog(String cardID) {
        List<PassLogEntry> result = new ArrayList<>();
        for (PassLogEntry entry : log) {
            if (entry.getPass().getCardID().equals(cardID)) {
                result.add(entry);
            }
        }
        return result;
    }

    public static List<PassLogEntry> getLog(SkiPassType passType) {
        List<PassLogEntry> result = new ArrayList<>();
        for (PassLogEntry entry : log) {
            if (entry.getPass().getType().equals(passType)) {
                result.add(entry);
            }
        }
        return result;
    }
}
