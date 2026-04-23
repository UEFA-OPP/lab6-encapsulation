public class Character {

    // TODO: private талбаруудыг зарлана уу
  private final String name;
    private int hp;
    private int mp;
    private int gold;
    // TODO: Constructor бичнэ үү
    public Character(String name, int hp, int mp, int gold) {
        if (hp < 0 || mp < 0 || gold < 0) {
            throw new IllegalArgumentException("Stats cannot be negative");
        }
        this.name = name;
        this.hp = hp;
        this.mp = mp;
        this.gold = gold;
    }

    // TODO: getName() → String
   public String getName() { return name; }
    public int getHp() { return hp; }
    public int getMp() { return mp; }
    public int getGold() { return gold; }

    // TODO: takeDamage(int amount) → void
    public void takeDamage(int damage) {
        if (damage > 0) {
            this.hp = Math.max(0, this.hp - damage);
        }
    }

    // TODO: heal(int amount) → void
    public void heal(int amount) {
        if (amount > 0) {
            this.hp += amount;
        }
    }
    // TODO: earnGold(int amount) → void
    public void earnGold(int amount) {
        if (amount > 0) {
            this.gold += amount;
        }
    }

    // ─────── 🟡 Stretch (30 оноо) ───────

    // TODO: spendGold(int amount) → boolean
    public boolean spendGold(int amount) {
        if (amount > 0 && this.gold >= amount) {
            this.gold -= amount;
            return true;
        }
        return false;
    }
    // TODO: isAlive() → boolean
    public boolean isAlive() {
        return this.hp > 0;
    }

    // TODO: @Override toString() → String
    public String toString() {
        return "Character{name='" + name + "', hp=" + hp + ", mp=" + mp + ", gold=" + gold + "}";
    }
}
