package ua.lviv.iot.algo.part1.lab1;

import main.java.ua.lviv.iot.algo.part1.lab1.CircularSaw;
import main.java.ua.lviv.iot.algo.part1.lab1.Saw;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class CircularSawTest {
    CircularSaw circularSaw = new CircularSaw();

    @Test
    void convertToString() {
        CircularSaw circularSaw = new CircularSaw();
        assertNotEquals(circularSaw, circularSaw.convertToString());
    }

    @Test
    void start() {
        CircularSaw circularSaw = new CircularSaw();
        circularSaw.start();
        assertEquals(true, circularSaw.getWorking());
    }

    @Test
    void stop() {
        CircularSaw circularSaw = new CircularSaw();
        circularSaw.stop();
        assertEquals(false, circularSaw.getWorking());
    }

    @Test
    void getRemainingWorkTime() {
        CircularSaw circularSaw = new CircularSaw();
        assertEquals(8, circularSaw.getRemainingWorkTime());
    }
    @Test
    void writeToFile() {
        CircularSaw circularSaw1 = new CircularSaw("T-1000", 900, false, 4.5, 3.2, 3.0);
        CircularSaw circularSaw2 = new CircularSaw("T-800", 1000, false, 3.5, 2.9, 2.8);
        List<Saw> saws = Arrays.asList(circularSaw1, circularSaw2);
        circularSaw.writeToFile(saws);
        String EXPECTED_FILENAME = "circularExample.csv";
        String RESULT_FILENAME = "result.csv";
        Path expected = new File(EXPECTED_FILENAME).toPath();
        Path result = new File(RESULT_FILENAME).toPath();
        try{
            assertEquals(-1L, Files.mismatch(expected, result));
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}