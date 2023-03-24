package ua.lviv.iot.algo.part1.lab1;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString

public class ElectricSaw extends Saws{
    private String brand;
    private int power;
    private int batteryCharge;
    private boolean isWorking;
    private final boolean isAutomatic = true;
    private final int price = 3000;
    public double charge(int charge){
        this.batteryCharge = batteryCharge + charge;
        return this.batteryCharge;
    }
    boolean start(){
        setWorking(true);
        return isWorking;
    }
    boolean stop(){
        setWorking(false);
        return isWorking;
    }
    @Override
    public boolean cutWood(double length) {
        if (batteryCharge >= length * 5) {
            return true;
        }
        else {
            return false;
        }
    }
    public String convertingToString(){
        ElectricSaw electricSaw = new ElectricSaw();
        return electricSaw + "";
    }
}
