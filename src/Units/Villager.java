package Units;

import Buildings.Castle;
import Interfaces.Attackable;
import abstractClasses.Unit;

/**
 * Villager class
 * @author Tomas Vallejos
 */
public class Villager extends Unit {
    private final static int villagerHP = 100;
    private final static int villagerAP = 10;

    /**
     * Villager constructor calls Unit Constructor
     */
    public Villager(){
        super(villagerHP,villagerAP);
    }

    /**
     * if villager attack the attacked react as attacked by villager
     * @param Attacked the Object whos attacked
     */
    public void attack(Attackable Attacked) {
        if (this.isAlive()) {
            Attacked.attackedByVillager(this);
        }
    }

    /**
     * specific damage and multiplier is applied if Villagers are attacked
     * by Infantry Units
     * @param IU the Infantry Unit which performs the attack
     */
    @Override
    public void attackedByInfantry(InfantryUnit IU) {
        int dmg = (int) (1.5*IU.getAP());
        this.getDamagedBy(dmg);
    }

    /**
     * specific damage and multiplier is applied if Villagers are attacked
     * by Archer Units
     * @param AU the Archer Unit which performs the attack
     */
    @Override
    public void attackedByArcher(ArcherUnit AU) {
        int dmg = (int) (1.5*AU.getAP());
        this.getDamagedBy(dmg);
    }

    /**
     * specific damage and multiplier is applied if Villagers are attacked
     * by Cavalry Units
     * @param CU the Cavalry Unit which performs the attack
     */
    @Override
    public void attackedByCavalry(CavalryUnit CU) {
        int dmg = (int) (1.5*CU.getAP());
        this.getDamagedBy(dmg);
    }

    /**
     * specific damage and multiplier is applied if Villagers are attacked
     * by Siege Units
     * @param SU The Siege Unit which performs the attack
     */
    @Override
    public void attackedBySiege(SiegeUnit SU) {
        int dmg = (int) (1.5*SU.getAP());
        this.getDamagedBy(dmg);
    }

    /**
     * specific damage and multiplier is applied if Villagers are attacked
     * by Villagers
     * @param V the Villager which performs the attack
     */
    @Override
    public void attackedByVillager(Villager V) {
        int dmg = (int) (1.0*V.getAP());
        this.getDamagedBy(dmg);
    }

    /**
     * specific heal and multiplier is applied if Villagers are
     * healed by monks
     * @param M The Monk which performs the heal
     */
    @Override
    public void attackedByMonk(Monk M) {
        int heal = (int) ((0.5*M.getAP()/100)*this.getMaxHP());
        this.getHealedBy(heal);
    }

    /**
     * specific damage and multiplier is applied if Villagers are attacked
     * by castles
     * @param castle The Castle which performs the attack
     */
    @Override
    public void attackedByCastle(Castle castle) {
        int dmg = (int) (1.2*castle.getAP());
        this.getDamagedBy(dmg);
    }
}
