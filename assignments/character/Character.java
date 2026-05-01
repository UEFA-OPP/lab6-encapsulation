public class Character {

    // TODO: private талбаруудыг зарлана уу
    // - name (String)           → Баатрын нэр. (Bonus: final болгож болно)
    // - hp (int, default 100)   → Одоогийн HP
    // - maxHp (int, default 100)→ Дээд HP
    // - mp (int, default 50)    → Одоогийн MP
    // - maxMp (int, default 50) → Дээд MP
    // - gold (int, default 0)   → Алт

    // TODO: Constructor бичнэ үү
    // public Character(String name)
    // - name талбарт параметрын утгыг өгнө
    // - Бусад талбар default утгаар үлдэнэ

    // TODO: getName() → String
    // - name талбарыг буцаана

    // TODO: getHp() → int

    // TODO: getMaxHp() → int

    // TODO: getMp() → int

    // TODO: getMaxMp() → int

    // TODO: getGold() → int

    // TODO: takeDamage(int amount) → void
    // - hp-аас amount хасна
    // - hp 0-ээс доош яваагүй байх: Math.max(0, hp - amount)
    // - amount < 0 бол: юу ч өөрчлөхгүй (Bonus: IllegalArgumentException шидэх)

    // TODO: heal(int amount) → void
    // - hp-д amount нэмнэ
    // - maxHp-аас хэтрэхгүй: Math.min(maxHp, hp + amount)
    // - amount < 0 бол: юу ч өөрчлөхгүй (Bonus: IllegalArgumentException)

    // TODO: earnGold(int amount) → void
    // - gold-д amount нэмнэ
    // - amount < 0 бол: юу ч өөрчлөхгүй (Bonus: IllegalArgumentException)

    // ─────── 🟡 Stretch (30 оноо) ───────

    // TODO: spendGold(int amount) → boolean
    // - gold >= amount бол: gold -= amount хийгээд true буцаана
    // - gold < amount бол: юу ч өөрчлөхгүй, false буцаана

    // TODO: isAlive() → boolean
    // - hp > 0 бол true, эс бөгөөс false

    // TODO: @Override toString() → String
    // - Формат: "⚔️ [name] [HP: hp/maxHp, MP: mp/maxMp, Gold: gold]"
    // - Жишээ: "⚔️ Aragorn [HP: 100/100, MP: 50/50, Gold: 0]"

}
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
        if (amount < 0) throw new IllegalArgumentException();
        this.hp = Math.max(0, this.hp - amount);
    }

    public void heal(int amount) {
        if (amount < 0) throw new IllegalArgumentException();
        this.hp = Math.min(maxHp, this.hp + amount);
    }

    public void earnGold(int amount) {
        if (amount < 0) return;
        this.gold += amount;
    }

    public boolean spendGold(int amount) {
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
                name, hp, maxHp, mp, maxMp, gold);
    }
}
