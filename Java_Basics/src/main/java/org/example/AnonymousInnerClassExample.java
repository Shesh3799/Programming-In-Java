package org.example;

//The class can be abstract or Interface or Concrete class. It works with all
public class AnonymousInnerClassExample implements Example {
    void display(){
        System.out.println("I'm default implementation");
    }

    @Override
    public void testFunctionality() {
        AnonymousInnerClassExample innerClass = new AnonymousInnerClassExample(){
            void display(){
                System.out.println("I'm overridden method");
            }
        };
        innerClass.display();
    }
}
