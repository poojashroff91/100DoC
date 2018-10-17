#100DoC
# java-design-pattens

## Day 1
1. SRP - Single Responsibility Principle
Single class should have one primary responsibility
Separation of concerns - different classes handling different tasks/problems
Related file - Journal.java

2. OCP - Open Close Principle + Specification
Open for extension, closed for modification
If you're trying to filter things make sure you are not repeating yourself. Use composition of interfaces.
Related file - Product.java


## Day 2
3. Liskov Substitution Principle
You should be able to substitute a subclass for a baseclass without breaking anything.
If broken, code will behave incorrectly on inheritance.
Related file - Rectangle.java

4. Interface Aggregation Principle
A recommendation on how to break a bigger interface into smaller interfaces.
Related file - Document.java

5. Dependency Inversion Principle
    A. High level modules should not depend on low level modules. Both should depend on abstractions.
    B. Abstractions should not depend on details. Details should depend on abstractions.
Related file - Person.java


