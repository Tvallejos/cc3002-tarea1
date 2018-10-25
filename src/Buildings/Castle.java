package Buildings;

import Interfaces.Attackable;
import Interfaces.Attacker;
import Units.*;
import abstractClasses.Building;

public class Castle extends Building implements Attacker {
    private int AP;

    private final static int castleHP = 4800;
    private final static int castleAP = 13;


    public Castle(){
        super(castleHP);
        this.AP=castleAP;
    }
    public void attack(Attackable Attacked){
        if(this.isAlive()){
            Attacked.attackedByCastle(this);
        }
    }
    public int getAP(){
        return this.AP;
    }
    @Override
    public void attackedByInfantry(InfantryUnit IU) {
        int dmg = (int) (0.3*IU.getAP());
        this.getDamagedBy(dmg);
    }

    @Override
    public void attackedByArcher(ArcherUnit AU) {
        int dmg = (int) (0.1*AU.getAP());
        this.getDamagedBy(dmg);
    }

    @Override
    public void attackedByCavalry(CavalryUnit CU) {
        int dmg = (int) (0.3*CU.getAP());
        this.getDamagedBy(dmg);
    }

    @Override
    public void attackedBySiege(SiegeUnit SU) {
        int dmg = (int) (2.0*SU.getAP());
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
        int dmg = (int) 0.1*castle.getAP();
        this.getDamagedBy(dmg);
    }


}
