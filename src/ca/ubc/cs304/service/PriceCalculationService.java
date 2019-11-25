package ca.ubc.cs304.service;

import ca.ubc.cs304.domain.*;

public class PriceCalculationService {
    public int calculatePrice(Rate rate, TimeInterval timeInterval) {
        int dateDiff = timeInterval.getDateDifference();
        int weekDiff = dateDiff / 7;
        int dayDiff = dateDiff % 7;
        int hourDiff = timeInterval.getHourDifference();
        return rate.getWeekRate() * weekDiff + rate.getDayRate() * dayDiff + rate.getHourRate() * hourDiff;
    }

    public int calculateDistanceRate(int kmRate, int odometerBeg, int odometerEnd) {
        return kmRate * (odometerEnd - odometerBeg);
    }
}
