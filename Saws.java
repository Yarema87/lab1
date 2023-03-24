package ua.lviv.iot.algo.part1.lab1;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public abstract class Saws {
    private boolean isAutomatic;
    private double workSpeed;
    private int price;
    public double changeSpeed(double newSpeed){
        this.workSpeed = newSpeed;
        return workSpeed;
    };
    public boolean getAutomatic(){
        return isAutomatic;
    }
    public abstract boolean cutWood(double length);
}
