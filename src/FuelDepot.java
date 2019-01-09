import java.util.List;

public class FuelDepot {
    private FuelRobot filler;

    private List<FuelTank> tanks;

    public int nextTankToFill(int threshold) {
        int index = filler.getCurrentIndex(), lowest = threshold;
        for (int i = 0; i < tanks.size(); i ++) {
            if (tanks.get(i).getFuelLevel() <= threshold && tanks.get(i).getFuelLevel() <= lowest) {
                index = i; lowest = i;
            }
        }
        return index;
    }

    public void moveToLocation(int locIndex) {
        boolean positive = locIndex >= filler.getCurrentIndex();
        if (positive != filler.isFacingRight()) {
            filler.changeDirection();
        }
        filler.moveForward(Math.abs(locIndex - filler.getCurrentIndex()));
    }
}
