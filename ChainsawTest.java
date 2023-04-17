package ua.lviv.iot.algo.part1.lab1;

import main.java.ua.lviv.iot.algo.part1.lab1.Chainsaw;
import main.java.ua.lviv.iot.algo.part1.lab1.Saw;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class ChainsawTest {
    private Chainsaw chainsaw = new Chainsaw();

    @Test
    void charge() {
        Chainsaw chainsaw = new Chainsaw();
        chainsaw.setFuelLevel(0.2);
        assertEquals(1.4, chainsaw.charge(1.2));
    }

    @Test
    void convertToString() {
        Chainsaw chainsaw = new Chainsaw();
        assertNotEquals(chainsaw, chainsaw.convertToString());
    }
    @Test
    void start() {
        Chainsaw chainsaw = new Chainsaw();
        chainsaw.start();
        assertEquals(true, chainsaw.getWorking());
    }

    @Test
    void stop() {
        Chainsaw chainsaw = new Chainsaw();
        chainsaw.stop();
        assertEquals(false, chainsaw.getWorking());
    }

    @Test
    void getRemainingWorkTime() {
        Chainsaw chainsaw = new Chainsaw();
        chainsaw.setFuelLevel(3.0);
        assertEquals(5.0, chainsaw.getRemainingWorkTime());
    }
    @Test
    void writeToFile() {
        Chainsaw chainsaw1 = new Chainsaw("T-1000", 900, false, 4.5, 3.2, 3.0);
        Chainsaw chainsaw2 = new Chainsaw("T-800", 1000, false, 3.5, 2.9, 2.8);
        List<Saw> saws = Arrays.asList(chainsaw1, chainsaw2);
        chainsaw.writeToFile(saws);
        String EXPECTED_FILENAME = "chainExample.csv";
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