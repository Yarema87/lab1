package main.java.ua.lviv.iot.algo.part1.lab1;

import java.util.ArrayList;
import java.util.List;
import main.java.ua.lviv.iot.algo.part1.lab1.Saw;

public class SawManager {
    private List<Saw> saws = new ArrayList<>();
    public List<Saw> findAllWorking() {
        return saws.stream().filter(saw -> saw.getWorking()).toList();
    }
    public List<Saw> findAllMorePowerfulThan(final int power) {
        List<Saw> morePowerfulSaws = saws.stream().
                filter(saw -> saw.getPower() > power).
                toList();
        return morePowerfulSaws;
    }
    public void addSaw(Saw sawToAdd) {
        this.saws.add(sawToAdd);
    }
    public List<Saw> getSaws() {
        return saws;
    }
}
