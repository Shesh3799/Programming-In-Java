package org.example;

public class ClassExample implements Example{
    //Fields by default they have default scope
    // so String name ~ default String name
    // default has Package-private scope it means all the classes in the same package can access this variable
    // The other two scope are public and private
    String name;

    //If I keep scope as private I can't do p1.age but I can do p1.name assuming p1 is object of ClassExample class
    int age;

    // Constructor - optional
    // If we don't create constructor the java will provide no arg constructor as below
    ClassExample(){
        name = "Unknown";
        age = 18;
    }

    //Parameterized Constructor
    ClassExample(String name, int age){
        this.name = name;
        this.age = age;
    }

    //Methods - optional
    //Even methods have a 'default' scope we can have private/public scope to methods as well
    String getName(){
        return this.name;
    }

    int getAge(){
        return this.age;
    }

    @Override
    public String toString() {
        //This method is used if I try to print ClassExample object
        return String.format("[name:%s age:%d]", name, age);
    }

    @Override
    public void testFunctionality() {
        //This will call default constructor and assign default values
        ClassExample classExample = new ClassExample();
        System.out.println("ClassExample name : "+ classExample.getName()+" age:"+ classExample.getAge());

        //This will invoke parameterized constructor
        ClassExample p1 = new ClassExample("Shesh", 18);
        System.out.println("ClassExample name : "+p1.getName()+" age:"+p1.getAge());

        //The below print statemnt invokes toString() method defined in class
        System.out.println("Printing p1 object = "+p1);

        // Using newInstance() method to create object
        Class<?> clazz = null;
        try {
            clazz = Class.forName("org.example.ClassExample");
            ClassExample obj = (ClassExample) clazz.getDeclaredConstructor().newInstance();
            System.out.println("Printing obj = "+p1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
