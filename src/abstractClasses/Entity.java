package abstractClasses;

import Buildings.Castle;
import Interfaces.Attackable;
import Interfaces.Attacker;
import Units.*;

public abstract class Entity implements Attackable {
    private int hp;
    private boolean alive = true;

    public Entity(int hp) {
        this.hp = hp;
    }

    // Hitpoints implementation
    // SETTERS
    public void setDead() {
        alive = false;
    }

    public void setHP(int newhp) {
        hp = newhp;
    }

    // GETTERS
    public boolean isAlive() {
        return alive;
    }

    public int getHP() {
        return hp;
    }

    public void getDamagedBy(int dmg) {
        if (isAlive()) {
            if (getHP() - dmg <= 0) {
                setDead();
                setHP(0);
            } else setHP(getHP() - dmg);
        }
    }
}
