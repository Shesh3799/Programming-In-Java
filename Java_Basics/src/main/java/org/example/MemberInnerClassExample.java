package org.example;

public class MemberInnerClassExample implements Example{
    private String message = "Hello Outer";
    class Inner {
        int data =100;
        void message(){
            System.out.println(message + " data is : "+data);
        }
    }

    @Override
    public void testFunctionality() {
        MemberInnerClassExample obj= new MemberInnerClassExample();
        MemberInnerClassExample.Inner in= obj.new Inner();
        in.message();
    }
}
