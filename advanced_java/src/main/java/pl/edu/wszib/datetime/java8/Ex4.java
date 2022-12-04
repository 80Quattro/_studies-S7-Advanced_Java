package pl.edu.wszib.datetime.java8;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDate;

public class Ex4 {

    public static void main(String[] args) {
        System.out.println(getStartAndEndOfPreviousMonth());
    }

    public static Pair getStartAndEndOfPreviousMonth() {
        Clock clock = Clock.systemDefaultZone();
        LocalDate localDate = LocalDate.now(clock);

        LocalDate from = localDate.minusMonths(1);
        from = from.withDayOfMonth(1);

        LocalDate to = localDate.minusMonths(1);
        to = to.withDayOfMonth(to.lengthOfMonth());

        Integer diff = to.getDayOfMonth() - from.getDayOfMonth();

        return new Pair(from, to, diff);
    }

    public record Pair(LocalDate from, LocalDate to, Integer diff) {

    }

}