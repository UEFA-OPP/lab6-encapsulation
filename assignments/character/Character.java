public class Character {

    private final String name;
    private int hp = 100;
    private int maxHp = 100;
    private int mp = 50;
    private int maxMp = 50;
    private int gold = 0;

    public Character(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

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

    public void takeDamage(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Damage amount cannot be negative");
        }
        this.hp = Math.max(0, this.hp - amount);
    }

    public void heal(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Heal amount cannot be negative");
        }
        this.hp = Math.min(maxHp, this.hp + amount);
    }

    public void earnGold(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Gold amount cannot be negative");
        }
        this.gold += amount;
    }

    public boolean spendGold(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Spend amount cannot be negative");
        }
        if (this.gold >= amount) {
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
        return String.format("⚔️ %s [HP: %d/%d, MP: %d/%d, Gold: %d]",
                this.name, this.hp, this.maxHp, this.mp, this.maxMp, this.gold);
    }
}