public abstract class Classes {
    int health;
    int damage;
    
    public abstract void attack();

    public void setHealth(int health) {
        this.health = health;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }    
    
    public int getHealth() {
        return health;
    }
    
    public int getDamage() {
        return damage;
    }
}
