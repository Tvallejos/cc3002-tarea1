package Interfaces;

import Units.*;

public interface Attackable extends Hitpoints{
    void attackedby(Attacker attacker);
    void attackedbyCastle(Castle castle);
    void attackedbyInfantry(InfantryUnit iu);
    void attackedbyArcher(ArcherUnit au);
    void attackedbyCavalry(CavalryUnit cu);
    void attackedbySiege(SiegeUnit su);
    void attackedbyMonk(Monk m);
    void attackedbyVillager(Villager v);
    void isAlive();
    void multiplier(Attacker attacker);
    void multiplierFromCastle();
    void multiplierFromInfantry();
    void multiplierFromArcher();
    void multiplierFromCavalry();
    void multiplierFromSiege();
    void multiplierFromMonk();
    void multiplierFromVillager();
}
