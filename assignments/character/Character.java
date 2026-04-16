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
