/**
 * Created by FWU31 on 4/10/2019.
 */
public class Vehicle {
    private String brand;
    private int doors;

    public Vehicle(String brand, int doors) {
        this.brand = brand;
        this.doors = doors;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "brand='" + brand + '\'' +
                ", doors=" + doors +
                '}';
    }
}
