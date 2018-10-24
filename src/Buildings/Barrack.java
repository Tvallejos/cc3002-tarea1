package Buildings;

import Units.*;
import abstractClasses.Building;

public class Barrack extends Building {
    private final static int barrackHP=1200;
    public Barrack(){
        super(barrackHP);
    }

    @Override
    public void attackedByInfantry(InfantryUnit IU) {
        int dmg = (int) 0.7*IU.getAP();
        this.getDamagedBy(dmg);
    }

    @Override
    public void attackedByArcher(ArcherUnit AU) {
        int dmg = (int) 0.7*AU.getAP();
        this.getDamagedBy(dmg);
    }

    @Override
    public void attackedByCavalry(CavalryUnit CU) {
        int dmg = (int) 0.7*CU.getAP();
        this.getDamagedBy(dmg);
    }

    @Override
    public void attackedBySiege(SiegeUnit SU) {
        int dmg = (int) 2.0*SU.getAP();
        this.getDamagedBy(dmg);
    }

    @Override
    public void attackedByVillager(Villager V) {
        int repair = (int) (0.3*V.getAP());
        this.getRepairedby(repair);
    }

    @Override
    public void attackedByMonk(Monk M) {
        //nothing
    }

    @Override
    public void attackedByCastle(Castle castle) {
        int dmg = (int) 0.7*castle.getAP();
        this.getDamagedBy(dmg);
    }

}
