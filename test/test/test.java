/*package test;

import Buildings.Barrack;
import Buildings.Castle;
import Units.*;
import abstractClasses.Building;
import abstractClasses.Unit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class test {
    private Unit Xtest;
    private Unit infantry;
    private Unit calvary;
    private Unit archer;
    private Unit monk;
    private Unit siege;
    private Unit villager;

    private Building barrack;
    private Building castle;

    private int initialHP = 30;
    private int AP = 4;

    @BeforeEach
    void setUp() {
        Xtest = new XUnit();
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
        assertEquals(100, Xtest.getHP());
    }

    @Test
    void getMaxHP() {
        assertEquals(200, Xtest.getMaxHP());
    }

    @Test
    void getAP() {
        assertEquals(12, Xtest.getAP());
    }

    @Test
    void isAlive() {
        assertTrue(Xtest.isAlive());
    }

    @Test
    void setDead() {
        Xtest.setDead();
        assertTrue(!Xtest.isAlive());
        assertEquals(0, Xtest.getHP());
    }

    @Test
    void setHP() {
        Xtest.setHP(37);
        assertEquals(37, Xtest.getHP());
    }

    // can attack every Unit and Building
    @Test
    void attack() {
        Xtest.attack(infantry);
        Xtest.attack(archer);
        Xtest.attack(calvary);
        Xtest.attack(siege);
        Xtest.attack(villager);
        Xtest.attack(monk);

        Xtest.attack(castle);
        Xtest.attack(barrack);

        int expectedDmgToInfantry = (int) 1.2 * 12;
        int expectedDmgToArcher = (int) 1.2 * 12;
        int expectedDmgToCavalry = (int) 1.0 * 12;
        int expectedDmgToSiege = (int) 0.8 * 12;
        int expectedDmgToVillager = (int) 1.5 * 12;
        // monk must be dead;
        int expectedDmgToCastle = (int) 0.1 * 12;
        int expectedDmgToBarrack = (int) 0.7 * 12;

        assertEquals(150 - expectedDmgToInfantry, infantry.getHP());
        assertEquals(100 - expectedDmgToArcher, archer.getHP());
        assertEquals(200 - expectedDmgToCavalry, calvary.getHP());
        assertEquals(400 - expectedDmgToSiege, siege.getHP());

        assertEquals(100 - expectedDmgToVillager, villager.getHP());
        assertTrue((!monk.isAlive()) && (0 == monk.getHP()));
        assertEquals(4800 - expectedDmgToCastle, castle.getHP());
        assertEquals(1200 - expectedDmgToBarrack, barrack.getHP());

        // dont attack if is dead
        Xtest.setDead();

        Xtest.attack(infantry);
        Xtest.attack(archer);
        Xtest.attack(calvary);
        Xtest.attack(siege);
        Xtest.attack(villager);
        Xtest.attack(monk);

        Xtest.attack(castle);
        Xtest.attack(barrack);

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
*/

