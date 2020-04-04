package Entity.Units;

import Entity.Buildings.Castle;
import Entity.Attackable;

/**
 * Infantry Unit Class
 * @author Tomas Vallejos
 */
public class InfantryUnit extends Unit {
    /**
     * variable which represents the infantry's initial hitpoints
     */
    private final static int infantryHP = 150;
    /**
     * variable which represents infantry's attack power
     */
    private final static int infantryAP = 14;

    /**
     * Infantries Constructor calls Unit constructor
     */
    public InfantryUnit(){
        super(infantryHP,infantryAP);
    }

    /**
     * if infantry attacks the Entity reacts as being attacked by infantry
     * @param Attacked the Object whos attacked
     */
    public void attack(Attackable Attacked) {
        if(isAlive()){Attacked.attackedByInfantry(this);}
    }

    /**
     * specific damage and multiplier is applied if Infantry is attacked
     * by infantry Entity.Units
     * @param IU the Infantry Unit which performs the attack
     */
    @Override
    public void attackedByInfantry(InfantryUnit IU) {
        int dmg = (int) (1.0*IU.getAP());
        this.getDamagedBy(dmg);
    }

    /**
     * specific damage and multiplier is applied if Infantry is attacked
     * by archer Entity.Units
     * @param AU the Archer Unit which performs the attack
     */
    @Override
    public void attackedByArcher(ArcherUnit AU) {
        int dmg = (int) (1.2*AU.getAP());
        this.getDamagedBy(dmg);
    }

    /**
     * specific damage and multiplier is applied if Infantry is attacked
     * by Cavalry Entity.Units
     * @param CU the Cavalry Unit which performs the attack
     */
    @Override
    public void attackedByCavalry(CavalryUnit CU) {
        int dmg = (int) (1.0*CU.getAP());
        this.getDamagedBy(dmg);
    }

    /**
     * specific damage and multiplier is applied if Infantry is attacked
     * by Siege Entity.Units
     * @param SU The Siege Unit which performs the attack
     */
    @Override
    public void attackedBySiege(SiegeUnit SU) {
        int dmg = (int) (1.5*SU.getAP());
        this.getDamagedBy(dmg);
    }

    /**
     * specific damage and multiplier is applied if Infantry is attacked
     * by Villagers
     * @param V the Villager which performs the attack
     */
    @Override
    public void attackedByVillager(Villager V) {
        int dmg = (int) (0.8*V.getAP());
        this.getDamagedBy(dmg);
    }

    /**
     * specific heal and multiplier is applied if Infantry is attacked
     * by monks
     * @param M The Monk which performs the heal
     */
    @Override
    public void attackedByMonk(Monk M) {
        int heal = (int) ((0.5*M.getAP()/100)*this.getMaxHP());
        this.getHealedBy(heal);
    }

    /**
     * specific damage and multiplier is applied if Infantry is attacked
     * by castles
     * @param castle The Castle which performs the attack
     */
    @Override
    public void attackedByCastle(Castle castle) {
        int dmg = (int) (1.2*castle.getAP());
        this.getDamagedBy(dmg);
    }


}
