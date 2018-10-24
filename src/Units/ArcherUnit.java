package Units;

import Buildings.Castle;
import Interfaces.Attackable;
import abstractClasses.Unit;

public class ArcherUnit extends Unit {
    private final static int archerHP=30;
    private final static int archerAP=4;

    public ArcherUnit(){
        super(archerHP,archerAP);
    }

    public void attack(Attackable Attacked){
        if(this.isAlive()){
            Attacked.attackedByArcher(this);
        }
    }

    @Override
    public void attackedByInfantry(InfantryUnit IU) {
        int dmg = (int) 1.2*IU.getAP();
        this.getDamagedBy(dmg);
    }

    @Override
    public void attackedByArcher(ArcherUnit AU) {
        int dmg = (int) 1.2*AU.getAP();
        this.getDamagedBy(dmg);
    }

    @Override
    public void attackedByCavalry(CavalryUnit CU) {
        int dmg = (int) 1.5*CU.getAP();
        this.getDamagedBy(dmg);
    }

    @Override
    public void attackedBySiege(SiegeUnit SU) {
        int dmg = (int) 1.5*SU.getAP();
        this.getDamagedBy(dmg);
    }

    @Override
    public void attackedByVillager(Villager V) {
        int dmg = (int) 1.0*V.getAP();
        this.getDamagedBy(dmg);
    }

    @Override
    public void attackedByMonk(Monk M) {
        int heal = (int) ((0.5*M.getAP()/100)*this.getMaxHP());
        this.getHealedBy(heal);
    }

    @Override
    public void attackedByCastle(Castle castle) {
        int dmg = (int) 1.2*castle.getAP();
        this.getDamagedBy(dmg);
    }

}
