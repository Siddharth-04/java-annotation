package com.bridgelabz.beginnerLevel;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ImportantMethod{
    String level() default "HIGH";
}

public class ImportantMethodAnnotation {
    @ImportantMethod
    public void payment(){

    }

    @ImportantMethod(level = "MEDIUM")
    public void order(){

    }

    @ImportantMethod(level="LOW")
    public void feedback(){

    }

    public static void main(String[] args) {
        Class c = ImportantMethodAnnotation.class;

        Method [] methods = c.getDeclaredMethods();

        for(Method m1 : methods){
            if(m1.isAnnotationPresent(ImportantMethod.class)){
                ImportantMethod im = m1.getAnnotation(ImportantMethod.class);
                System.out.println(m1.getName() + "," + im.level());
            }
        }
    }
}
//feedback,LOW
//payment,HIGH
//order,MEDIUM