# 100DoC
# java-design-patterns

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


## Day 3
### Builder Pattern
- A builder is a class whose only function is to build a complicated object.
- Can either give builder a constructor or return it via a static function.
- To make the builder fluent return this.
- Different facets of an object can be built with different builders in tandem via a base class. n
Related files in package *builder*

## Day 4 & Day 5
### Factory Pattern and Abstract Factory
- Factory is a component that care is responsible for wholesale creation of objects.
- A factory method is a static method that creates objects.
- A factory can take care of object creation
- A factory can be external or reside inside the object as an inner class
- Hierarchies of factories can be used to create related objects. 


## Day 6 & Day 7
### Prototype Pattern
- Complicated objects aren't designed from scratch.
- An existing design is a Prototype.
- We copy (clone) the prototype and customize it.
- To implement a prototype, partially construct an object and store it somewhere
- Clone the prototype
  - Deep copy
  - Serializeable

### Adapter pattern
- Get the interface you want from the interface you have.
- Determine the API you have and the API you need.
- Create a component which aggregates the adaptee
- Intermediate representations can pile up: use caching and other optimizations.


## Day 8
### Bridge pattern
- A mechanism that decouples an interface from an implementation.
- Helps avoid an entity explosion.
- Stronger form of encapsulation.

## Day 9
### Composite pattern
- Objects can use other objects via inheritance/composition
- Some composed and singular objects require similar or identical behaviors
- Composite design pattern lets us treat both of these types of objects uniformly
- Java supports container iteration with the Iterable<T> interface.
- A single object can masquerade as a collection by returning a single element collection containing only this.


## Day 10
### Decorator pattern
- Want to augment an object with additional functionality
- Do not want to rewrite or alter existing code (OCP)
- Want to keep new functionality separate (SRP)
- Need to be able to interact with existing structures
- Two options
    - Inherit from required object if possible, but some classes are final.
    - Build a decorator which simply references the decorated object. 
- Facilitates new behavior in objects without inheriting from there.
- Adapter-Decorator
    - Decorator adds new functionality
    - Adapter allows us to use some of the original functionality.
    
