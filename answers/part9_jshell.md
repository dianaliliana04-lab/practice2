# Часть 9 — Эксперименты в jshell

## Как запустить jshell

Откройте терминал IntelliJ (View → Tool Windows → Terminal) и введите:
```
jshell
```
Для выхода: `/exit`

---

## Задание 9.1: Sealed-классы

### Команды (скопируйте и вставьте в jshell)

```
sealed interface Shape permits Circle, Square {}
record Circle(double r) implements Shape {}
record Square(double side) implements Shape {}
Shape s = new Circle(5)
s instanceof Circle c ? "Круг r=" + c.r() : "Не круг"
```

### Фактический вывод:

```
(впишите результат выполнения каждой команды)
```

### Вопрос: Что произойдёт при попытке создать `record Triangle(double a) implements Shape {}`?

**Ваш ответ:**



---

## Задание 9.2: Цепочка лямбд

### Команды

```
import java.util.function.*
Function<String, String> trim = String::trim
Function<String, String> upper = String::toUpperCase
Function<String, String> exclaim = s -> s + "!"
var pipeline1 = trim.andThen(upper).andThen(exclaim)
var pipeline2 = exclaim.compose(upper).compose(trim)
pipeline1.apply("  hello world  ")
pipeline2.apply("  hello world  ")
```

### Фактический вывод:

```
(впишите результат)
```

### Вопрос: Дают ли `andThen()` и `compose()` одинаковый результат? В каком случае результаты будут различаться?

**Ваш ответ:**



---

## Задание 9.3: Сравнение EnumSet и HashSet

### Команды

```
enum Color { RED, GREEN, BLUE, YELLOW, CYAN, MAGENTA, WHITE, BLACK }
var enumSet = java.util.EnumSet.of(Color.RED, Color.GREEN, Color.BLUE)
var hashSet = new java.util.HashSet<>(java.util.Set.of(Color.RED, Color.GREEN, Color.BLUE))
enumSet.contains(Color.RED)
hashSet.contains(Color.RED)
enumSet.getClass().getSimpleName()
hashSet.getClass().getSimpleName()
```

### Фактический вывод:

```
jshell> sealed interface Shape permits Circle, Square {}
|  created sealed interface Shape

jshell> record Circle(double r) implements Shape {}
|  created record Circle

jshell> record Square(double side) implements Shape {}
|  created record Square

jshell> Shape s = new Circle(5)
s ==> Circle[r=5.0]

jshell> s instanceof Circle c ? "Круг r=" + c.r() : "Не круг"
$5 ==> "Круг r=5.0"
```

### Вопрос: Почему внутренний класс EnumSet называется `RegularEnumSet`? Что произойдёт, если enum будет иметь больше 64 констант?

**Ваш ответ:**
EnumSet внутри реализован двумя разными классами в зависимости от количества констант в enum:

RegularEnumSet — используется, когда количество констант ≤ 64. Хранит элементы в виде битовой маски в поле long (64 бита).

JumboEnumSet — используется, когда констант > 64. Хранит битовую маску в массиве long[].

Если enum содержит более 64 констант, EnumSet.of(...) автоматически вернёт экземпляр JumboEnumSet. Это происходит прозрачно для пользователя, поэтому код, использующий EnumSet, продолжает работать без изменений. Такая оптимизация позволяет эффективно использовать память и обеспечивать высокую производительность операций с множествами enum-констант.


