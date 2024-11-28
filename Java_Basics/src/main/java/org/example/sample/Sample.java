package org.example.sample;

public class Sample {

    void accessPersonClass(){
        //I can't create ClassExample object as my constructor is not public
        // If I add public ClassExample() then below line should work
//        ClassExample p1 = new ClassExample();

        // I can't even access any methods of ClassExample class unless I make is public
        // p1.getAge();
    }


}
