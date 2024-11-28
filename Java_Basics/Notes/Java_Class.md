# What is a class in Java?
A class is a group of objects which have common properties. It is a template or blueprint from which objects are created. 
It is a logical entity.

**A class in Java can contain:**
* Fields
* Methods
* Constructors
* Blocks
* Nested class and interface

Syntax:
```java
class <class_name> {
    // Fields
    // Constructors
    // Methods
}
```

# Instance variable in Java
A variable which is created inside the class but outside the method is known as an instance variable. Instance 
variable doesn't get memory at compile time. It gets memory at runtime when an object or instance is created. 
That is why it is known as an instance variable.

By default, the scope of instance variable is `default`

# Method in Java
In Java, a method is like a function which is used to expose the behavior of an object.

By default, the scope of instance variable is `default`

# Different scope for methods and instance variables in Java
- published: visible to external users of a Javabean
- public: visible to all classes	
- protected: visible to classes outside the package that inherit the class, also to all classes in the package.
- default: visible to all classes of the package.	
- private: visible only within the class, not by inheritors, not by other classes in the package.
- local: visible only to the block of the method in which the variables were declared.	

# Different ways to create an object in Java
1. **By new keyword**
```java
Person p1 = new Person();
//Multiple objects
Person p1=new Person(), p2=new Person();
```
2. **By newInstance() method**
```java
Class<?> clazz = Class.forName("org.example.ClassExample");
Person obj = (Person) clazz.getDeclaredConstructor().newInstance();
```
3. **By clone() method**
```java
// The class needs to implement Cloneable for this to work
Person p2 = p1.clone();
```

# Constructors in Java
In Java, a constructor is a block of codes similar to the method. It is called when an instance of the class is created. 
At the time of calling constructor, memory for the object is allocated in the heap memory.

It is a special type of method which is used to initialize the object.

Every time an object is created using the new keyword, at least one constructor is called.

It calls a default constructor if there is no constructor available in the class. In such case, Java compiler provides 
a default constructor by default.

There are two types of constructors in Java: no-arg constructor, and parameterized constructor.

**Rules for creating Java Constructor**
* Constructor name must be the same as its class name.
* A Constructor must have no explicit return type.
* A Java constructor cannot be abstract, static, final, and synchronized.

## 1. Java Default Constructor
A constructor is called "Default Constructor" when it does not have any parameter.
Syntax:
```java
<class_name>(){}  
```
Check code in [Person.java](../src/main/java/org/example/ClassExample.java)

### What is the purpose of a default constructor?
The default constructor is used to provide the default values to the object like 0, null, etc., depending on the type.

## 2. Java Parameterized Constructor
A constructor which has a specific number of parameters is called a parameterized constructor.

Check code in [Person.java](../src/main/java/org/example/ClassExample.java)

### Why use the parameterized constructor?
The parameterized constructor is used to provide different values to distinct objects. However, you can provide the 
same values also.

## Constructor Overloading in Java
In Java, a constructor is just like a method but without return type. It can also be overloaded like Java methods.

Constructor overloading in Java is a technique of having more than one constructor with different parameter lists. 
They are arranged in a way that each constructor performs a different task. They are differentiated by the compiler 
by the number of parameters in the list and their types.

Check code in [Person.java](../src/main/java/org/example/ClassExample.java)
In above code we have default and parametrized constructor demonstrating constructor overloading.

## Constructor Chaining
Constructor chaining in Java is a practice where one constructor calls another constructor of the same class or a 
superclass during object creation. It is typically done using either this() to call another constructor in the same 
class or super() to call a constructor in the superclass. By centralizing common construction logic, constructor 
chaining helps reduce code redundancy and increases the code's readability.

**Note that the super should always be the first statement of the subclass constructor.**

Example:
```java
public class Person{
    String name;
    
    Person(){
        //Constructor chaining
        this("Unknown");
    }
    Person(String name){
        this.name = name;
    }
}
```

## Java Super Class Constructor
In Java, the concept of the "super constructor" refers to a subclass's ability to explicitly invoke a constructor 
of its superclass. It is a fundamental aspect of Java's inheritance feature, which allows one class to inherit fields 
and methods from another. Using the super keyword to call a superclass's constructor is crucial for the proper 
initialization of an object's inheritance hierarchy.

```java
import org.example.ClassExample;
import org.example.Person;

public class student extends ClassExample {
    Student() {
        super("Unknown");
    }
}
```

## Java Copy Constructor
There is no copy constructor in Java. However, we can copy the values from one object to another like copy 
constructor in C++.

There are the following ways to copy the values of one object into another:
1. By Using Constructor
```java
public class Person{
    String name;
    Person(String name){
        this.name = name;
    }
    //constructor to initialize another object  
    Person(Person p){
        this.name = p.name;
    }
}
//main code
Person p1 = new Person("Shesh");    
Person p = new Person(p1);
```
2. By Assigning the Values of One Object into Another
```java
Person p = new Person("Shesh");
Person p1 = new Person();
p1.name = p.name;
```
3. By Using clone() Method of the Object Class
For this method the class should implement cloneable interface

# Java Inner Classes (Nested Classes)
Java inner class or nested class is a class that is declared inside the class or interface.

We use inner classes to logically group classes and interfaces in one place to be more readable and maintainable.

Additionally, it can access all the members of the outer class, including private data members and methods.

