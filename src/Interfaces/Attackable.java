package Interfaces;

import Units.*;
import Buildings.*;

public interface Attackable extends Hitpoints{

    void attackedByInfantry(InfantryUnit IU);
    void attackedByArcher(ArcherUnit AU);
    void attackedByCavalry(CavalryUnit CU);
    void attackedBySiege(SiegeUnit SU);
    void attackedByVillager(Villager V);
    void attackedByMonk(Monk M);
    void attackedByCastle(Castle castle);
    void getDamagedBy(int dmg);
}
