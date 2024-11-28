package org.example;

public class Main {

    public static Example createExample(Example_Enum exampleEnum) {
        switch (exampleEnum) {
            case AbstractExample -> {
                return new AbstractExample();
            }
            case AnonymousInnerClass -> {
                return new AnonymousInnerClassExample();
            }
            case ClassExample -> {
                return new ClassExample();
            }
            case InterfaceExample -> {
                return new InterfaceExample();
            }
            case MemberInnerClassExample -> {
                return new MemberInnerClassExample();
            }
            case SyntaxAndDataType -> {
                return new SyntaxAndDataType();
            }
            default -> throw new IllegalStateException("Unexpected value: " + exampleEnum);
        }
    }

    public static void main(String[] args) throws Exception {

        //Change this enum to run respective functionality
        Example_Enum exampleEnum = Example_Enum.SyntaxAndDataType;
        Example example = createExample(exampleEnum);
        example.testFunctionality();
    }
}