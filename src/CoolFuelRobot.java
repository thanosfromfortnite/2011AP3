public class CoolFuelRobot implements FuelRobot {

    /* Fields */
    private boolean facingRight;
    private int index;

    /* Constructor */
    public CoolFuelRobot(int index, boolean isItFacingRight) {
        this.index = index;
        facingRight = isItFacingRight;
    }

    /* Methods */
    /**
     * @return Index of the robot.
     */
    public int getCurrentIndex() {
        return index;
    }

    /**
     * @return true if facing right, false if facing left.
     */
    public boolean isFacingRight() {
        return facingRight;
    }

    /**
     * Changes the direction to its opposite. Changes to right if facing left, left if facing right.
     */
    public void changeDirection() {
        facingRight = !facingRight;
    }

    /**
     * @param numLocs The number of spaces it should move in its direction.
     */
    public void moveForward(int numLocs) {
        if (facingRight) {
            index += numLocs;
        }
        else {
            index -= numLocs;
        }
    }

}
