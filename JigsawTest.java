package ua.lviv.iot.algo.part1.lab1;

import org.junit.jupiter.api.Test;
import main.java.ua.lviv.iot.algo.part1.lab1.Jigsaw;
import main.java.ua.lviv.iot.algo.part1.lab1.Saw;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JigsawTest {
    Jigsaw jigsaw = new Jigsaw();

    @Test
    void convertToString() {
        Jigsaw jigsaw = new Jigsaw();
        assertNotEquals(jigsaw, jigsaw.convertToString());
    }

    @Test
    void start() {
        Jigsaw jigsaw = new Jigsaw();
        jigsaw.start();
        assertEquals(true, jigsaw.getWorking());
    }

    @Test
    void stop() {
        Jigsaw jigsaw = new Jigsaw();
        jigsaw.stop();
        assertEquals(false, jigsaw.getWorking());
    }

    @Test
    void getRemainingWorkTime() {
        Jigsaw jigsaw = new Jigsaw();
        assertEquals(8, jigsaw.getRemainingWorkTime());
    }
    @Test
    void writeToFile() {
        Jigsaw jigsaw1 = new Jigsaw("T-1000", 900, false, 4.5, 3.2, 3.0);
        Jigsaw jigsaw2 = new Jigsaw("T-800", 1000, false, 3.5, 2.9, 2.8);
        List<Saw> saws = Arrays.asList(jigsaw1, jigsaw2);
        jigsaw.writeToFile(saws);
        String EXPECTED_FILENAME = "jigsawExample.csv";
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