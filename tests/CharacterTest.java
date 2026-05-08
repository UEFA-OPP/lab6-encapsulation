package tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Constructor;

import assignments.character.Character;

@DisplayName("Lab 6: Character (Encapsulation)")
public class CharacterTest {

    private Character hero;

    @BeforeEach
    void setUp() {
        hero = new Character("Aragorn");
    }

    @Test
    @Tag("core")
    @DisplayName("Character class exists")
    void classExists() { assertNotNull(hero); }

    @Test
    @Tag("core")
    @DisplayName("Constructor with one String parameter")
    void constructorParams() throws Exception {
        Constructor<Character> c = Character.class.getConstructor(String.class);
        assertNotNull(c);
    }

    @Test
    @Tag("core")
    @DisplayName("All fields must be private")
    void allFieldsPrivate() {
        Field[] fields = Character.class.getDeclaredFields();
        assertTrue(fields.length >= 6, "Should have at least 6 fields");
        for (Field f : fields) {
            assertTrue(Modifier.isPrivate(f.getModifiers()), 
                "Field " + f.getName() + " must be private");
        }
    }

    @Test
    @Tag("core")
    @DisplayName("Getters work correctly")
    void gettersWork() {
        assertEquals("Aragorn", hero.getName());
        assertEquals(100, hero.getHp());
        assertEquals(100, hero.getMaxHp());
        assertEquals(50, hero.getMp());
        assertEquals(50, hero.getMaxMp());
        assertEquals(0, hero.getGold());
    }

    @Test
    @Tag("core")
    @DisplayName("takeDamage reduces HP correctly")
    void takeDamageReducesHp() {
        hero.takeDamage(30);
        assertEquals(70, hero.getHp());
    }

    @Test
    @Tag("core")
    @DisplayName("takeDamage cannot go below zero")
    void takeDamageCannotGoBelowZero() {
        hero.takeDamage(150);
        assertEquals(0, hero.getHp());
    }

    @Test
    @Tag("core")
    @DisplayName("heal cannot exceed maxHp")
    void healCannotExceedMaxHp() {
        hero.takeDamage(50);
        hero.heal(100);
        assertEquals(100, hero.getHp());
    }

    @Test
    @Tag("core")
    @DisplayName("earnGold ignores negative values")
    void earnGoldIgnoresNegative() {
        hero.earnGold(-50);
        assertEquals(0, hero.getGold());
    }

    @Test
    @Tag("core")
    @DisplayName("spendGold works when sufficient")
    void spendGoldSufficient() {
        hero.earnGold(50);
        boolean success = hero.spendGold(30);
        assertTrue(success);
        assertEquals(20, hero.getGold());
    }

    @Test
    @Tag("core")
    @DisplayName("spendGold fails when insufficient")
    void spendGoldInsufficient() {
        hero.earnGold(20);
        boolean success = hero.spendGold(50);
        assertFalse(success);
        assertEquals(20, hero.getGold());
    }

    @Test
    @Tag("core")
    @DisplayName("isAlive returns correct status")
    void isAliveReturnsCorrect() {
        assertTrue(hero.isAlive());
        hero.takeDamage(100);
        assertFalse(hero.isAlive());
    }

    @Test
    @Tag("core")
    @DisplayName("toString format check")
    void toStringHasCorrectFormat() {
        String expected = "\u2694\ufe0f Aragorn [HP: 100/100, MP: 50/50, Gold: 0]";
        assertEquals(expected, hero.toString());
    }

    @Test
    @Tag("bonus")
    @DisplayName("Name field is final")
    void nameFieldIsFinal() throws Exception {
        Field f = Character.class.getDeclaredField("name");
        assertTrue(Modifier.isFinal(f.getModifiers()));
    }
}