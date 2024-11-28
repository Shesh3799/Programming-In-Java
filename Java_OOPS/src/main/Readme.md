# OOPs (Object-Oriented Programming) concepts
Object means a real-world entity such as a pen, chair, table, computer, watch, etc. Object-Oriented Programming is a 
methodology or paradigm to design a program using classes and objects. It simplifies software development and 
maintenance by providing some concepts:
* Class
* Object
* Abstraction
* Encapsulation
* Inheritance
* Polymorphism

# Class
A Class is a user-defined blueprint or prototype from which objects are created. It represents the set of properties 
or methods that are common to all objects of one type. Using classes, you can create multiple objects with the same 
behavior instead of writing their code multiple times. In general, class declarations can include these components 
in order:

1. Modifiers: A class can be public or have default access (Refer to this for details).
2. Class name: The class name should begin with the initial letter capitalized by convention.
3. Body: The class body is surrounded by braces, { }.

# Object
An Object is a basic unit of Object-Oriented Programming that represents real-life entities. An Object can be defined 
as an instance of a class. It contains an address and takes up some space in memory. Objects can communicate without 
knowing the details of each other's data or code.

# Abstraction
Data Abstraction is the property by virtue of which only the essential details are displayed to the user.

Consider a real-life example of a man driving a car. The man only knows that pressing the accelerators will increase 
the car speed or applying brakes will stop the car, but he does not know how on pressing the accelerator, the speed is 
actually increasing. He does not know about the inner mechanism of the car or the implementation of the accelerators, 
brakes etc. in the car. This is what abstraction is.

In Java, abstraction is achieved by interfaces and abstract classes. We can achieve 100% abstraction using interfaces.

```java
// abstract class
abstract class Math {
    // abstract methods declaration
    abstract void add();
    abstract void mul();
    abstract void div();
}
```

# Encapsulation
It is defined as the wrapping up of data under a single unit. It is the mechanism that binds together the code and 
the data it manipulates. Another way to think about encapsulation is that it is a protective shield that prevents the 
data from being accessed by the code outside this shield.

* Technically, in encapsulation, the variables or the data in a class is hidden from any other class and can be 
accessed only through any member function of the class in which they are declared.
* In encapsulation, the data in a class is hidden from other classes, which is similar to what data-hiding does. 
So, the terms “encapsulation” and “data-hiding” are used interchangeably.
* Encapsulation can be achieved by declaring all the variables in a class as private and writing public methods in 
the class to set and get the values of the variables.

```java
// Encapsulation using private modifier 

// Employee class contains private data
// called employee id and employee name
class Employee {
      private int empid;
    private String ename;
  
      // Accessing the Element
      // Using Method
      public int get_id(){
          return empid;
    }
  
      public String get_name(){
          return get_name;
    }
}
```

# Inheritance
It is the mechanism in Java by which one class is allowed to inherit the features (fields and methods) of another class. 
We are achieving inheritance by using extends keyword. Inheritance is also known as “is-a” relationship.

* **Superclass:** The class whose features are inherited is known as superclass (also known as base or parent class).
* **Subclass:** The class that inherits the other class is known as subclass (also known as derived or extended or 
child class). The subclass can add its own fields and methods in addition to the superclass fields and methods.
* **Reusability:** Inheritance supports the concept of “reusability”, i.e. when we want to create a new class and there 
is already a class that includes some of the code that we want, we can derive our new class from the existing class. 
By doing this, we are reusing the fields and methods of the existing class.

```java
//base class or parent class or super class
class A{
  //parent class methods
  void method1(){}
  void method2(){}
}

//derived class or child class or base class
class B extends A{  //Inherits parent class methods
  //child class methods
  void method3(){}
  void method4(){}
}
```

# Polymorphism
It refers to the ability of object-oriented programming languages to differentiate between entities with the same name 
efficiently. This is done by Java with the help of the signature and declaration of these entities. The ability to 
appear in many forms is called polymorphism.

## Types of Polymorphism
**1. Method Overloading:** Also, known as compile-time polymorphism, is the concept of Polymorphism where more than one method share the same 
name with different signature(Parameters) in a class. The return type of these methods can or cannot be same.

**2. Method Overriding:** Also, known as run-time polymorphism, is the concept of Polymorphism where method in the child 
class has the same name, return-type and parameters as in parent class. The child class provides the implementation in 
the method already written.

```java
// Java Program to Demonstrate
// Method Overloading and Overriding

// Parent Class
class Parent {

    // Method Declared
    public void func(){
        System.out.println("Parent Method func");
    }

    // Method Overloading
    public void func(int a){
        System.out.println("Parent Method func " + a);
    }
}

// Child Class
class Child extends Parent {

    // Method Overriding
    @Override 
      public void func(int a){
        System.out.println("Child Method " + a);
    }
}

// Main Method
public class Main {
    public static void main(String args[]){
        Parent obj1 = new Parent();
        obj1.func();
        obj1.func(5);

        Child obj2 = new Child();
        obj2.func(4);
    }
}
```
