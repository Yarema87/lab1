package main.java.ua.lviv.iot.algo.part1.lab1;

import java.util.LinkedList;
import java.util.List;
import main.java.ua.lviv.iot.algo.part1.lab1.Saw;

public class SawManager {
    private static List<Saw> saws = new LinkedList<>();
    public List<Saw> findAllWorking() {
        return saws.stream().filter(saw -> saw.getWorking() == true).toList();
    }
    public List<Saw> findAllMorePowerfulThan(final int power) {
        return saws.stream().
                filter(saw -> saw.getPower() > power).
                toList();
    }

    public void addSaw(final Saw sawToAdd) {
        this.saws.add(sawToAdd);
    }
}
