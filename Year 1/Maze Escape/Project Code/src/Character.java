public abstract class Character extends Entity {
    Classes charClass;
    String className;

    /* -------------- LOGIC METHODS -------------- */
    public void movePosition(int xPosition, int yPosition) {
        this.xPosition += xPosition;
        this.yPosition += yPosition;
    }
    
    public void movement() {
        //Movement based on what programmer decides
    }
    
    public abstract void wallCollision();
    
    /* -------------- SETTER METHODS -------------- */
    public void setCharClass(Classes charClass) {
        this.charClass = charClass;
    }

    public void setClassName(String className) {
        this.className = className;
    }
    
    /* -------------- GETTER METHODS -------------- */
    public Classes getCharClass() {
        return charClass;
    }
    
    public String getClassName() {
        return className;
    }
}
