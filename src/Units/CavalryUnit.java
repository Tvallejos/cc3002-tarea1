package Units;

import Buildings.Castle;
import Interfaces.Attackable;
import abstractClasses.Unit;

/**
 * Cavalry Unit Class
 * @author Tomas Vallejos
 */
public class CavalryUnit extends Unit {
    /**
     * variable which represents the cavalry initial hitpoints
     */
    private final static int cavalryHP = 200;
    /**
     * variable which represents calvarry attack power
     */
    private final static int cavalryAP = 16;

    /**
     * Cavalry Constructor calls Unit Constructor
     */
    public CavalryUnit() {
        super(cavalryHP,cavalryAP);
    }

    /**
     * if Cavalry attacks, the attacked entity reacts as attacked by Cavalry
     * @param Attacked the Object whos attacked
     */
    public void attack(Attackable Attacked) {
        if (this.isAlive()) {
            Attacked.attackedByCavalry(this);
        }
    }

    /**
     * specific damage and multiplier is applied if Cavalry is attacked
     * by infantry Units
     * @param IU the Infantry Unit which performs the attack
     */
    @Override
    public void attackedByInfantry(InfantryUnit IU) {
        int dmg = (int) (1.2*IU.getAP());
        this.getDamagedBy(dmg);
    }

    /**
     * specific damage and multiplier is applied if Cavalry is attacked
     * by archer Units
     * @param AU the Archer Unit which performs the attack
     */
    @Override
    public void attackedByArcher(ArcherUnit AU) {
        int dmg = (int) (1.0*AU.getAP());
        this.getDamagedBy(dmg);
    }

    /**
     * specific damage and multiplier is applied if Cavalry is attacked
     * by Cavalry Units
     * @param CU the Cavalry Unit which performs the attack
     */
    @Override
    public void attackedByCavalry(CavalryUnit CU) {
        int dmg = (int) (1.0*CU.getAP());
        this.getDamagedBy(dmg);
    }

    /**
     * specific damage and multiplier is applied if Cavalry is attacked
     * by Siege Units
     * @param SU The Siege Unit which performs the attack
     */
    @Override
    public void attackedBySiege(SiegeUnit SU) {
        int dmg = (int) (1.0*SU.getAP());
        this.getDamagedBy(dmg);
    }

    /**
     * specific damage and multiplier is applied if Cavalry is attacked
     * by Villagers
     * @param V the Villager which performs the attack
     */
    @Override
    public void attackedByVillager(Villager V) {
        int dmg = (int) (0.5*V.getAP());
        this.getDamagedBy(dmg);
    }

    /**
     * specific heal and multiplier is applied if Cavalry is attacked
     * by monks
     * @param M The Monk which performs the heal
     */
    @Override
    public void attackedByMonk(Monk M) {
        int heal = (int) ((0.5*M.getAP()/100)*this.getMaxHP());
        this.getHealedBy(heal);
    }

    /**
     * specific damage and multiplier is applied if Cavalry is attacked
     * by castles
     * @param castle The Castle which performs the attack
     */
    @Override
    public void attackedByCastle(Castle castle) {
        int dmg = (int) (1.2*castle.getAP());
        this.getDamagedBy(dmg);
    }
}
