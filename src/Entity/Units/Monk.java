package Entity.Units;

import Entity.Buildings.Castle;
import Entity.Attackable;

/**
 * Monk class
 * @author Tomas Vallejos
 */
public class Monk extends Unit {
    /**
     * variable which represents monk's initial hitpoints
     */
    private final static int monkHP = 100;
    /**
     * variable which represents monk's attack power
     */
    private final static int monkAP = 10;

    /**
     * monks constructor calls Unit constructor
     */
    public Monk(){
        super(monkHP,monkAP);
    }

    /**
     * if monk attack the entity reacts as being healed by a monk 
     * @param Attacked the Object whos attacked
     */
    @Override
    public void attack(Attackable Attacked) {
        if (this.isAlive()){
            {Attacked.attackedByMonk(this);}
        }
    }

    /**
     * infantry kills instantly monks
     * @param IU the Infantry Unit which performs the attack
     */
    @Override
    public void attackedByInfantry(InfantryUnit IU) {
        this.setDead();
        this.setHP(0);
    }

    /**
     * archers kills instantly monks
     * @param AU the Archer Unit which performs the attack
     */
    @Override
    public void attackedByArcher(ArcherUnit AU) {
        this.setDead();
        this.setHP(0);
    }

    /**
     * cavalry Entity.Units kills instantly monks
     * @param CU the Cavalry Unit which performs the attack
     */
    @Override
    public void attackedByCavalry(CavalryUnit CU) {
        this.setDead();
        this.setHP(0);
    }

    /**
     * Siege Entity.Units instantly kills monks
     * @param SU The Siege Unit which performs the attack
     */
    @Override
    public void attackedBySiege(SiegeUnit SU) {
        this.setDead();
        this.setHP(0);
    }

    /**
     * Villager don't deal any dmg to monks
     * @param V the Villager which performs the attack
     */
    @Override
    public void attackedByVillager(Villager V) {
        //nothing
    }

    /**
     * Monk heals other monks
     * @param M The Monk which performs the heal
     */
    @Override
    public void attackedByMonk(Monk M) {
        int heal = (int) ((0.5*M.getAP()/100)*this.getMaxHP());
        this.getHealedBy(heal);
    }

    /**
     * monks die instantly if attacked by castles
     * @param castle The Castle which performs the attack
     */
    @Override
    public void attackedByCastle(Castle castle) {
        this.setDead();
        this.setHP(0);
    }
}
