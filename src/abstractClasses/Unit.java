package abstractClasses;

import Interfaces.Attackable;
import Interfaces.Attacker;

public abstract class Unit extends Entity implements Attacker {
    private int AP;
    private int maxHP;

    public Unit(int unitHP,int unitAP){
        super(unitHP);
        this.AP=unitAP;
        this.maxHP=2*this.getHP();
    }

    // GETTERS
    public int getAP(){
        return this.AP;
    }
    public int getMaxHP(){
        return this.maxHP;
    }

    public void getHealedBy(int heal){
        if(this.isAlive()){

            if(getHP()+heal>getMaxHP()){
                setHP(getMaxHP());
            }else{
                setHP(getHP()+heal);
            }
        }
    }



}
