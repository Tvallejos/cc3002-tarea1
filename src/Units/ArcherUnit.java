package Units;

import Buildings.Castle;
import Interfaces.Attackable;
import abstractClasses.Unit;

/**
 * Archer class
 * @author Tomas Vallejos
 */
public class ArcherUnit extends Unit {
    /**
     * variable which represents the initial archer's hitpoints
     */
    private final static int archerHP=100;
    /**
     * variable which represents the initial archer's attack power
     */
    private final static int archerAP=12;

    /**
     * Archer constructor calls Unit Constructor
     */
    public ArcherUnit(){
        super(archerHP,archerAP);
    }

    /**
     * if archer attacks the attacked Entity reacts as attacked by archer
     * @param Attacked the Object whos attacked
     */
    public void attack(Attackable Attacked){
        if(this.isAlive()){
            Attacked.attackedByArcher(this);
        }
    }

    /**
     * specific damage and multiplier is applied if archer is attacked
     * by infantry Units
     * @param IU the Infantry Unit which performs the attack
     */
    @Override
    public void attackedByInfantry(InfantryUnit IU) {
        int dmg = (int) (1.2*IU.getAP());
        this.getDamagedBy(dmg);
    }

    /**
     * specific damage and multiplier is applied if archer is attacked
     * by Archer Units
     * @param AU the Archer Unit which performs the attack
     */
    @Override
    public void attackedByArcher(ArcherUnit AU) {
        int dmg = (int) (1.2*AU.getAP());
        this.getDamagedBy(dmg);
    }

    /**
     * specific damage and multiplier is done if archer is attacked
     * by Cavalry Units
     * @param CU the Cavalry Unit which performs the attack
     */
    @Override
    public void attackedByCavalry(CavalryUnit CU) {
        int dmg = (int) (1.5*CU.getAP());
        this.getDamagedBy(dmg);
    }

    /**
     * specific damage and multiplier is done if archer is attacked
     * by Siege Units
     * @param SU The Siege Unit which performs the attack
     */
    @Override
    public void attackedBySiege(SiegeUnit SU) {
        int dmg = (int) (1.5*SU.getAP());
        this.getDamagedBy(dmg);
    }

    /**
     * specific damage and multiplier is done if archer is attacked
     * by Villagers
     * @param V the Villager which performs the attack
     */
    @Override
    public void attackedByVillager(Villager V) {
        int dmg = (int) (1.0*V.getAP());
        this.getDamagedBy(dmg);
    }

    /**
     * specific damage and multiplier is done if archer is attacked
     * by monks
     * @param M The Monk which performs the heal
     */
    @Override
    public void attackedByMonk(Monk M) {
        int heal = (int) ((0.5*M.getAP()/100)*this.getMaxHP());
        this.getHealedBy(heal);
    }

    /**
     * specific damage and multiplier is done if archer is attacked
     * by Castles
     * @param castle The Castle which performs the attack
     */
    @Override
    public void attackedByCastle(Castle castle) {
        int dmg = (int) (1.2*castle.getAP());
        this.getDamagedBy(dmg);
    }

}
