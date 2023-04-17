package ua.lviv.iot.algo.part1.lab1;

import main.java.ua.lviv.iot.algo.part1.lab1.ElectricSaw;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class ElectricSawTest {
    ElectricSaw electricSaw = new ElectricSaw();
    @Test
    void charge() {
        ElectricSaw electricSaw = new ElectricSaw();
        electricSaw.setBatteryCharge(69);
        assertEquals(79, electricSaw.charge(10));
    }

    @Test
    void convertToString() {
        ElectricSaw electricSaw = new ElectricSaw();
        assertNotEquals(electricSaw, electricSaw.convertToString());
    }

    @Test
    void start() {
        ElectricSaw electricSaw = new ElectricSaw();
        electricSaw.start();
        assertEquals(true, electricSaw.getWorking());
    }

    @Test
    void stop() {
        ElectricSaw electricSaw = new ElectricSaw();
        electricSaw.stop();
        assertEquals(false, electricSaw.getWorking());
    }

    @Test
    void getRemainingWorkTime() {
        ElectricSaw electricSaw = new ElectricSaw();
        electricSaw.setBatteryCharge(60);
        assertEquals(1.5, electricSaw.getRemainingWorkTime());
    }
    @Test
    void writeToFile() {
        ElectricSaw electricSaw1 = new ElectricSaw("T-1000", 900, false, 4.5, 60);
        ElectricSaw electricSaw2 = new ElectricSaw("T-800", 1000, false, 3.5, 90);
        List<main.java.ua.lviv.iot.algo.part1.lab1.Saw> saws = Arrays.asList(electricSaw1, electricSaw2);
        electricSaw.writeToFile(saws);
        String EXPECTED_FILENAME = "electricExample.csv";
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