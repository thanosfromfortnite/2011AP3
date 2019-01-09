public class CoolFuelTank implements FuelTank {
    /* Fields */
    private int fuelLevel;

    /* Constructor */
    public CoolFuelTank(int fuel) {
        fuelLevel = fuel;
    }

    /* Methods */

    /**
     * @return the fuelLevel given to the tank.
     */
    public int getFuelLevel() {
        return fuelLevel;
    }
}
