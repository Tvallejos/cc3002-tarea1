package Units;


import Buildings.Barrack;
import Buildings.Castle;
import abstractClasses.Building;
import abstractClasses.Unit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CavalryUnitTest {

    private Unit cavalrytest;
    private Unit infantry;
    private Unit calvary;
    private Unit archer;
    private Unit monk;
    private Unit siege;
    private Unit villager;

    private Building barrack;
    private Building castle;

    @BeforeEach
    void setUp() {
        cavalrytest = new CavalryUnit();
        infantry = new InfantryUnit();
        calvary = new CavalryUnit();
        archer = new ArcherUnit();
        monk = new Monk();
        siege = new SiegeUnit();
        villager = new Villager();

        castle = new Castle();
        barrack = new Barrack();
    }

    //getters test
    @Test
    void getHP() {
        assertEquals(200, cavalrytest.getHP());
    }

    @Test
    void getMaxHP() {
        assertEquals(400, cavalrytest.getMaxHP());
    }

    @Test
    void getAP() {
        assertEquals(16, cavalrytest.getAP());
    }

    @Test
    void isAlive() {
        assertTrue(cavalrytest.isAlive());
    }

    @Test
    void setDead() {
        cavalrytest.setDead();
        assertTrue(!cavalrytest.isAlive());
        assertEquals(0, cavalrytest.getHP());
    }

    @Test
    void setHP() {
        cavalrytest.setHP(37);
        assertEquals(37, cavalrytest.getHP());
    }

    // can attack every Unit and Building
    @Test
    void attack() {
        cavalrytest.attack(infantry);
        cavalrytest.attack(archer);
        cavalrytest.attack(calvary);
        cavalrytest.attack(siege);
        cavalrytest.attack(villager);
        cavalrytest.attack(monk);

        cavalrytest.attack(castle);
        cavalrytest.attack(barrack);

        int expectedDmgToInfantry = (int) 1.0 * 16;
        int expectedDmgToArcher = (int) 1.5 * 16;
        int expectedDmgToCavalry = (int) 1.0 * 16;
        int expectedDmgToSiege = (int) 1.2 * 16;
        int expectedDmgToVillager = (int) 1.5 * 16;
        // monk must be dead;
        int expectedDmgToCastle = (int) 0.3 * 16;
        int expectedDmgToBarrack = (int) 0.7 * 16;

        assertEquals(150 - expectedDmgToInfantry, infantry.getHP());
        assertEquals(100 - expectedDmgToArcher, archer.getHP());
        assertEquals(200 - expectedDmgToCavalry, calvary.getHP());
        assertEquals(400 - expectedDmgToSiege, siege.getHP());

        assertEquals(100 - expectedDmgToVillager, villager.getHP());
        assertTrue((!monk.isAlive()) && (0 == monk.getHP()));
        assertEquals(4800 - expectedDmgToCastle, castle.getHP());
        assertEquals(1200 - expectedDmgToBarrack, barrack.getHP());

        // dont attack if is dead
        cavalrytest.setDead();

        cavalrytest.attack(infantry);
        cavalrytest.attack(archer);
        cavalrytest.attack(calvary);
        cavalrytest.attack(siege);
        cavalrytest.attack(villager);
        cavalrytest.attack(monk);

        cavalrytest.attack(castle);
        cavalrytest.attack(barrack);

        assertEquals(150 - expectedDmgToInfantry, infantry.getHP());
        assertEquals(100 - expectedDmgToArcher, archer.getHP());
        assertEquals(200 - expectedDmgToCavalry, calvary.getHP());
        assertEquals(400 - expectedDmgToSiege, siege.getHP());

        assertEquals(100 - expectedDmgToVillager, villager.getHP());
        assertTrue((!monk.isAlive()) && (0 == monk.getHP()));
        assertEquals(4800 - expectedDmgToCastle, castle.getHP());
        assertEquals(1200 - expectedDmgToBarrack, barrack.getHP());


    }

}