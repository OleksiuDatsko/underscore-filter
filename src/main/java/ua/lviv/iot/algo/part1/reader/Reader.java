package ua.lviv.iot.algo.part1.reader;

import java.nio.charset.StandardCharsets;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Reader {
    public static String readTextFromConsole() {
        System.out.print("Enter a text: ");
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        return scanner.nextLine();
    }

    public static int readMaximumWordLength() {
        System.out.print("Enter maximum word length: ");
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input");
            throw (e);
        }
    }
}
