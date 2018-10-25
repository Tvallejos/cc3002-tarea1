package Interfaces;
import Units.*;
import Buildings.*;

/**
 * All methods to be attacked by attackers
 * @author Tomas Vallejos
 */
public interface Attackable extends Hitpoints{
    /**
     * The Object take damage from an Infantry Unit
     * @param IU the Infantry Unit which performs the attack
     */
    void attackedByInfantry(InfantryUnit IU);
    /**
     * The Object take damage from an Archer Unit
     * @param AU the Archer Unit which performs the attack
     */
    void attackedByArcher(ArcherUnit AU);
    /**
     * The Object take damage from a Cavalry Unit
     * @param CU the Cavalry Unit which performs the attack
     */
    void attackedByCavalry(CavalryUnit CU);
    /**
     * The Object take damage from a Siege Unit
     * @param SU The Siege Unit which performs the attack
     */
    void attackedBySiege(SiegeUnit SU);
    /**
     * The Object take damage from a Villager
     * @param V the Villager which performs the attack
     */
    void attackedByVillager(Villager V);
    /**
     * The Object get healed by a Monk
     * @param M The Monk which performs the heal
     */
    void attackedByMonk(Monk M);

    /**
     * The Object take damage from a Castle
     * @param castle The Castle which performs the attack
     */
    void attackedByCastle(Castle castle);

    /**
     * Reduces the Object hitpoints, hitpoints cant get lower than 0
     * @param dmg the amount to reduce the hitpoints
     */
    void getDamagedBy(int dmg);
}
