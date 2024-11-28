package org.example;

public class InterfaceExample implements Example {
    // I can have private/public/default scope for interface inside class
    interface DummyInterface1{
        int data = 100;

        // If I use below syntax to define fun it will give compile time warning
        // void display(){}
        default void display(){
            System.out.println("The value of data is "+data);
        }

        //I can have private methods inside interface but they need to have a body
        //Example
//        private int add(int a, int b) {
//            return a+b;
//        }
        int add(int a, int b);
    }

    interface DummyInterface2{
        default void display(){
            System.out.println("I'm dummy interface 2");
        }
    }
    //With above interface the below class definition is not valid
    // class Dummy implements DummyInterface1, DummyInterface2{}

    class Dummy implements DummyInterface1{

        @Override
        public int add(int a, int b) {
            return a+b;
        }
    }

    //Nested interface
    interface I1{
        void display();

        //The nested interface inside interface is always public and can't be made private/default etc
        // private interface I2 -> not valid
        interface I2{
            void display();
        }
    }

    @Override
    public void testFunctionality() {

        // By default interface variables are final static, so below line is not valid
        //Dummy.data = 20;

        Dummy dummy = new Dummy();
        dummy.display();

        //Nested interface test
        class NestedInterfaceTest implements I1.I2{

            @Override
            public void display() {
                System.out.println("Overriding I1");
            }
        }
        I1.I2 i2 = (I1.I2) new NestedInterfaceTest();
        i2.display();

    }
}
