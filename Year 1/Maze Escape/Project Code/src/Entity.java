public abstract class Entity {
    int xPosition;
    int yPosition;

    /* ------------------- SETTER METHODS ----------------- */
    public void setXPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public void setYPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    /* ------------------- GETTER METHODS ----------------- */
    public int getXPosition() {
        return xPosition;
    }

    public int getYPosition() {
        return yPosition;
    }
}
