# Java 21+ Educational Project Guidelines

## Overview

This is an educational programming course on **Modern Programming Technologies** (Практика 2). The project teaches object-oriented principles and Java 21+ features through structured, incrementally complex exercises.

## Code Style

### Documentation & Comments
- **Preserve Russian educational context**: Keep Russian comments explaining concepts, especially in class-level Javadoc
- **Javadoc first**: Every public class, method, and interface must have a comprehensive Javadoc block
- **Concept explanations**: Comments should explain the *why* behind code, not just *what* it does
  - Example: "Record may contain arbitrary methods (not only getters)" rather than just "// Add methods"
- **Key theory sections**: Use structured comment blocks explaining OOP principles or Java features being demonstrated:
  ```java
  /**
   * Тема: sealed-интерфейсы (Java 17+) и паттерн-матчинг (Java 21+).
   * 
   * Ключевая теория:
   *   - sealed interface ограничивает набор допустимых реализаций...
   */
  ```

### Code Organization
- **Package structure**: Follow the learning progression (`part1`, `part2`, etc.) with sub-packages for topics (`part2.part2_1`, `part2.part2_2`)
- **Main entry points**: Clearly document executable classes; see [docs/ЗАПУСК_КЛАССОВ.md](../docs/ЗАПУСК_КЛАССОВ.md) for the list
- **Educational markers**: When creating TODO sections for students, use the standard markers:
  ```java
  // ▼ ВАШ КОД ЗДЕСЬ ▼
  // ... implementation ...
  // ▲ КОНЕЦ ВАШЕГО КОДА ▲
  ```

## Modern Java Features (Java 21+)

When implementing or refactoring code, **prioritize these features**:

### Records
- Use records for immutable data carriers (e.g., `Temperature(double value, Unit unit)`)
- Include compact constructors with validation
- Add computed methods beyond just getters
- Custom `toString()` for user-friendly output

### Enums
- Leverage enum with abstract methods for state-specific behavior (e.g., `enum Unit`)
- Combine with records when representing hierarchical data
- Use `EnumMap` and `EnumSet` for efficient collection operations

### Sealed Types
- Use `sealed interface` or `sealed class` to restrict implementations
- Include `permits` clause listing all allowed subtypes
- This enables exhaustive pattern matching in switch statements

### Pattern Matching
- Leverage Java 21 pattern matching in switch expressions
- Use `instanceof` patterns to eliminate casts
- Enable compile-time exhaustiveness checking with sealed types

### Lambdas & Stream API
- Prefer streams over loops for collections processing
- Use lambda expressions where functional interfaces are needed
- Build pipelines with clearer intent (filter, map, reduce, collect)

## Architecture & Design

### Encapsulation
- Use appropriate access modifiers: `private`, package-private (default), `protected`, `public`
- Define fields in abstract base classes as `protected` to allow subclass access
- Document access rationale in class-level comments

### Inheritance Hierarchies
- Design abstract base classes with template methods (e.g., `totalCompensation()` calling `calculateBonus()`)
- Force subclasses to implement abstract methods that vary by type
- Keep common behavior (non-abstract methods) in the base class

### Sealed Hierarchies
- Use sealed classes/interfaces to restrict the inheritance tree
- Document the complete hierarchy in Javadoc
- Prefer records as concrete implementations of sealed interfaces

## Build & Test

### Compilation
- Target Java 21+
- No warnings from the compiler

### Running Classes
- Each task may have a specific entry point (main class)
- Use [docs/ЗАПУСК_КЛАССОВ.md](../docs/ЗАПУСК_КЛАССОВ.md) to find the correct main class
- One task = one runnable demonstration, typically named for the concept being taught

## When to Refactor

Apply these guidelines when:
- Adding new functionality to existing code
- Refactoring student-submitted assignments
- Creating new example classes for a topic
- Fixing compilation issues or improving code clarity

Do **not** break educational value by:
- Removing explanatory comments
- Collapsing learning examples into production-style one-liners
- Changing the learning progression structure

## Example: How Guidance Applies

**Bad**: Suggest a plain for-loop when streams could showcase functional programming:
```java
// ❌ Avoid for educational context
for (Employee emp : employees) {
    System.out.println(emp);
}
```

**Good**: Recommend stream-based approach with explanation:
```java
// ✅ Modern Java approach (Java 21+)
employees.stream()
    .map(Employee::toString)
    .forEach(System.out::println);
```

---

**Last updated**: March 2026  
**Target JDK**: 21 or newer
