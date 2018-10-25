package Units;

import Buildings.Barrack;
import Buildings.Castle;
import abstractClasses.Building;
import abstractClasses.Unit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArcherUnitTest {
    private Unit archertest;
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
        archertest = new ArcherUnit();
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
        assertEquals(100, archertest.getHP());
    }

    @Test
    void getMaxHP() {
        assertEquals(200, archertest.getMaxHP());
    }

    @Test
    void getAP() {
        assertEquals(12, archertest.getAP());
    }

    @Test
    void isAlive() {
        assertTrue(archertest.isAlive());
    }

    @Test
    void setDead() {
        archertest.setDead();
        assertTrue(!archertest.isAlive());
        assertEquals(0, archertest.getHP());
    }

    @Test
    void setHP() {
        archertest.setHP(37);
        assertEquals(37, archertest.getHP());
    }

    // can attack every Unit and Building
    @Test
    void attack() {
        archertest.attack(infantry);
        archertest.attack(archer);
        archertest.attack(calvary);
        archertest.attack(siege);
        archertest.attack(villager);
        archertest.attack(monk);

        archertest.attack(castle);
        archertest.attack(barrack);

        int expectedDmgToInfantry = (int) (1.2 * 12);
        int expectedDmgToArcher = (int) (1.2 * 12);
        int expectedDmgToCavalry = (int) (1.0 * 12);
        int expectedDmgToSiege = (int) (0.8 * 12);
        int expectedDmgToVillager = (int) (1.5 * 12);
        // monk must be dead;
        int expectedDmgToCastle = (int) (0.1 * 12);
        int expectedDmgToBarrack = (int) (0.7 * 12);

        assertEquals(150 - expectedDmgToInfantry, infantry.getHP());
        assertEquals(100 - expectedDmgToArcher, archer.getHP());
        assertEquals(200 - expectedDmgToCavalry, calvary.getHP());
        assertEquals(400 - expectedDmgToSiege, siege.getHP());

        assertEquals(100 - expectedDmgToVillager, villager.getHP());
        assertTrue((!monk.isAlive()) && (0 == monk.getHP()));
        assertEquals(4800 - expectedDmgToCastle, castle.getHP());
        assertEquals(1200 - expectedDmgToBarrack, barrack.getHP());

        // dont attack if is dead
        archertest.setDead();

        archertest.attack(infantry);
        archertest.attack(archer);
        archertest.attack(calvary);
        archertest.attack(siege);
        archertest.attack(villager);
        archertest.attack(monk);

        archertest.attack(castle);
        archertest.attack(barrack);

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
