package service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Service {

    private static final Date today;
    private static final Date tomorrow;
    private static final DateFormat dateFormatIn;
    private static final DateFormat dateFormatOut;

    static {
        Calendar calendar = Calendar.getInstance();
        today = calendar.getTime();
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        tomorrow = calendar.getTime();
        dateFormatIn = new SimpleDateFormat("dd-е MMMM yyyy г.");
        dateFormatOut = new SimpleDateFormat("dd MMMM");
    }


    public static String getTodayFormatIn() {
        return dateFormatIn.format(today);
    }
    public static String getTodayFormatOut() {
        return dateFormatOut.format(today);
    }

    public static String getTomorrowFormatIn() {
        return dateFormatIn.format(tomorrow);
    }
    public static String getTomorrowFormatOut() {
        return dateFormatOut.format(tomorrow);
    }


}
