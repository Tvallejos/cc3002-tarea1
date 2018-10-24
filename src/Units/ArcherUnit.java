package Units;

import Buildings.Castle;
import Interfaces.Attackable;
import abstractClasses.Unit;

public class ArcherUnit extends Unit {
    private final static int archerHP=30;
    private final static int archerAP=4;
    private final static double[] ArcherMultipliers= {1.0 , 1.2 , 1.0 , 1.5, 0.8, 0.5, 1.2};

    public ArcherUnit(){
        super(this.archerHP,this.archerAP,this.ArcherMultipliers);
    }

    public void attack(Attackable Attacked){
        if(this.isAlive()){Attacked.attackedByArcher(this);}
    }
    public void attackedByInfantry(InfantryUnit IU){
        int dmg = (int) getMultiplier(0)*IU.getAP();
        if(getHP()-dmg<=0){
            setDead();
            setHP(0);
        }else setHP(getHP()-dmg);
    }
    public void attackedByArcher(ArcherUnit AU){
        int dmg = (int) getMultiplier(1)*AU.getAP();
        if(getHP()-dmg<=0){
            setDead();
            setHP(0);
        }else setHP(getHP()-dmg);
    }
    public void attackedByCavalry(CavalryUnit CU){
        int dmg = (int) getMultiplier(2)*CU.getAP();
        if(getHP()-dmg<=0){
            setDead();
            setHP(0);
        }else setHP(getHP()-dmg);
    }
    public void attackedBySiege(SiegeUnit SU){
        int dmg = (int) getMultiplier(3)*SU.getAP();
        if(getHP()-dmg<=0){
            setDead();
            setHP(0);
        }else setHP(getHP()-dmg);
    }
    public void attackedByVillager(Villager v){
        int dmg = (int) getMultiplier(4)*v.getAP();
        if(getHP()-dmg<=0){
            setDead();
            setHP(0);
        }else setHP(getHP()-dmg);
    }
    public void attackedByMonk(Monk m){
        int heal = (int) getMultiplier(5)*m.getAP();
        if(getHP()+heal< getMaxHP()){
            setHP(getHP()+heal);
        }else setHP(getMaxHP());
    }
    public void attackedByCastle(Castle castle){
        int dmg = (int) getMultiplier(6)*castle.getAP();
        if(getHP()-dmg<=0){
            setDead();
            setHP(0);
        }else setHP(getHP()-dmg);
    }
}
