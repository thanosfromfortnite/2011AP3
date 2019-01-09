import java.util.List;

public class FuelDepot {

    /* Fields */
    private FuelRobot filler;
    private List<FuelTank> tanks;

    /* Constructors */
    public FuelDepot(boolean robotFacingRight, int robotIndex, int[] fuel) {
        filler = new CoolFuelRobot(robotIndex, robotFacingRight);
        for (int i = 0; i < fuel.length; i ++) {
            tanks.add(new CoolFuelTank(fuel[i]));
        }
    }
    public FuelDepot(boolean robotFacingRight, int robotIndex, List<Integer> fuel) {
        filler = new CoolFuelRobot(robotIndex, robotFacingRight);
        for (int i = 0; i < fuel.size(); i ++) {
            tanks.add(new CoolFuelTank(fuel.get(i)));
        }
    }

    /* Methods */

    /**
     * @param threshold The threshold number.
     * @return The index of the lowest leveled fuel tank under the threshold. If there are none, it will return the
     * current index.
     */
    public int nextTankToFill(int threshold) {
        int index = filler.getCurrentIndex(), lowest = threshold;
        for (int i = 0; i < tanks.size(); i ++) {
            if (tanks.get(i).getFuelLevel() <= threshold && tanks.get(i).getFuelLevel() <= lowest) {
                index = i; lowest = i;
            }
        }
        return index;
    }

    /**
     * Move to a specified index.
     * @param locIndex The space to move to. The robot will change direction for this if needed.
     */
    public void moveToLocation(int locIndex) {
        boolean positive = locIndex >= filler.getCurrentIndex();
        if (positive != filler.isFacingRight()) {
            filler.changeDirection();
        }
        filler.moveForward(Math.abs(locIndex - filler.getCurrentIndex()));
    }
}
