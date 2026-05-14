public class Character {

    // ─────── 🟢 Талбарууд (Private Fields) ───────

    // Bonus: 'final' болгосноор баатрын нэрийг дахин өөрчлөх боломжгүй болно
    private final String name;
    private int hp = 100;
    private int maxHp = 100;
    private int mp = 50;
    private int maxMp = 50;
    private int gold = 0;

    // ─────── 🏗️ Constructor ───────

    public Character(String name) {
        this.name = name;
        // Бусад талбарууд дээр зарласан default утгаараа (100, 50, 0) үүснэ
    }

    // ─────── 🟢 Getter Methods ───────

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

    // ─────── 🟢 Core Methods ───────

    /**
     * Хохирол авах: HP-г 0-оос доош оруулахгүй.
     * Bonus: Сөрөг утга орж ирвэл IllegalArgumentException шиднэ.
     */
    public void takeDamage(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Damage amount cannot be negative.");
        }
        this.hp = Math.max(0, this.hp - amount);
    }

    /**
     * Эдгэрэх: maxHp-аас хэтрүүлэхгүй.
     * Bonus: Сөрөг утга орж ирвэл IllegalArgumentException шиднэ.
     */
    public void heal(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Heal amount cannot be negative.");
        }
        this.hp = Math.min(this.maxHp, this.hp + amount);
    }

    /**
     * Алт олох: Олох алт сөрөг байж болохгүй.
     */
    public void earnGold(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Earned gold cannot be negative.");
        }
        this.gold += amount;
    }

    // ─────── 🟡 Stretch Methods ───────

    /**
     * Алт зарцуулах: Хүрэлцэхгүй бол false буцаана.
     */
    public boolean spendGold(int amount) {
        if (amount < 0) return false; // Сөрөг утга зарцуулах боломжгүй

        if (this.gold >= amount) {
            this.gold -= amount;
            return true;
        }
        return false;
    }

    /**
     * Амьд эсэхийг шалгах
     */
    public boolean isAlive() {
        return this.hp > 0;
    }

    /**
     * Баатрын мэдээллийг текст хэлбэрээр буцаах
     * Формат: ⚔️ [name] [HP: hp/maxHp, MP: mp/maxMp, Gold: gold]
     */
    @Override
    public String toString() {
        return String.format("⚔️ %s [HP: %d/%d, MP: %d/%d, Gold: %d]",
                name, hp, maxHp, mp, maxMp, gold);
    }
}