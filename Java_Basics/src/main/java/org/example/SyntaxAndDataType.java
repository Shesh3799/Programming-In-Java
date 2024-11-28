package org.example;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.random.RandomGenerator;

public class SyntaxAndDataType implements Example{

    //By default initialized to zero
    int value;

    //The static class is created so that we can create its object in static method else it is not possible
    static class Person{
        //As below variables are member variables, all the member variables will be initialized to default value
        String name;
        int age;

        //This method is added so that when we do sout for ClassExample object it prints below string
        @Override
        public String toString() {
            return String.format("Name = %s and Age = %d", name, age);
        }
    }

    public static void primitiveDataTypes(){
        System.out.println("\n########## Testing Primitive Data Type ##########");
        // If I use below code the compilation fails with error
        // variable b might have not initialized
        // boolean b;
        boolean b = false;
        System.out.println("Values of boolean is "+b);

        char c = 100; // This is valid the character stored will be equivalent ASCII letter with value
        System.out.println("Value of chat is "+c);
        c = 'A'; // This is valid
        System.out.println("Value of chat is "+c);

        //We can't declare static variables in methods
        //static boolean sb;

        //Possible
        int i = c;
        long l = 200L;
        float f = 2.1f;
        double d = 1.2d;

        // The below code results into compilation error
        // java: incompatible types: possible lossy conversion from int to byte
        // In Java downcasting is not possible but upcasting is possible
        // byte by = 128; //Not possible because byte is 1 byte and it can store till 127
        System.out.println("########## Primitive Data type testing completed##########\n");

    }

    public static void nonPrimitiveDataTypes(){
        System.out.println("\n########## Testing Non Primitive##########");
        Person p = new Person();
        System.out.println("The person details : "+ p);

        Example_Enum option = Example_Enum.AbstractExample;
        System.out.println("Option is : "+option);
        System.out.println("########## Non Primitive testing completed##########\n");
    }

    public static void stringsInJava(){
        System.out.println("\n########## Testing String ##########");
        String s1 = new String("Hello");
        String s2 = new String("Hello");
        String s3 = "Hello";
        String s4 = s1;
        String s5 = "hello";

        //if we do s1==s2 then references are compared not objects that these references are pointing
        // This is like *s1, *s2 if we do s1==s2 it will compare variables and s1.equals(s2) is *s1==*s2
        System.out.println("Are string references pointing to same object? "+s1.equals(s2));
        System.out.println("Are string references pointing to same object? "+s1.equals(s3));
        System.out.println("Are string references pointing to same object? "+s1.equals(s4));
        System.out.println("Are string references pointing to same object? "+s1.equals(s5));
        System.out.println("########## String testing completed##########\n");
    }

    public static void StringBufferExample(){
        System.out.println("\n########## Testing String Buffer##########");
        StringBuffer sb = new StringBuffer("Hello");
        sb.append(" World!!!");
        System.out.println("String buffer value is : "+sb);

        //When you construct a StringBuilder without specifying a capacity, the default initial capacity is 16.
        //However, when you pass a string to the constructor (like "Hello, World!"), the initial capacity is set to be
        // the string length + 16. In this case 16+len("Hello") = 21

        System.out.println("Initial Capacity = "+sb.capacity()+" Length = "+sb.length());

        sb.insert(11, " from Shesh");
        System.out.println("After insert buffer value is : "+sb);
        //Appending int, similarly we can insert int value at specific pos
        sb.append(18);
        System.out.println("After appending int to buffer value is : "+sb);

        //The ensureCapacity(int minCapacity) method is used to guarantee that the StringBuilder has at least the
        // specified minimum capacity.
        //If the current capacity is less than the requested minimum, the capacity will be increased to accommodate
        // the minimum. If the current capacity is already sufficient, nothing changes.
        //So, the capacity is increased to 90 (which is an internal implementation decision based on the current
        // capacity and the minimum requested).

        sb.ensureCapacity(50);
        System.out.println("Capacity = "+sb.capacity()+" Length = "+sb.length());

        //Used to reverse a string
        //sb.reverse();

        //Used to fetch substring
        //sb.substring();

        // Converts string buffer to string
        //sb.toString();

        System.out.println("########## String Buffer testing completed##########\n");
    }

    public void conditional_statements(){
        System.out.println("\n##########Testing conditional statements##########");
        // Generate random number between -100 and +100
        int randomNum = ThreadLocalRandom.current().nextInt(-100, 101);
        if(randomNum == 0){
            System.out.println("Value is zero");
        } else if (randomNum > 0) {
            System.out.println("Value is positive");
        } else {
            System.out.println("Value is negative");
        }

        // This will generate random number between 0 to 2
        randomNum = ThreadLocalRandom.current().nextInt(3);

        // switch example
        switch (randomNum){
            case 0 -> System.out.println("Value is 0");
            case 1 -> System.out.println("Value is 1");
            case 2 -> System.out.println("Value is 2");
            default -> System.out.println("Unexpected value");
        }
        System.out.println("##########Conditional statements testing completed##########\n");
    }

    @Override
    public void testFunctionality() {
        SyntaxAndDataType.primitiveDataTypes();

        // If we don't initialize member variables of a class. It will be initialized to default value
        SyntaxAndDataType syntaxAndDataType = new SyntaxAndDataType();
        System.out.println("Non initialized value is : "+syntaxAndDataType.value);
        SyntaxAndDataType.nonPrimitiveDataTypes();
        syntaxAndDataType.conditional_statements();
        SyntaxAndDataType.stringsInJava();
        SyntaxAndDataType.StringBufferExample();
    }
}
