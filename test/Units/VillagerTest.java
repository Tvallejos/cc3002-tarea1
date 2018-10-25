package Units;

import Buildings.Barrack;
import Buildings.Castle;
import abstractClasses.Building;
import abstractClasses.Unit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VillagerTest {
    private Unit villagertest;
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
        villagertest = new Villager();
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
        assertEquals(100, villagertest.getHP());
    }

    @Test
    void getMaxHP() {
        assertEquals(200, villagertest.getMaxHP());
    }

    @Test
    void getAP() {
        assertEquals(10, villagertest.getAP());
    }

    @Test
    void isAlive() {
        assertTrue(villagertest.isAlive());
    }

    @Test
    void setDead() {
        villagertest.setDead();
        assertTrue(!villagertest.isAlive());
        assertEquals(0, villagertest.getHP());
    }

    @Test
    void setHP() {
        villagertest.setHP(37);
        assertEquals(37, villagertest.getHP());
    }

    // can attack every Unit and Building
    @Test
    void attack() {
        villagertest.attack(infantry);
        villagertest.attack(archer);
        villagertest.attack(calvary);
        villagertest.attack(siege);
        villagertest.attack(villager);
        villagertest.attack(monk);

        villagertest.attack(castle);
        villagertest.attack(barrack);

        int expectedDmgToInfantry = (int) (0.8 * 10);
        int expectedDmgToArcher = (int) (1.0 * 10);
        int expectedDmgToCavalry = (int) (0.5 * 10);
        int expectedHealToSiege = (int) (0.5 * 10);
        int expectedDmgToVillager = (int) (1.0 * 10);
        int expectedRepairToCastle = (int) (0.3 * 10);
        int expectedRepairToBarrack = (int) (0.7 * 10);

        assertEquals(150 - expectedDmgToInfantry, infantry.getHP());
        assertEquals(100 - expectedDmgToArcher, archer.getHP());
        assertEquals(200 - expectedDmgToCavalry, calvary.getHP());
        assertEquals(400 + expectedHealToSiege, siege.getHP());

        assertEquals(100 - expectedDmgToVillager, villager.getHP());
        // monk alive and undamaged
        assertTrue((monk.isAlive()) && (100 == monk.getHP()));
        //Villager can not repair a full hp building
        assertEquals(4800 , castle.getHP());
        assertEquals(1200 , barrack.getHP());

        castle.setHP(100);
        barrack.setHP(100);
        villagertest.attack(castle);
        villagertest.attack(barrack);

        assertEquals(100+expectedRepairToCastle , castle.getHP());
        assertEquals(100+expectedRepairToBarrack , barrack.getHP());

        // dont attack if is dead
        villagertest.setDead();

        villagertest.attack(infantry);
        villagertest.attack(archer);
        villagertest.attack(calvary);
        villagertest.attack(siege);
        villagertest.attack(villager);
        villagertest.attack(monk);

        villagertest.attack(castle);
        villagertest.attack(barrack);

        assertEquals(150 - expectedDmgToInfantry, infantry.getHP());
        assertEquals(100 - expectedDmgToArcher, archer.getHP());
        assertEquals(200 - expectedDmgToCavalry, calvary.getHP());
        assertEquals(400 + expectedHealToSiege, siege.getHP());

        assertEquals(100 - expectedDmgToVillager, villager.getHP());
        assertTrue((monk.isAlive()) && (100 == monk.getHP()));
        assertEquals(100 + expectedRepairToCastle, castle.getHP());
        assertEquals(100 + expectedRepairToBarrack, barrack.getHP());
    }
}
