package ua.lviv.iot.algo.part1.lab1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import main.java.ua.lviv.iot.algo.part1.lab1.Chainsaw;
import main.java.ua.lviv.iot.algo.part1.lab1.Jigsaw;
import main.java.ua.lviv.iot.algo.part1.lab1.SawManager;
import main.java.ua.lviv.iot.algo.part1.lab1.Saw;
import java.util.LinkedList;
import java.util.List;

class SawManagerTest {
    @Test
    void testFindAllWorking() {
        SawManager manager = new SawManager();
        Chainsaw chainsaw = new Chainsaw();
        chainsaw.setWorking(true);
        Jigsaw jigsaw = new Jigsaw();
        jigsaw.setWorking(false);
        manager.addSaw(chainsaw);
        manager.addSaw(jigsaw);
        List<Saw> saws = new LinkedList<>();
        saws.add(chainsaw);
        assertEquals(saws, manager.findAllWorking());
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
        List<Saw> saws = new LinkedList<>();
        saws.add(chainsaw);
        assertEquals(saws, manager.findAllMorePowerfulThan(600));
    }

    @Test
    void testFindWhereAreNothing() {
        List<Saw> saws = new LinkedList<>();
        SawManager manager = new SawManager();
        assertEquals(saws, manager.findAllWorking());
    }
}