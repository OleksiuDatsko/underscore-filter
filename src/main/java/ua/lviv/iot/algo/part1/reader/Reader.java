package ua.lviv.iot.algo.part1.reader;

import java.util.Scanner;

public class Reader {
    public static String readTextFromConsole(){
        System.out.print("Enter a text: ");
        return new Scanner(System.in).nextLine();
    }

    public static int readMaximumWordLength(){
        System.out.print("Enter max word length (int number): ");
        try {
            return Integer.parseInt(new Scanner(System.in).nextLine());
        } catch (NumberFormatException e){
            System.out.println("Invalid input");
            throw (e);
        }
    }
}
