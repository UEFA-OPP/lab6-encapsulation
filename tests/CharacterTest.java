import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Constructor;

@DisplayName("Lab 6: Character (Encapsulation)")
public class CharacterTest {

    private Character hero;

    @BeforeEach
    void setUp() {
        hero = new Character("Aragorn");
    }

    // ==================== 🟢 CORE ====================

    @Test
    @Tag("core")
    @DisplayName("Character класс үүссэн эсэх")
    void classExists() {
        assertNotNull(hero);
    }

    @Test
    @Tag("core")
    @DisplayName("Constructor нэг String параметртэй")
    void constructorParams() throws Exception {
        Constructor<Character> c = Character.class.getConstructor(String.class);
        assertNotNull(c);
    }

    @Test
    @Tag("core")
    @DisplayName("Бүх талбар private эсэх")
    void allFieldsPrivate() {
        Field[] fields = Character.class.getDeclaredFields();
        assertTrue(fields.length >= 6, "Дор хаяж 6 талбар зарлагдсан байх ёстой");
        for (Field f : fields) {
            assertTrue(Modifier.isPrivate(f.getModifiers()),
                f.getName() + " талбар private биш байна!");
        }
    }

    @Test
    @Tag("core")
    @DisplayName("name талбар зөв утгатай")
    void initialName() throws Exception {
        Field f = Character.class.getDeclaredField("name");
        f.setAccessible(true);
        assertEquals("Aragorn", f.get(hero));
        assertEquals("Aragorn", hero.getName());
    }

    @Test
    @Tag("core")
    @DisplayName("hp анхны утга 100, maxHp 100")
    void initialHp() throws Exception {
        Field hp = Character.class.getDeclaredField("hp");
        Field maxHp = Character.class.getDeclaredField("maxHp");
        hp.setAccessible(true);
        maxHp.setAccessible(true);
        assertEquals(100, hp.getInt(hero));
        assertEquals(100, maxHp.getInt(hero));
        assertEquals(100, hero.getHp());
        assertEquals(100, hero.getMaxHp());
    }

    @Test
    @Tag("core")
    @DisplayName("gold анхны утга 0, mp=50, maxMp=50")
    void initialGold() throws Exception {
        Field gold = Character.class.getDeclaredField("gold");
        Field mp = Character.class.getDeclaredField("mp");
        Field maxMp = Character.class.getDeclaredField("maxMp");
        gold.setAccessible(true);
        mp.setAccessible(true);
        maxMp.setAccessible(true);
        assertEquals(0, gold.getInt(hero));
        assertEquals(50, mp.getInt(hero));
        assertEquals(50, maxMp.getInt(hero));
        assertEquals(0, hero.getGold());
        assertEquals(50, hero.getMp());
        assertEquals(50, hero.getMaxMp());
    }

    @Test
    @Tag("core")
    @DisplayName("takeDamage hp-г зөв хасна")
    void takeDamageReducesHp() {
        hero.takeDamage(30);
        assertEquals(70, hero.getHp());
        hero.takeDamage(20);
        assertEquals(50, hero.getHp());
    }

    @Test
    @Tag("core")
    @DisplayName("takeDamage hp-г 0-оос доош оруулахгүй")
    void takeDamageCannotGoBelowZero() {
        hero.takeDamage(9999);
        assertEquals(0, hero.getHp());
        hero.takeDamage(50);
        assertEquals(0, hero.getHp());
    }

    @Test
    @Tag("core")
    @DisplayName("heal maxHp-аас хэтрүүлэхгүй")
    void healCannotExceedMaxHp() {
        hero.takeDamage(40); // hp=60
        hero.heal(20);        // hp=80
        assertEquals(80, hero.getHp());
        hero.heal(9999);      // hp should cap at 100
        assertEquals(100, hero.getHp());
    }

    @Test
    @Tag("core")
    @DisplayName("earnGold сөрөг утгыг үл тоомсорлоно")
    void earnGoldIgnoresNegative() {
        hero.earnGold(50);
        assertEquals(50, hero.getGold());
        // Сөрөг утга өгвөл silently ignore эсвэл throw — аль нь ч gold өөрчлөхгүй
        try {
            hero.earnGold(-30);
        } catch (IllegalArgumentException ex) {
            // bonus tier хэрэгжүүлэгчдэд OK
        }
        assertEquals(50, hero.getGold(),
            "earnGold(-30) нь gold-ыг бууруулах ёсгүй");
    }

    // ==================== 🟡 STRETCH ====================

    @Test
    @Tag("stretch")
    @DisplayName("spendGold хангалттай алттай үед true буцаана")
    void spendGoldSufficient() {
        hero.earnGold(100);
        assertTrue(hero.spendGold(30));
        assertEquals(70, hero.getGold());
    }

    @Test
    @Tag("stretch")
    @DisplayName("spendGold хангалтгүй үед false, gold өөрчлөгдөхгүй")
    void spendGoldInsufficient() {
        hero.earnGold(50);
        assertFalse(hero.spendGold(999));
        assertEquals(50, hero.getGold());
    }

    @Test
    @Tag("stretch")
    @DisplayName("isAlive HP-ээс хамааран зөв утга буцаана")
    void isAliveReturnsCorrectly() {
        assertTrue(hero.isAlive());
        hero.takeDamage(99);
        assertTrue(hero.isAlive(), "hp=1 байхад amьд");
        hero.takeDamage(1);
        assertFalse(hero.isAlive(), "hp=0 бол үхсэн");
    }

    @Test
    @Tag("stretch")
    @DisplayName("toString яг шаардлагатай форматтай")
    void toStringHasCorrectFormat() {
        String expected = "⚔️ Aragorn [HP: 100/100, MP: 50/50, Gold: 0]";
        assertEquals(expected, hero.toString());

        hero.takeDamage(25);
        hero.earnGold(15);
        String expected2 = "⚔️ Aragorn [HP: 75/100, MP: 50/50, Gold: 15]";
        assertEquals(expected2, hero.toString());
    }

    // ==================== 🔴 BONUS ====================

    @Test
    @Tag("bonus")
    @DisplayName("name талбар final байна")
    void nameFieldIsFinal() throws Exception {
        Field f = Character.class.getDeclaredField("name");
        assertTrue(Modifier.isFinal(f.getModifiers()),
            "name талбар final байх ёстой (bonus шаардлага)");
    }

    @Test
    @Tag("bonus")
    @DisplayName("takeDamage сөрөг утганд IllegalArgumentException шиднэ")
    void takeDamageThrowsOnNegative() {
        assertThrows(IllegalArgumentException.class, () -> hero.takeDamage(-5));
    }
}
