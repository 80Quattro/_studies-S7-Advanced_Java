package pl.edu.wszib.datetime.java8;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class Application {

    public static void main(String[] args) {
        Clock clock = Clock.systemDefaultZone();

        // Instant - represents moment in time (amount of seconds from 1970)
        Instant instant = Instant.now(clock);

        // Period/Duration
        System.out.println("Instant: " + instant);

        // methods like .plusSeconds create new object
        Instant newPlus1s = instant.plusSeconds(1);
        System.out.println("Instant: " + newPlus1s);

        // LocalDate, LocalTime, LocalDateTime
        LocalDate localDate = LocalDate.now(clock);
        System.out.println("LocalDate: " + localDate);
        LocalTime localTime = LocalTime.now(clock);
        System.out.println("LocalTime: " + localTime);
        LocalDateTime localDateTime = localDate.atTime(localTime);
        System.out.println("LocalDateTime: " + localDateTime);
        LocalDateTime localDateTime1 = LocalDateTime.now(clock);
        // returns ISO 8601 format used in many other technologies

        // OffsetDateTime
        OffsetDateTime offsetDateTime = OffsetDateTime.now(clock);
        System.out.println("OffsetDateTime: " + offsetDateTime);
        offsetDateTime.toOffsetTime();

        // ZonedDateTime
        ZonedDateTime zonedDateTime = offsetDateTime.toZonedDateTime();
        ZonedDateTime zonedDateTime1 = ZonedDateTime.now(clock);
        System.out.println("ZonedDateTime: " + zonedDateTime);
        System.out.println("ZonedDateTime: " + zonedDateTime1);

        // Period, Duration
        Period period = Period.of(1, 1, 1);
        System.out.println("Period: " + period);
        Duration duration = Duration.ofDays(1);
        System.out.println("Duration: " + duration);
        Duration duration1 = Duration.ofMinutes(1);
        System.out.println("Duration: " + duration1);
        Duration duration2 = Duration.ofSeconds(1);
        System.out.println("Duration: " + duration2);
    }

}
