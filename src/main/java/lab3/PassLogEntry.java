package lab3;

import lab3.pass.SkiPass;

import java.time.LocalTime;

public class PassLogEntry {
    public enum LogEntryType {
        ALLOWED, REFUSED
    }

    private LogEntryType type;
    private LocalTime time;
    private SkiPass pass;

    public PassLogEntry(LogEntryType type, LocalTime time, SkiPass pass) {
        this.type = type;
        this.time = time;
        this.pass = pass;
    }

    public LogEntryType getType() {
        return type;
    }

    public void setType(LogEntryType type) {
        this.type = type;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public SkiPass getPass() {
        return pass;
    }

    public void setPass(SkiPass pass) {
        this.pass = pass;
    }
}
