package ua.lviv.iot.algo.part1.lab1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import main.java.ua.lviv.iot.algo.part1.lab1.Chainsaw;
import main.java.ua.lviv.iot.algo.part1.lab1.Jigsaw;
import main.java.ua.lviv.iot.algo.part1.lab1.SawManager;
import main.java.ua.lviv.iot.algo.part1.lab1.Saw;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class SawManagerTest {
    @BeforeEach
    void createSawManager() {
        SawManager manager = new SawManager();
    }

    @Test
    void testFindAllWorking() {
        SawManager manager = new SawManager();
        Chainsaw chainsaw = new Chainsaw();
        chainsaw.setWorking(true);
        Jigsaw jigsaw = new Jigsaw();
        jigsaw.setWorking(false);
        manager.addSaw(chainsaw);
        manager.addSaw(jigsaw);
        List<Saw> saws = new ArrayList<>();
        saws.add(chainsaw);
        saws.add(jigsaw);
        for (int i = 0; i < saws.size(); i++){
            int j = 0;
            if (saws.get(i).getWorking() == true){
                assertEquals(saws.get(i), manager.findAllWorking().get(j));
            }
        }
    }
    @Test
    void testFindAllMorePowerfulThan() {
        SawManager manager = new SawManager();
        Chainsaw chainsaw = new Chainsaw();
        chainsaw.setPower(850);
        Jigsaw jigsaw = new Jigsaw();
        jigsaw.setPower(500);
        manager.addSaw(chainsaw);
        manager.addSaw(jigsaw);
        List<Saw> saws = new ArrayList<>();
        saws.add(chainsaw);
        saws.add(jigsaw);
        for (int i = 0; i < saws.size(); i++){
            int j = 0;
            if (saws.get(i).getPower() >= 600){
                assertEquals(saws.get(i), manager.findAllMorePowerfulThan(600).get(j));
            }
        }
    }
    @Test
    void checkIfNull(){
        SawManager manager = new SawManager();
        manager.addSaw(null);
        assertEquals(null, manager.getSaws().get(0));
    }
    @Test
    void findEmptyList(){
        SawManager manager = new SawManager();
        Chainsaw chainsaw = new Chainsaw();
        Jigsaw jigsaw = new Jigsaw();
        chainsaw.stop();
        jigsaw.stop();
        List<Saw> saws = new ArrayList<>();
        assertEquals(saws, manager.findAllWorking());
    }
    @Test
    void testAddSaw(){
        SawManager manager = new SawManager();
        Chainsaw chainsaw = new Chainsaw();
        Jigsaw jigsaw = new Jigsaw();
        manager.addSaw(chainsaw);
        manager.addSaw(jigsaw);
        assertEquals(2, manager.getSaws().size());
    }
}