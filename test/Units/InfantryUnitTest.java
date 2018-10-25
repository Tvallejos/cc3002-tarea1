package Units;

import Buildings.Barrack;
import Buildings.Castle;
import abstractClasses.Building;
import abstractClasses.Unit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InfantryUnitTest {
    private Unit infantrytest;
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
        infantrytest = new InfantryUnit();
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
        assertEquals(150, infantrytest.getHP());
    }

    @Test
    void getMaxHP() {
        assertEquals(300, infantrytest.getMaxHP());
    }

    @Test
    void getAP() {
        assertEquals(14, infantrytest.getAP());
    }

    @Test
    void isAlive() {
        assertTrue(infantrytest.isAlive());
    }

    @Test
    void setDead() {
        infantrytest.setDead();
        assertTrue(!infantrytest.isAlive());
        assertEquals(0, infantrytest.getHP());
    }

    @Test
    void setHP() {
        infantrytest.setHP(37);
        assertEquals(37, infantrytest.getHP());
    }

    // can attack every Unit and Building
    @Test
    void attack() {
        infantrytest.attack(infantry);
        infantrytest.attack(archer);
        infantrytest.attack(calvary);
        infantrytest.attack(siege);
        infantrytest.attack(villager);
        infantrytest.attack(monk);

        infantrytest.attack(castle);
        infantrytest.attack(barrack);

        int expectedDmgToInfantry = (int) (1.0 * 14);
        int expectedDmgToArcher = (int) (1.2 * 14);
        int expectedDmgToCavalry = (int) (1.2 * 14);
        int expectedDmgToSiege = (int) (1.2 * 14);
        int expectedDmgToVillager = (int) (1.5 * 14);
        // monk must be dead;
        int expectedDmgToCastle = (int) (0.3 * 14);
        int expectedDmgToBarrack = (int) (0.7 * 14);

        assertEquals(150 - expectedDmgToInfantry, infantry.getHP());
        assertEquals(100 - expectedDmgToArcher, archer.getHP());
        assertEquals(200 - expectedDmgToCavalry, calvary.getHP());
        assertEquals(400 - expectedDmgToSiege, siege.getHP());

        assertEquals(100 - expectedDmgToVillager, villager.getHP());
        assertTrue((!monk.isAlive()) && (0 == monk.getHP()));
        assertEquals(4800 - expectedDmgToCastle, castle.getHP());
        assertEquals(1200 - expectedDmgToBarrack, barrack.getHP());

        // dont attack if is dead
        infantrytest.setDead();

        infantrytest.attack(infantry);
        infantrytest.attack(archer);
        infantrytest.attack(calvary);
        infantrytest.attack(siege);
        infantrytest.attack(villager);
        infantrytest.attack(monk);

        infantrytest.attack(castle);
        infantrytest.attack(barrack);

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