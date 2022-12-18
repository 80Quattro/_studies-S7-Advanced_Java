package pl.edu.wszib.stream;

import java.util.Optional;

public class Ex01 {

    public static void main(String[] args) {

        Person person1 = new Person(
                "Peter",
                Optional.empty()
        );

        Person person2 = new Person(
                "Robin",
                Optional.of(new Address(
                        Optional.empty(),
                        "41403",
                        "Cracow",
                        10,
                        Optional.empty()
                ))
        );

        Person person3 = new Person(
                "John",
                Optional.of(new Address(
                        Optional.of("Krakowska"),
                        "21233",
                        "Gdow",
                        12,
                        Optional.of(4)
                ))
        );

    }

    record Person(
            String name,
            Optional<Address> address
    ) {}

    record Address(
            Optional<String> street,
            String postalCode,
            String city,
            Integer buildingNumber,
            Optional<Integer> flatNumber
    ) {}

}
