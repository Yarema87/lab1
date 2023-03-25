package ua.lviv.iot.algo.part1.lab1;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString

public class Chainsaw extends Saws{
    private String brand;
    private int power;
    private double fuelTankCapacity;
    private double fuelLevel;
    private boolean isWorking;
    private final boolean isAutomatic = true;
    private final int price = 4000;
    private static Chainsaw instance;
    public boolean start(){
        setWorking(true);
        return isWorking;
    }
    public boolean stop(){
        setWorking(false);
        return isWorking;
    }
    @Override
    public boolean cutWood(double length) {
        if (fuelLevel >= length * 0.1) {
            return true;
        }
        else {
            return false;
        }
    }
    public double charge(double fuel){
        this.fuelLevel = fuelLevel + fuel;
        return this.fuelLevel;
    }
    public String convertingToString(){
        Chainsaw chainsaw = new Chainsaw();
        return chainsaw + "";
    }
    public static Chainsaw getInstance(){
        return new Chainsaw();
    }
}
