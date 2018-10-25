/**
 * Hitpoints interface
 * @author: Tomas Vallejos
 */
package Interfaces;

public interface Hitpoints {
    /**
     * Sets the new HP for the Object
     * @param newhp the new HP
     */
    void setHP(int newhp);

    /**
     * Sets the Object HP to 0 and its alive variable to false
     */
    void setDead();

    /**
     * Gets the Object HP
     * @return  Object HP
     */
    int getHP();

    /**
     * answer if the Object is alive
     * @return The alive variable
     */
    boolean isAlive();
}
