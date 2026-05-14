

public class Character {
    // 🔴 Bonus: name талбарыг final болгох
    private final String name;
    private int hp;
    private int maxHp;
    private int mp;
    private int maxMp;
    private int gold;

    // 🏗️ Constructor
    public Character(String name) {
        this.name = name;
        this.hp = 100;
        this.maxHp = 100;
        this.mp = 50;
        this.maxMp = 50;
        this.gold = 0;
    }

    // 🟢 Core: Getters
    public String getName() { return name; }
    public int getHp() { return hp; }
    public int getMaxHp() { return maxHp; }
    public int getMp() { return mp; }
    public int getMaxMp() { return maxMp; }
    public int getGold() { return gold; }

    // 🟢 Core: Methods
    public void takeDamage(int amount) {
        if (amount < 0) {
            // 🔴 Bonus: Exception шидэх
            throw new IllegalArgumentException("Damage must be non-negative");
        }
        this.hp = Math.max(0, this.hp - amount);
    }

    public void heal(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Heal amount must be non-negative");
        }
        this.hp = Math.min(maxHp, this.hp + amount);
    }

    public void earnGold(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Gold amount must be non-negative");
        }
        this.gold += amount;
    }

    // 🟡 Stretch: Methods
    public boolean spendGold(int amount) {
        if (amount < 0) return false;
        if (this.gold >= amount) {
            this.gold -= amount;
            return true;
        }
        return false;
    }

    public boolean isAlive() {
        return this.hp > 0;
    }

    // 🟡 Stretch: toString Override
    @Override
    public String toString() {
        // Формат: ⚔️ [name] [HP: hp/maxHp, MP: mp/maxMp, Gold: gold]
        return String.format("⚔️ %s [HP: %d/%d, MP: %d/%d, Gold: %d]",
                name, hp, maxHp, mp, maxMp, gold);
    }
}