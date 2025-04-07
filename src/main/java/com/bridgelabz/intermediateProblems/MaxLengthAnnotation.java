package com.bridgelabz.intermediateProblems;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength{
    int value() default 15;
}

class Username{
    @MaxLength()
    String name;


    public Username(String name) throws IllegalArgumentException {
        this.name = name;

        Class c = Username.class;
        Field [] feilds = c.getDeclaredFields();

        for(Field f : feilds){
            if(f.isAnnotationPresent(MaxLength.class)){
                MaxLength ml = f.getAnnotation(MaxLength.class);

                if(name.length() > ml.value()){
                    throw new IllegalArgumentException("Exceeded length of 15");
                }
            }
        }
    }
}
public class MaxLengthAnnotation {
    public static void main(String[] args){
        try{
            Username user = new Username("Alexander the great !");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
//Exceeded length of 15