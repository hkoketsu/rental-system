package ca.ubc.cs304.domain;

public class Rate {
    private int weekRate;
    private int dayRate;
    private int hourRate;

    public Rate(int weekRate, int dayRate, int hourRate) {
        this.weekRate = weekRate;
        this.dayRate = dayRate;
        this.hourRate = hourRate;
    }

    public int getWeekRate() {
        return weekRate;
    }

    public int getDayRate() {
        return dayRate;
    }

    public int getHourRate() {
        return hourRate;
    }
}
