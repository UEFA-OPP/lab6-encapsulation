

/**
 * Character класс - Dungeon of OOP тоглоомын баатрын класс.
 * Encapsulation-ийг хэрэгжүүлсэн: private fields, getters, validation.
 */
public class Character {
    // 🔴 Bonus: 'name' талбарыг 'final' болгосон (Constructor-оос хойш өөрчлөх боломжгүй)
    private final String name;
    private int hp;
    private int maxHp;
    private int mp;
    private int maxMp;
    private int gold;

    /**
     * Баатрыг үүсгэх Constructor.
     * @param name Баатрын нэр
     */
    public Character(String name) {
        this.name = name;
        this.maxHp = 100;
        this.hp = 100;
        this.maxMp = 50;
        this.mp = 50;
        this.gold = 0;
    }

    // ==================== 🟢 CORE METHODS (Getters) ====================

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public int getMp() {
        return mp;
    }

    public int getMaxMp() {
        return maxMp;
    }

    public int getGold() {
        return gold;
    }

    /**
     * Баатар хохирол авах үед дуудагдана.
     * 🔴 Bonus: Сөрөг утга орж ирвэл IllegalArgumentException шиднэ.
     */
    public void takeDamage(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Damage must be non-negative");
        }
        // HP-г 0-оос доош унахаас хамгаална
        this.hp = Math.max(0, this.hp - amount);
    }

    /**
     * Баатрын HP-г нэмэгдүүлнэ.
     * 🔴 Bonus: Сөрөг утга орж ирвэл IllegalArgumentException шиднэ.
     */
    public void heal(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Healing amount must be non-negative");
        }
        // HP-г maxHp-аас хэтрэхээс хамгаална
        this.hp = Math.min(maxHp, this.hp + amount);
    }

    /**
     * Баатар алт олох үед дуудагдана.
     * 🔴 Bonus: Сөрөг утга орж ирвэл IllegalArgumentException шиднэ.
     */
    public void earnGold(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Gold amount must be non-negative");
        }
        this.gold += amount;
    }

    // ==================== 🟡 STRETCH METHODS ====================

    /**
     * Баатар алт зарцуулах.
     * @return Алт хүрэлцээтэй бол зарцуулаад true, үгүй бол false буцаана.
     */
    public boolean spendGold(int amount) {
        if (amount < 0 || this.gold < amount) {
            return false;
        }
        this.gold -= amount;
        return true;
    }

    /**
     * Баатар амьд байгаа эсэхийг шалгана.
     */
    public boolean isAlive() {
        return this.hp > 0;
    }

    /**
     * Классын мэдээллийг текст хэлбэрээр буцаана.
     * Format: ⚔️ [name] [HP: hp/maxHp, MP: mp/maxMp, Gold: gold]
     */
    @Override
    public String toString() {
        return String.format("⚔️ %s [HP: %d/%d, MP: %d/%d, Gold: %d]",
                name, hp, maxHp, mp, maxMp, gold);
    }
}