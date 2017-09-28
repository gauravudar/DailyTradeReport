
package main.java.com.jpmorgan;

import org.joda.time.DateTimeConstants;
import org.joda.time.LocalDate;

public class BusinessDateProvider {
    public static final String AED = "AED";
    public static final String SAR = "SAR";

    /**
     * Validate Settlement date for a Currency if its a valid business day or falls on weekend
     * @param Currency of the trade, Settlement date of the Trade
     * @return Business Settlement date 
    */
    public LocalDate validateBusinessDateForWeekend(String currency, LocalDate settlementDate) {
        LocalDate result = isWeekEnd(currency,settlementDate) ? getNextBusinessDate(currency,settlementDate) : settlementDate;

        return result;
    }

    private static boolean isWeekEnd(String currency,LocalDate date) {
        int dayOfWeek = date.getDayOfWeek();
        if(AED.equals(currency) || SAR.equals(currency)){
            return dayOfWeek == DateTimeConstants.FRIDAY || dayOfWeek == DateTimeConstants.SATURDAY;
        }
        return dayOfWeek == DateTimeConstants.SATURDAY || dayOfWeek == DateTimeConstants.SUNDAY;
    }

    private LocalDate getNextBusinessDate(String currency,LocalDate date) {
        while (isWeekEnd(currency,date)) {
            date = date.plusDays(1);
        }
        return date;
    }
}
