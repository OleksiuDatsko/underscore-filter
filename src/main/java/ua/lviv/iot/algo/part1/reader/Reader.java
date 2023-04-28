package ua.lviv.iot.algo.part1.reader;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Reader {
    public static String readTextFromConsole() {
        System.out.print("Enter a text: ");
        try(Scanner scanner = new  Scanner(System.in, StandardCharsets.UTF_8)){
            return scanner.nextLine();
        } catch (Exception e){
            e.printStackTrace();
            throw(e);
        }
    }

    public static int readMaximumWordLength() {
        System.out.print("Enter max word length (int number): ");
        try(Scanner scanner = new  Scanner(System.in, StandardCharsets.UTF_8)){
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input, max word length must be a number");
            throw (e);
        } catch (Exception e){
            e.printStackTrace();
            throw(e);
        }
    }
}
