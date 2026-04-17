public class Character {

    private final String name;
    private int hp;
    private int maxHp;
    private int mp;
    private int maxMp;
    private int gold;

    public Character(String name) {
        this.name = name;
        hp = 100;
        maxHp = 100;
        mp = 50;
        maxMp = 50;
        gold = 0;
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
        if (amount < 0) throw new IllegalArgumentException("surug baih yosgui!");
        hp = Math.max(0, hp - amount);
    }

    public void heal(int amount) {
        if (amount < 0) throw new IllegalArgumentException("surug baih yosgui!");
        hp = Math.min(maxHp, hp + amount);
    }

    public void earnGold(int amount) {
        if (amount < 0) throw new IllegalArgumentException("surug baih yosgui!");
        gold += amount;
    }

    public boolean spendGold(int amount) {
        if (amount < 0 || gold < amount) {
            return false;
        }
        gold -= amount;
        return true;
    }

    public boolean isAlive() {
        return hp > 0;
    }

    @Override
    public String toString() {
        return " " + name + " [HP: " + hp + "/" + maxHp
                + ", MP: " + mp + "/" + maxMp
                + ", Gold: " + gold + "]";
    }
}