Syntax of Inner class:
```java
class Java_Outer_class{  
 //code  
 class Java_Inner_class{  
  //code  
 }  
}  
```
## Need of Java Inner class
Sometimes users need to program a class in such a way so that no other class can access it. Therefore, it would be 
better if you include it within other classes.

If all the class objects are a part of the outer object then it is easier to nest that class inside the outer class. 
That way all the outer class can access all the objects of the inner class.

Practical Example [Library.java](../src/main/java/org/example/Library.java)

## Types of Nested classes
### Static nested class
A static class is a class that is created inside a class, is called a static nested class in Java. It cannot access 
non-static data members and methods. It can be accessed by outer class name.

* It can access static data members of the outer class, including private.
* The static nested class cannot access non-static (instance) data members

Example:
```java
public class TestOuter2{  
  static int data=30;  
  static class Inner{  
   static void msg(){System.out.println("data is "+data);}  
  }  
  public static void main(String args[]){  
  TestOuter2.Inner.msg();//no need to create the instance of static nested class  
  }  
}  
```

### Non-static nested class (inner class)
**1. Member inner class**:

A non-static class that is created inside a class but outside a method is called member inner class. It is also known 
as a regular inner class. It can be declared with access modifiers like public, default, private, and protected.
```java
class Outer{  
 //code  
 class Inner{  
  //code  
 }  
}

//main
Outer obj = new Outer();
Outer.Inner in = new obj.new Inner();
```
Check example in [MemberInnerClassExample.java](../src/main/java/org/example/MemberInnerClassExample.java)

**Internal working of Java member inner class**

The java compiler creates two class files in the case of the inner class. The class file name of the inner class 
is "Outer$Inner". If you want to instantiate the inner class, you must have to create the instance of the outer class. 
In such a case, an instance of inner class is created inside the instance of the outer class.


**2. Anonymous inner class:**

Java anonymous inner class is an inner class without a name and for which only a single object is created. 
An anonymous inner class can be useful when making an instance of an object with certain "extras" such as overloading 
methods of a class or interface, without having to actually subclass a class.

In simple words, a class that has no name is known as an anonymous inner class in Java. It should be used if you have 
to override a method of class or interface. Java Anonymous inner class can be created in two ways:
* Class (may be abstract or concrete).
* Interface

```java
abstract class Person{  
  abstract void eat();  
}  
class TestAnonymousInner{  
 public static void main(String args[]){
  //Anonymous class   
  Person p=new Person(){  
    void eat(){System.out.println("nice fruits");}  
  };  
  p.eat();  
 }  
}  
```

**Internal working of given code**

1. A class is created, but its name is decided by the compiler, which extends the Person class and provides the 
implementation of the eat() method.
2. An object of the Anonymous class is created that is referred to by 'p,' a reference variable of Person type.

Check example code in [AnonymousInnerClass.java](../src/main/java/org/example/AnonymousInnerClassExample.java)

**3. Local inner class**

A class i.e., created inside a method, is called local inner class in java. Local Inner Classes are the inner classes 
that are defined inside a block. Generally, this block is a method body. Sometimes this block can be a for loop, or an 
if clause. Local Inner classes are not a member of any enclosing classes. They belong to the block they are defined 
within, due to which local inner classes cannot have any access modifiers associated with them. However, they can be 
marked as final or abstract. These classes have access to the fields of the class enclosing it.

```java
public class localInner1{  
 private int data=30;//instance variable  
 void display(){  
  class Local{  
   void msg(){System.out.println(data);}  
  }  
  Local l=new Local();  
  l.msg();  
 }  
 public static void main(String args[]){  
  localInner1 obj=new localInner1();  
  obj.display();  
 }  
}  
```

# Abstract class
An abstract class in Java acts as a partially implemented class that itself cannot be instantiated. It exists only for 
subclassing purposes, and provides a template for its subcategories to follow. Abstract classes can have 
implementations with abstract methods. Abstract methods are declared to have no body, leaving their implementation 
to subclasses.

## Points to Remember
* An abstract class must be declared with an abstract keyword.
* It can have abstract and non-abstract methods.
* It cannot be instantiated.
* It can have constructors and static methods also.
* It can have final methods which will force the subclass not to change the body of the method.
* A class containing abstract methods should also be abstract. 
* A subclass must override all abstract methods of an abstract class. However, if the subclass is declared abstract, 
it's not mandatory to override abstract methods
* Abstract classes can have constructors, which are invoked when a subclass object is created. These constructors 
are used to initialize the state of the abstract class.

Example:
```java
public abstract class Shape {  
    // Abstract method  
    public abstract double area();  
    // Concrete method  
    public void display() {  
        System.out.println("This is a shape.");  
    }  
}
```
## Abstract Method in Java
A method which is declared as abstract and does not have implementation is known as an abstract method.  All the child 
classes inherited from the abstract superclass must provide the implementation of the abstract method.

## When to Use Abstract Classes?
* **Code Reusability:** Abstract classes facilitate code reuse by allowing common methods to be implemented once and 
inherited by multiple subclasses.

* **Defining a Common Interface:** Abstract classes can define a common interface for a group of related classes, 
ensuring consistency in their structure and behavior.

* **Enforcing Method Implementation:** Abstract classes can enforce the implementation of certain methods by declaring 
them as abstract, thereby ensuring that subclasses provide necessary functionality.

