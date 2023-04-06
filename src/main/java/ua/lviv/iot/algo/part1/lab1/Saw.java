package main.java.ua.lviv.iot.algo.part1.lab1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public abstract class Saw {
    private String brand;
    private int power;
    private boolean isWorking = false;
    private double workTimeInHours;
    public abstract double getRemainingWorkTime();
    public boolean getWorking() {
        return isWorking;
    }
}
