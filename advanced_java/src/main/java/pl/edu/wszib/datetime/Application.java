package pl.edu.wszib.datetime;

import pl.edu.wszib.datetime.java8.Ex3;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Application {

    public static void main(String[] args) {

        /*
            Before Java8
        */
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

        // ex1 - print all current date info (day, month, year, hour...)
        System.out.println();
        System.out.println("ex1 - print all current date info (day, month, year, hour...)");
        Calendar now = Calendar.getInstance();
        now.setTime(new Date());
        System.out.println(showDate(now));

        // ex2 - get current time in NewYork timezone
        System.out.println();
        System.out.println("ex2 - get current time in NewYork timezone");
        Calendar newYork = Calendar.getInstance(TimeZone.getTimeZone("America/New_York"));
        newYork.setTime(new Date());
        System.out.println(newYork.get(Calendar.YEAR) + "-" + newYork.get(Calendar.MONTH) + "-" + newYork.get(Calendar.DAY_OF_MONTH) +
                " " + newYork.get(Calendar.HOUR) + ":" + newYork.get(Calendar.MINUTE) + ":" + newYork.get(Calendar.SECOND));

        // ex3 - create a method which returns object with to fields: "from" and "to", the fields should contain
        //      the beggining and the end of last month
        getStartAndEndOfPrevMonth();
    }

    private static Integer calculate(Calendar calendar) {
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) + 7);
        //some calculation
        return 10;
    }

    private static String showDate(Calendar calendar) {
        return calendar.get(Calendar.YEAR) + "-" + calendar.get(Calendar.MONTH) + "-" + calendar.get(Calendar.DAY_OF_MONTH) +
                " " + calendar.get(Calendar.HOUR) + ":" + calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND);
    }

    private static Pair getStartAndEndOfPrevMonth() {
        Date date = new Date();

        Calendar from = Calendar.getInstance();
        from.setTime(date);
        from.set(Calendar.MONTH, from.get(Calendar.MONTH) - 1);
        from.set(Calendar.DAY_OF_MONTH, from.getActualMinimum(Calendar.DAY_OF_MONTH));

        Calendar to = Calendar.getInstance();
        to.setTime(date);
        to.set(Calendar.MONTH, to.get(Calendar.MONTH) - 1);
        to.set(Calendar.DAY_OF_MONTH, to.getActualMaximum(Calendar.DAY_OF_MONTH));

        return new Pair(from, to);
    }

    private static record Pair(Calendar from, Calendar to) {

    }

}
