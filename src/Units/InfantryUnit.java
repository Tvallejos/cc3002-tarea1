package Units;

import Buildings.Castle;
import Interfaces.Attackable;
import abstractClasses.Unit;

public class InfantryUnit extends Unit {
    private final static int infantryHP = 150;
    private final static int infantryAP = 14;


    public InfantryUnit(){
        super(infantryHP,infantryAP);
    }


    public void attack(Attackable Attacked) {
        if(isAlive()){Attacked.attackedByInfantry(this);}
    }


    @Override
    public void attackedByInfantry(InfantryUnit IU) {
        int dmg = (int) (1.0*IU.getAP());
        this.getDamagedBy(dmg);
    }

    @Override
    public void attackedByArcher(ArcherUnit AU) {
        int dmg = (int) (1.2*AU.getAP());
        this.getDamagedBy(dmg);
    }

    @Override
    public void attackedByCavalry(CavalryUnit CU) {
        int dmg = (int) (1.0*CU.getAP());
        this.getDamagedBy(dmg);
    }

    @Override
    public void attackedBySiege(SiegeUnit SU) {
        int dmg = (int) (1.5*SU.getAP());
        this.getDamagedBy(dmg);
    }

    @Override
    public void attackedByVillager(Villager V) {
        int dmg = (int) (0.8*V.getAP());
        this.getDamagedBy(dmg);
    }

    @Override
    public void attackedByMonk(Monk M) {
        int heal = (int) ((0.5*M.getAP()/100)*this.getMaxHP());
        this.getHealedBy(heal);
    }

    @Override
    public void attackedByCastle(Castle castle) {
        int dmg = (int) (1.2*castle.getAP());
        this.getDamagedBy(dmg);
    }


}
