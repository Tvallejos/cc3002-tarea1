package Interfaces;

import abstractClasses.*;

public interface Attacker extends Attackable {

    void attack(Attackable Attacked);
    int getAP();


    double getMultiplier(int k);
}
