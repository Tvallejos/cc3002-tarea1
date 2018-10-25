package abstractClasses;
import Interfaces.Attackable;

/**
 * Abstract class for attackable Objects
 * @author Tomas Vallejos
 */
public abstract class Entity implements Attackable {

    /**
     * the actual amount of hitpoints
     */
    private int hp;
    /**
     * represent if the Entity still lives
     */
    private boolean alive = true;

    /**
     * Entity Constructor
     * @param hp Initial hitpoints
     */
    public Entity(int hp) {
        this.hp = hp;
    }

    /**
     *  Hitpoints interface implementation
     *  Kills the Entity and sets its hitpoints at 0
     */
    @Override
    public void setDead() {
        alive = false;
        setHP(0);
    }

    /**
     * Hitpoints interface implementation
     * Sets a new amount of HP
     * @param newhp the new HP
     */
    @Override
    public void setHP(int newhp) {
        hp = newhp;
    }

    /**
     * Hitpoints interface implementation
     * Answer if the Entity is alive
     * @return variable alive which represents this
     */
    @Override
    public boolean isAlive() {
        return alive;
    }

    /**
     * Hitpoints interface implementation
     * Get actual entities actual hitpoints
     * @return variable hp which represents that
     */
    @Override
    public int getHP() {
        return hp;
    }

    /**
     * Attackable interface implementation
     * Reduces the Entity hitpoint by an amount
     * @param dmg the amount to reduce the hitpoints
     */
    @Override
    public void getDamagedBy(int dmg) {
        if (isAlive()) {
            if (getHP() - dmg <= 0) {
                setDead();
            } else setHP(getHP() - dmg);
        }
    }
}
