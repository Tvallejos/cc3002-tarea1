package Interfaces;

import Units.*;
import Buildings.*;

public interface Attackable extends Hitpoints{
    void attackedByCastle(Castle castle);
    void attackedByInfantry(InfantryUnit iu);
    void attackedByArcher(ArcherUnit au);
    void attackedByCavalry(CavalryUnit cu);
    void attackedBySiege(SiegeUnit su);
    void attackedByMonk(Monk m);
    void attackedByVillager(Villager v);

}
