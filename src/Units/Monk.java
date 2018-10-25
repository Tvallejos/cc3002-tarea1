package Units;

import Buildings.Castle;
import Interfaces.Attackable;
import abstractClasses.Unit;

public class Monk extends Unit {
    private final static int monkHP = 100;
    private final static int monkAP = 10;


    public Monk(){
        super(monkHP,monkAP);
    }

    @Override
    public void attack(Attackable Attacked) {
        if (this.isAlive()){
            {Attacked.attackedByMonk(this);}
        }
    }
    @Override
    public void attackedByInfantry(InfantryUnit IU) {
        this.setDead();
        this.setHP(0);
    }

    @Override
    public void attackedByArcher(ArcherUnit AU) {
        this.setDead();
        this.setHP(0);
    }

    @Override
    public void attackedByCavalry(CavalryUnit CU) {
        this.setDead();
        this.setHP(0);
    }

    @Override
    public void attackedBySiege(SiegeUnit SU) {
        this.setDead();
        this.setHP(0);
    }

    @Override
    public void attackedByVillager(Villager V) {
        //nothing
    }

    @Override
    public void attackedByMonk(Monk M) {
        int heal = (int) ((0.5*M.getAP()/100)*this.getMaxHP());
        this.getHealedBy(heal);
    }

    @Override
    public void attackedByCastle(Castle castle) {
        this.setDead();
        this.setHP(0);
    }
}
