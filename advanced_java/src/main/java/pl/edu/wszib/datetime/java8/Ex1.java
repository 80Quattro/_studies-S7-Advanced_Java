package pl.edu.wszib.datetime.java8;

import java.time.Clock;
import java.time.LocalDateTime;

public class Ex1 {

    public static void main(String[] args) {
        Clock clock = Clock.systemDefaultZone();
        LocalDateTime localDateTime = LocalDateTime.now(clock);
        System.out.println("YEAR: " + localDateTime.getYear());
        System.out.println("MONTH: " + localDateTime.getMonth());
        System.out.println("DAY: " + localDateTime.getDayOfMonth());
        System.out.println("HOUR: " + localDateTime.getHour());
        System.out.println("MINUTE: " + localDateTime.getMinute());
        System.out.println("SECOND: " + localDateTime.getSecond());
        System.out.println("DAY OF WEEK: " + localDateTime.getDayOfWeek());
        System.out.println("DAY OF YEAR: " + localDateTime.getDayOfYear());
        System.out.println("MONTH VALUE: " + localDateTime.getMonthValue());
        System.out.println("NANO: " + localDateTime.getNano());
    }

}
