package ua.lviv.iot.algo.part1.reader;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class ReaderTest {
    @Test
    public void testReadTextFromConsole(){
        String input = "some text _with under_scores_";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        String result = Reader.readTextFromConsole();
        assertEquals(input, result);
    }

    @Test
    public void readMaximumWordLengthInputNumber(){
        String input = "10";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        int result = Reader.readMaximumWordLength();
        assertEquals(Integer.parseInt(input), result);
    }

    @Test
    public void readMaximumWordLengthInputNotNumber(){
        String input = "some text _with under_scores_";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThrows(NumberFormatException.class, Reader::readMaximumWordLength);
    }
}