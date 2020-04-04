package Entity.Units;
import Entity.Attacker;
import Entity.Entity;

/**
 * Abstract class for attacker units
 * @author Tomas Vallejos
 */
public abstract class Unit extends Entity implements Attacker {
    /**
     * represents the Attack Power of the unit
     */
    private int AP;
    /**
     * represents the maxHP the Unit can reach
     */
    private int maxHP;

    /**
     * Unit constructor which sets the maxHP as the double of the
     * Initial HP
     * @param unitHP initial Unit HP
     * @param unitAP Unit attack power
     */
    public Unit(int unitHP,int unitAP){
        super(unitHP);
        this.AP=unitAP;
        this.maxHP=2*this.getHP();
    }

    /**
     * Attacker interface implementation
     * Gets the Unit's attack power
     * @return attack power
     */
    @Override
    public int getAP(){
        return this.AP;
    }

    /**
     * Gets the max HP this unit can reach
     * @return max hp amount
     */
    public int getMaxHP(){
        return this.maxHP;
    }

    /**
     * Unit exclusive method
     * Heals Unit's hitpoints by an amount,
     * Entity.Units cant be healed over its maxHP
     * @param heal healing amount
     */
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
