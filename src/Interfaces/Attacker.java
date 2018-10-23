package Interfaces;

import abstractClasses.*;

public interface Attacker extends Attackable {
    void attack(Entity entity);
    void getAP();
}
