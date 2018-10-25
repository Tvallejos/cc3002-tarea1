package Units;

import Buildings.Castle;
import Interfaces.Attackable;
import abstractClasses.Unit;

public class SiegeUnit extends Unit {
    private final static int siegeHP = 400;
    private final static int siegeAP = 15;


    public SiegeUnit(){
        super(siegeHP,siegeAP);
    }

    public void attack(Attackable Attacked) {
        if (this.isAlive()) {
            Attacked.attackedBySiege(this);
        }
    }
    @Override
    public void attackedByInfantry(InfantryUnit IU) {
        int dmg = (int) (1.2*IU.getAP());
        this.getDamagedBy(dmg);
    }

    @Override
    public void attackedByArcher(ArcherUnit AU) {
        int dmg = (int) (0.8*AU.getAP());
        this.getDamagedBy(dmg);
    }

    @Override
    public void attackedByCavalry(CavalryUnit CU) {
        int dmg = (int) (1.2*CU.getAP());
        this.getDamagedBy(dmg);
    }

    @Override
    public void attackedBySiege(SiegeUnit SU) {
        int dmg = (int) (1.5*SU.getAP());
        this.getDamagedBy(dmg);
    }

    @Override
    public void attackedByVillager(Villager V) {
        int heal = (int) (0.5*V.getAP());
        this.getHealedBy(heal);
    }

    @Override
    public void attackedByMonk(Monk M) {
        //nothing
    }

    @Override
    public void attackedByCastle(Castle castle) {
        int dmg = (int) (0.5*castle.getAP());
        this.getDamagedBy(dmg);
    }

}
