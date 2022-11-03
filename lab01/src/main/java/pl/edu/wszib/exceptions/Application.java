package pl.edu.wszib.exceptions;

import java.io.FileWriter;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Random;

public class Application {

    public static void main(String[] args) {
        new Application().run();
    }

    private void run() {
        try {
            exampleCheckedExceptionThrow();
            exampleUncheckedExceptionThrow();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            filesExample();
        } catch (UncheckedIOException e) {
            System.out.println(e);
        }

        filesAutocloseable();
        System.out.println();
        filesAutocloseable();
    }

    private void exampleCheckedExceptionThrow() throws Exception {
        if (new Random().nextBoolean()) {
            throw new Exception("Checked exception.");
        }
    }

    private void exampleUncheckedExceptionThrow() {
        if (new Random().nextBoolean()) {
            throw new RuntimeException("Unchecked exception.");
        }
    }

    private void filesExample() {
        try {
            byte[] bytes = Files.readAllBytes(Paths.get("test.txt"));
        } catch (NoSuchFileException e) {
//            throw new UncheckedIOException(e);
        } catch (IOException | UncheckedIOException e) {
            throw new RuntimeException(e);
        } finally {
            //
        }
    }

    private void filesAutocloseable() {
        try (FileWriter fileWriter = new FileWriter("test2.txt")) {
            fileWriter.write("test");
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}