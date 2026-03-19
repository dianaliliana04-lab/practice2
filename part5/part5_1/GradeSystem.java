package part5.part5_1;

import java.util.*;

/**
 * Задание 5.1 — Система оценок (enum, record, EnumMap, EnumSet)
 *
 * Тема: перечисления (enum), записи (record), EnumMap и EnumSet.
 *
 * Ключевая теория:
 *   - enum — перечисление фиксированных констант. Может иметь поля,
 *     конструктор и методы.
 *   - record (Java 16+) — неизменяемый класс данных. Компилятор генерирует
 *     конструктор, геттеры, equals(), hashCode(), toString().
 *   - Компактный конструктор record: Student { if (name == null) throw ...; }
 *     — без списка параметров, с доступом к ним.
 *   - EnumMap<K, V> — Map, оптимизированный для enum-ключей.
 *     Внутри — массив по ordinal(), O(1) доступ.
 *   - EnumSet — Set для enum, реализован как битовая маска, очень быстрый.
 *
 * Как запустить: нажмите ▶ рядом с main.
 */
public class GradeSystem {

    // === Enum Grade ===

    /**
     * Оценка с описанием и GPA-значением.
     *
     * Синтаксис enum с полями:
     *
     *     enum Grade {
     *         A("Отлично", 4.0),
     *         B("Хорошо", 3.0);
     *         // ...
     *         private final String description;
     *         private final double gpaValue;
     *         Grade(String description, double gpaValue) { ... }
     *     }
     */
    enum Grade {
        A("Отлично", 4.0),
        B("Хорошо", 3.0),
        C("Удовлетворительно", 2.0),
        D("Неудовлетворительно", 1.0),
        F("Провал", 0.0);

        private final String description;
        private final double gpaValue;

        Grade(String description, double gpaValue) {
            // ▼ ВАШ КОД ЗДЕСЬ ▼
            this.description = description;
            this.gpaValue = gpaValue;
            // ▲ КОНЕЦ ВАШЕГО КОДА ▲
        }

        /** Возвращает описание оценки (например, "Отлично"). */
        public String getDescription() {
            // ▼ ВАШ КОД ЗДЕСЬ ▼
            return null; // TODO: верните description
            // ▲ КОНЕЦ ВАШЕГО КОДА ▲
        }

        /** Возвращает GPA-значение (например, 4.0). */
        public double getGpaValue() {
            // ▼ ВАШ КОД ЗДЕСЬ ▼
            return 0; // TODO: верните gpaValue
            // ▲ КОНЕЦ ВАШЕГО КОДА ▲
        }

        /**
         * Возвращает true, если оценка является проходной (не D и не F).
         *
         * Подсказка: return this != F && this != D;
         */
        public boolean isPassing() {
            // ▼ ВАШ КОД ЗДЕСЬ ▼
            return false; // TODO: верните this != F && this != D
            // ▲ КОНЕЦ ВАШЕГО КОДА ▲
        }

        /**
         * Преобразует числовую оценку (0–100) в Grade.
         *
         * Шкала: A ≥ 90, B ≥ 80, C ≥ 70, D ≥ 60, иначе F.
         *
         * Подсказка:
         * if (score >= 90) return A; else if (score >= 80) return B; ...
         */
        public static Grade fromScore(int score) {
            // ▼ ВАШ КОД ЗДЕСЬ ▼
            return F; // TODO: if (score >= 90) return A; else if (score >= 80) return B; ...
            // ▲ КОНЕЦ ВАШЕГО КОДА ▲
        }
    }

    // === Record Student ===

    /**
     * Студент с именем и ID.
     *
     * Компактный конструктор:
     *
     *     record Student(String name, int id) {
     *         Student {   // без скобок с параметрами!
     *             if (name == null || name.isBlank()) throw new IllegalArgumentException("...");
     *             if (id <= 0) throw new IllegalArgumentException("...");
     *         }
     *     }
     */
    record Student(String name, int id) {
        Student {
            // TODO: проверьте, что name не null и не пустое, id > 0
            // Выбросите IllegalArgumentException при нарушении
        }
    }

    // === Метод main ===

    public static void main(String[] args) {

        // TODO: Создайте 6–7 студентов и присвойте им числовые оценки
        //   Student s1 = new Student("Анна", 1);
        //   Grade g1 = Grade.fromScore(95);   // → A
        //   ...

        // TODO: Создайте EnumMap<Grade, List<Student>> и заполните его
        //   var gradeMap = new EnumMap<Grade, List<Student>>(Grade.class);
        //   gradeMap.computeIfAbsent(g1, k -> new ArrayList<>()).add(s1);

        // TODO: Создайте EnumSet проходных оценок
        //   var passingGrades = EnumSet.of(Grade.A, Grade.B, Grade.C);
        //   или отфильтруйте: Arrays.stream(Grade.values()).filter(Grade::isPassing)...

        // TODO: Выведите сводку для каждой оценки

        // TODO: Подсчитайте средний GPA всех студентов

        // ▼ ВАШ КОД ЗДЕСЬ ▼

        // ▲ КОНЕЦ ВАШЕГО КОДА ▲
    }
}
