/**
 * Building abstract class for attackable buildings
 * if another apart from castle is an attacker building
 * an attackerBuilding abstract class must be created
 * and refactor castle methods
 * @author Tomas Vallejos
 */
package abstractClasses;

public abstract class Building extends Entity {

    /**
     * Variable which saves the max hp of the building
     */
    private int Fullhp;

    /**
     * Building constructor, uses Entity Constructor and
     * adds the Fullhp variable which cant be changed
     * once is set
     * @param BuildingHP
     */
    public Building(int BuildingHP){
        super(BuildingHP);
        this.Fullhp=BuildingHP;
    }

    /**
     * Gets the maxHP of the Building
     * @return  max building hitpoints amount
     */
    public int getFullhp(){
        return this.Fullhp;
    }

    /**
     * Building exclusive method
     * recovers Building hitpoints,
     * Building hitpoints cant get over its maxHP
     * @param repair the repair amount
     */
    public void getRepairedby(int repair){
        if(this.isAlive()){
            if(getHP()+repair>=getFullhp()){
                setHP(getFullhp());
            }else{
                setHP(getHP()+repair);
            }
        }
    }

}
