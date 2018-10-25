package abstractClasses;

public abstract class Building extends Entity {
    private int Fullhp;
    public Building(int BuildingHP){
        super(BuildingHP);
        this.Fullhp=BuildingHP;
    }
    public int getFullhp(){
        return this.Fullhp;
    }
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
