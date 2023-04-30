package ua.lviv.iot.algo.part1.reader;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.InputMismatchException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ReaderTest {
    private Reader reader = new Reader();
    @Test
    public void testReadTextFromConsole() {
        String input = "some text _with under_scores_";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        String result = reader.readTextFromConsole();
        assertEquals(input, result);
    }

    @Test
    public void readMaximumWordLengthInputNumber() {
        String input = "10";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        int result = reader.readMaximumWordLength();
        assertEquals(Integer.parseInt(input), result);
    }

    @Test
    public void readMaximumWordLengthInputNotNumber() {
        String input = "some text";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThrows(InputMismatchException.class,() -> reader.readMaximumWordLength());
    }
}
