package pl.edu.wszib.datetime.java8;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Ex2 {
    public static void main(String[] args) {
        ZoneId zoneId = ZoneId.of("America/New_York");
        ZonedDateTime zonedDateTime = ZonedDateTime.now(zoneId);
        System.out.println("CURRENT TIME IN NEW YORK: " + zonedDateTime);
    }
}
