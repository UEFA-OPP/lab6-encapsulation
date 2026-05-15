/**
        * Lab 6: Character Sheet - Encapsulation
 */
public class Character {
    // Bonus: name талбар final байх ёстой
    private final String name;
    private int hp = 100;
    private int maxHp = 100;
    private int mp = 50;
    private int maxMp = 50;
    private int gold = 0;

    // Core: Нэг String параметр авдаг constructor
    public Character(String name) {
        this.name = name;
    }

    // Core: Getter-үүд (Тест файл эдгээр нэрээр дуудаж байгаа)
    public String getName() { return name; }
    public int getHp() { return hp; }
    public int getMaxHp() { return maxHp; }
    public int getMp() { return mp; }
    public int getMaxMp() { return maxMp; }
    public int getGold() { return gold; }

    // Core: takeDamage (Bonus: Сөрөг утганд IllegalArgumentException шиднэ)
    public void takeDamage(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Damage amount cannot be negative");
        }
        this.hp = Math.max(0, this.hp - amount);
    }

    // Core: heal (maxHp-аас хэтрүүлж болохгүй)
    public void heal(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Heal amount cannot be negative");
        }
        this.hp = Math.min(this.maxHp, this.hp + amount);
    }

    // Core: earnGold (Сөрөг утгыг үл тоомсорлоно)
    public void earnGold(int amount) {
        if (amount < 0) {
            return;
        }
        this.gold += amount;
    }

    // Stretch: spendGold
    public boolean spendGold(int amount) {
        if (amount >= 0 && this.gold >= amount) {
            this.gold -= amount;
            return true;
        }
        return false;
    }

    // Stretch: isAlive
    public boolean isAlive() {
        return this.hp > 0;
    }

    // Stretch: toString (Тест файлын хүлээж буй яг тэр формат)
    @Override
    public String toString() {
        return String.format("⚔️ %s [HP: %d/%d, MP: %d/%d, Gold: %d]",
                name, hp, maxHp, mp, maxMp, gold);
    }
}