package pl.edu.wszib.datetime;

import java.util.Calendar;
import java.util.Date;

public class Application {

    public static void main(String[] args) {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        System.out.println("Day of month = " + calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println("Date = " + date);
        System.out.println("Date from calendar = " + calendar.getTime());

        calendar.set(Calendar.DAY_OF_MONTH, 21);
        System.out.println("Day of month = " + calendar.get(Calendar.DAY_OF_MONTH));
        // Calendar creates copy od date object
        System.out.println("Date original = " + date);
        System.out.println("Date from calendar = " + calendar.getTime());
        // JodaTime - library often used before Java 8

        System.out.println();
        System.out.println();

        // This api ist mutable! - changes original calendar object
        System.out.println("Calendar = " + calendar.getTime());
        calculate(calendar);
        System.out.println("Calendar = " + calendar.getTime());
    }

    private static Integer calculate(Calendar calendar) {
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) + 7);
        //some calculation
        return 10;
    }

}
