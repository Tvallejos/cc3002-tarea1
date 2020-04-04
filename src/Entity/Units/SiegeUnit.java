package Entity.Units;

import Entity.Buildings.Castle;
import Entity.Attackable;

/**
 * Siege Unit class
 * @author Tomas Vallejos
 */
public class SiegeUnit extends Unit {
    /**
     * variable which represents the siege unit initial health
     */
    private final static int siegeHP = 400;
    /**
     * variable which represents the siege unit attack power
     */
    private final static int siegeAP = 15;

    /**
     * Siege constructor calls unit constructor
     */
    public SiegeUnit(){
        super(siegeHP,siegeAP);
    }

    /**
     * if a Siege attacks the entity reacts as attacked by a Siege Unit
     * @param Attacked the Object whos attacked
     */
    public void attack(Attackable Attacked) {
        if (this.isAlive()) {
            Attacked.attackedBySiege(this);
        }
    }

    /**
     * specific damage and multiplier is applied if Siege is attacked
     * by Infantry Entity.Units
     * @param IU the Infantry Unit which performs the attack
     */
    @Override
    public void attackedByInfantry(InfantryUnit IU) {
        int dmg = (int) (1.2*IU.getAP());
        this.getDamagedBy(dmg);
    }

    /**
     * specific damage and multiplier is applied if Siege is attacked
     * by Archer Entity.Units
     * @param AU the Archer Unit which performs the attack
     */
    @Override
    public void attackedByArcher(ArcherUnit AU) {
        int dmg = (int) (0.8*AU.getAP());
        this.getDamagedBy(dmg);
    }

    /**
     * specific damage and multiplier is applied if Siege is attacked
     * by Cavalry Entity.Units
     * @param CU the Cavalry Unit which performs the attack
     */
    @Override
    public void attackedByCavalry(CavalryUnit CU) {
        int dmg = (int) (1.2*CU.getAP());
        this.getDamagedBy(dmg);
    }

    /**
     * specific damage and multiplier is applied if Siege is attacked
     * by Siege Entity.Units
     * @param SU The Siege Unit which performs the attack
     */
    @Override
    public void attackedBySiege(SiegeUnit SU) {
        int dmg = (int) (1.5*SU.getAP());
        this.getDamagedBy(dmg);
    }

    /**
     * specific healing and multiplier is applied if Siege is repaired
     * by Villagers
     * @param V the Villager which performs the attack
     */
    @Override
    public void attackedByVillager(Villager V) {
        int heal = (int) (0.5*V.getAP());
        this.getHealedBy(heal);
    }

    /**
     * Siege cannot be healed by monks
     * @param M The Monk which performs the heal
     */
    @Override
    public void attackedByMonk(Monk M) {
        //nothing
    }

    /**
     * specific damage and multiplier is applied if Siege is attacked
     * by castles
     * @param castle The Castle which performs the attack
     */
    @Override
    public void attackedByCastle(Castle castle) {
        int dmg = (int) (0.5*castle.getAP());
        this.getDamagedBy(dmg);
    }

}
