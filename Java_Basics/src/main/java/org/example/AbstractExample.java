package org.example;

public class AbstractExample implements Example{
    abstract class Draw{
        String shapeName;

        Draw(String shapeName){
            this.shapeName = shapeName;
        }

        abstract void drawShape();
    }

    class Square extends Draw{

        Square(String shapeName) {
            super(shapeName);
        }

        @Override
        void drawShape() {
            System.out.println("Drawing "+shapeName);
        }
    }

    @Override
    public void testFunctionality() {
        Draw draw = new Square("square");
        draw.drawShape();
    }
}
