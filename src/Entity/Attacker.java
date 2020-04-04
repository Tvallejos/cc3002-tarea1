package Entity;

/**
 * All methods for attacker Entity.Units
 * @author Tomas Vallejos
 */
public interface Attacker extends Attackable {
    /**
     * The Object attacks another Object which implements Attackable
     * @param Attacked the Object whos attacked
     */
    void attack(Attackable Attacked);

    /**
     * Gets the attack power of the Object
     * @return attack power amount
     */
    int getAP();
}
