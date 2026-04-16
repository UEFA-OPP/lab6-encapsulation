# Lab 6 — Character класс (Encapsulation)

**Нийт оноо:** 100 | **Сэдэв:** Encapsulation (private fields, getters/setters, validation)

## 🎭 Түүх

Dungeon of OOP-ын үүднээс чи өөрийн **баатраа** төрүүлэх ёстой. Баатар нь нэр, амьдрал (HP), ид шид (MP), алт (gold) гэсэн үндсэн атрибутуудтай. Гадны код шууд `character.hp = -999` гэж зүрхээр руу нь хутгалахыг зөвшөөрч болохгүй — **encapsulation** ашиглан талбарыг `private` хийж, зөвхөн хяналттай method-ээр өөрчилнө.

---

## 📋 Шаардлагатай Талбарууд (Fields)

**Бүгд `private`.** Шууд гаднаас хандах боломжгүй байх ёстой.

| Талбар | Төрөл | Анхны утга | Тайлбар |
|--------|--------|------------|---------|
| `name` | `String` | constructor-оос | Баатрын нэр. **🔴 Bonus: `final`** |
| `hp` | `int` | `100` | Одоогийн амьдралын оноо |
| `maxHp` | `int` | `100` | Дээд амьдрал |
| `mp` | `int` | `50` | Одоогийн ид шидийн оноо |
| `maxMp` | `int` | `50` | Дээд ид шид |
| `gold` | `int` | `0` | Хуримтлуулсан алт |

---

## 🏗️ Constructor

```java
public Character(String name)
```

- `name` талбарт параметрын утгыг өгнө
- `hp = 100`, `maxHp = 100`, `mp = 50`, `maxMp = 50`, `gold = 0`

**Жишээ:**
```java
Character hero = new Character("Aragorn");
// hero.getName() == "Aragorn"
// hero.getHp() == 100
// hero.getGold() == 0
```

---

## 🟢 Core methods (60 оноо)

### 1. `getName()` → `String`

`name` талбарыг буцаана.

```java
hero.getName(); // "Aragorn"
```

### 2. `getHp()` → `int`
### 3. `getMaxHp()` → `int`
### 4. `getMp()` → `int`
### 5. `getMaxMp()` → `int`
### 6. `getGold()` → `int`

Тухайн талбарын одоогийн утгыг буцаах энгийн getter-ууд.

### 7. `takeDamage(int amount)` → `void`

Баатар хохирол амсна.

- `hp -= amount`
- Гэхдээ **`hp` 0-оос доош яваагүй** байх ёстой (`Math.max(0, hp - amount)`)
- `amount` сөрөг байвал юу ч өөрчлөхгүй (silently ignore)
  - **🔴 Bonus tier:** сөрөг утгад `IllegalArgumentException` шиднэ

**Жишээ:**
```java
hero.takeDamage(30);   // hp: 100 → 70
hero.takeDamage(200);  // hp: 70 → 0 (сөрөг болохгүй)
hero.takeDamage(-5);   // core: юу ч хийхгүй | bonus: throw IllegalArgumentException
```

### 8. `heal(int amount)` → `void`

Баатар эдгэрнэ.

- `hp += amount`
- Гэхдээ **`maxHp`-аас хэтрэхгүй** (`Math.min(maxHp, hp + amount)`)
- `amount` сөрөг байвал юу ч өөрчлөхгүй (silently ignore)
  - **🔴 Bonus:** сөрөг утгад `IllegalArgumentException`

**Жишээ:**
```java
Character hero = new Character("Gandalf"); // hp=100
hero.takeDamage(40); // hp=60
hero.heal(20);       // hp=80
hero.heal(999);      // hp=100 (maxHp-аас хэтрэхгүй)
```

### 9. `earnGold(int amount)` → `void`

Баатар алт олно.

- `gold += amount`
- `amount` сөрөг байвал юу ч өөрчлөхгүй (silently ignore)
  - **🔴 Bonus:** сөрөг утгад `IllegalArgumentException`

**Жишээ:**
```java
hero.earnGold(50);  // gold: 0 → 50
hero.earnGold(-10); // gold өөрчлөгдөхгүй (эсвэл throw)
```

