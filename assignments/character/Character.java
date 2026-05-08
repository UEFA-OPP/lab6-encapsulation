package assignments.character;

public class Character {

    private final String name;
    private int hp = 100;
    private int maxHp = 100;
    private int mp = 50;
    private int maxMp = 50;
    private int gold = 0;

    public Character(String name) {
        this.name = name;
    }

    public String getName() { return name; }
    public int getHp() { return hp; }
    public int getMaxHp() { return maxHp; }
    public int getMp() { return mp; }
    public int getMaxMp() { return maxMp; }
    public int getGold() { return gold; }

    public void takeDamage(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Damage cannot be negative");
        }
        this.hp = Math.max(0, this.hp - amount);
    }

    public void heal(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Heal cannot be negative");
        }
        this.hp = Math.min(this.maxHp, this.hp + amount);
    }

    public void earnGold(int amount) {
        if (amount > 0) {
            this.gold += amount;
        }
    }

    public boolean spendGold(int amount) {
        if (amount >= 0 && this.gold >= amount) {
            this.gold -= amount;
            return true;
        }
        return false;
    }

    public boolean isAlive() {
        return this.hp > 0;
    }

    @Override
    public String toString() {
        // Using unicode escape for sword emoji to avoid encoding issues
        return String.format("\u2694\ufe0f %s [HP: %d/%d, MP: %d/%d, Gold: %d]",
                name, hp, maxHp, mp, maxMp, gold);
    }
}