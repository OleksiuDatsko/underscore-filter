package ua.lviv.iot.algo.part1.reader;

import java.nio.charset.StandardCharsets;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Reader {
    public String readTextFromConsole() {
        System.out.print("Enter a text: ");
        try (Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8)) {
            return scanner.nextLine();
        }
    }

    public int readMaximumWordLength() {
        System.out.print("Enter maximum word length: ");
        try (Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8)) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input");
                throw e;
            }
        }
    }
}