---

## 🟡 Stretch methods (30 оноо)

### 10. `spendGold(int amount)` → `boolean`

Баатар алт зарцуулна.

- Хэрэв `gold >= amount` бол: `gold -= amount` хийгээд `true` буцаана
- Хэрэв **алт хүрэлцэхгүй** бол: юу ч өөрчлөхгүй, `false` буцаана
- Сөрөг `amount`-д `false` буцаана (эсвэл bonus-д throw)

**Жишээ:**
```java
hero.earnGold(100);
hero.spendGold(30);   // true, gold: 100 → 70
hero.spendGold(999);  // false, gold 70 хэвээрээ
```

### 11. `isAlive()` → `boolean`

- `hp > 0` бол `true`, эс бөгөөс `false`

**Жишээ:**
```java
hero.isAlive(); // true
hero.takeDamage(9999);
hero.isAlive(); // false
```

### 12. `toString()` override → `String`

**Формат:**
```
⚔️ [name] [HP: hp/maxHp, MP: mp/maxMp, Gold: gold]
```

**Жишээ:**
```java
Character hero = new Character("Aragorn");
System.out.println(hero);
// Output: ⚔️ Aragorn [HP: 100/100, MP: 50/50, Gold: 0]

hero.takeDamage(25);
hero.earnGold(15);
System.out.println(hero);
// Output: ⚔️ Aragorn [HP: 75/100, MP: 50/50, Gold: 15]
```

> **Яг ийм форматтай байх ёстой** — space, хаалт, таслал бүх зүйл шалгагдана.

---

## 🔴 Bonus methods (10 оноо)

### 13. `name` талбарыг `final` болгох

```java
private final String name;
```

Энэ нь constructor-оос хойш `name`-г өөрчилж болохгүй гэдгийг баталгаажуулна.

### 14. Сөрөг оролт → `IllegalArgumentException`

`takeDamage`, `heal`, `earnGold` method-ууд сөрөг утга авбал exception шиднэ:

```java
public void takeDamage(int amount) {
    if (amount < 0) {
        throw new IllegalArgumentException("Damage must be non-negative");
    }
    this.hp = Math.max(0, this.hp - amount);
}
```

---

## 🧪 Тест ажиллуулах

```bash
# Бүх tier
bash scripts/run_tests.sh

# Зөвхөн core
bash scripts/run_tests.sh --tag core

# Зөвхөн stretch
bash scripts/run_tests.sh --tag stretch

# Зөвхөн bonus
bash scripts/run_tests.sh --tag bonus
```

---

## ✅ Шалгуурын жагсаалт (Checklist)

### Core
- [ ] 6 talbar бүгд `private`
- [ ] Constructor параметртэй, талбар зөв initial утгатай
- [ ] 6 getter зөв ажиллах
- [ ] `takeDamage` — HP 0-оос доош үл явах
- [ ] `heal` — maxHp-аас хэтрэхгүй
- [ ] `earnGold` — сөрөг утгыг silently ignore

### Stretch
- [ ] `spendGold` — sufficient / insufficient
- [ ] `isAlive` — зөв логик
- [ ] `toString` — **яг форматтай**

### Bonus
- [ ] `name` — `final`
- [ ] `takeDamage(-5)` → `IllegalArgumentException`

---

## 🚫 Түгээмэл алдаанууд

1. **`public` талбар** — бүх талбар `private` байх ёстой
2. **Getter орхих** — тест reflection-оор талбар, method-ыг шалгана
3. **`takeDamage`-д `hp = hp - amount`** — сөрөг болгож болохгүй, `Math.max(0, ...)` ашигла
4. **`heal`-д maxHp шалгахгүй** — `Math.min(maxHp, ...)` ашигла
5. **`toString` формат буруу** — emoji, space, хаалт бүх зүйл яг таарах ёстой
6. **Constructor-д validation хэтрүүлэх** — spec дээр байхгүй бол битгий нэм
7. **Tests өөрчлөх** — `tests/` хавтсыг хөндөхгүй, тэгвэл PR бүтэлгүйтнэ
