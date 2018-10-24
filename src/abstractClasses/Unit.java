package abstractClasses;

import Interfaces.Attackable;
import Interfaces.Attacker;

public abstract class Unit extends Entity implements Attacker {
    private int AP;
    private int maxHP;
    private double[] multipliers; // defined as the multiplier if Attacker attacks [index]
                                  // [Infantry,Archer,Cavalry,Siege,Villager,Monk,Castle,Barracks]
    public Unit(int unitHP,int unitAP ,double[] multipliers){
        super(unitHP);
        this.AP=unitAP;
        this.multipliers=multipliers;
        this.maxHP=2*this.getHP();
    }

    // GETTERS
    public int getAP(){
        return this.AP;
    }
    public int getMaxHP(){
        return this.maxHP;
    }
    public double getMultiplier(int k){
        return multipliers[k];
    }



}
