public class Character {

    private final String name;
    private int hp;
    private int maxHp;
    private int mp;
    private int maxMp;
    private int gold;

    public Character(String name) {
        this.name = name;
        this.hp = 100;
        this.maxHp = 100;
        this.mp = 50;
        this.maxMp = 50;
        this.gold = 0;
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
        if (amount < 0) return;
        hp = Math.max(0, hp - amount);
    }

    public void heal(int amount) {
        if (amount < 0) return;
        hp = Math.min(maxHp, hp + amount);
    }

    public void earnGold(int amount) {
        if (amount < 0) return;
        gold += amount;
    }

    public boolean spendGold(int amount) {
        if (amount < 0) return false;
        if (gold >= amount) {
            gold -= amount;
            return true;
        }
        return false;
    }

    public boolean isAlive() {
        return hp > 0;
    }

    @Override
    public String toString() {
        return "⚔️ " + name +
                " [HP: " + hp + "/" + maxHp +
                ", MP: " + mp + "/" + maxMp +
                ", Gold: " + gold + "]";
    }
}
