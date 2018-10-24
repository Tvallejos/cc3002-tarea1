package Units;

import Buildings.Barrack;
import Buildings.Castle;
import abstractClasses.Unit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CavalryUnitTest {
    private Unit Cav;
    private Unit Cav1;
    private final int initialHP = 60;
    private final int CavAP = 7;
    private final int InfAP= 6;
    private final int archAP=4;
    @BeforeEach
    void setUp() {
        Cav = new CavalryUnit();
        Cav1 = new CavalryUnit();
    }

    @Test
    void attack() {
        Cav.attack(new InfantryUnit());
        Cav.attack(new ArcherUnit());
        Cav.attack(new CavalryUnit());
        Cav.attack(new SiegeUnit());
        Cav.attack(new Villager());
        Cav.attack(new Monk());
        Cav.attack(new Castle());
        Cav.attack(new Barrack());
    }

    @Test
    void getAP() {
    }

    @Test
    void getMaxHP() {
    }

    @Test
    void getHealedBy() {
    }

    @Test
    void setDead() {
    }

    @Test
    void setHP() {
    }

    @Test
    void isAlive() {
    }

    @Test
    void getHP() {
        assertEquals(initialHP,Cav.getHP());
    }

    @Test
    void getMultiplier() {
    }

    @Test
    void getDamagedBy() {
    }

    @Test
    void attackedByInfantry() {

    }

    @Test
    void attackedByArcher() {
        new ArcherUnit().attack(Cav);
        int expectedDmg = (int)(archAP*1.0);
        System.out.println(expectedDmg);
        int expectedHP = initialHP-expectedDmg;
        assertEquals(expectedHP,Cav.getHP());
        System.out.println(Cav.getHP());
    }

    @Test
    void attackedByCavalry() {
    }

    @Test
    void attackedBySiege() {
    }

    @Test
    void attackedByVillager() {
    }

    @Test
    void attackedByMonk() {
    }

    @Test
    void attackedByCastle() {
    }
}