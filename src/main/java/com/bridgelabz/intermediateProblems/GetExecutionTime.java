package com.bridgelabz.intermediateProblems;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogExecutionTime{

}

public class GetExecutionTime {
    @LogExecutionTime()
    public static void printHelloThousandTimes(){
        for(int i=0 ; i<1000 ; i++){
        }
    }

    public static void sayHi(){
        System.out.println("Hi !");
    }

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Class c = GetExecutionTime.class;
        Method [] methods = c.getDeclaredMethods();
        GetExecutionTime getExecutionTime = new GetExecutionTime();

        for(Method m : methods){
            if(m.isAnnotationPresent(LogExecutionTime.class)){
                long startTime = System.nanoTime();
                m.invoke(getExecutionTime);
                long endTime = System.nanoTime();
                System.out.println(m.getName() + "," +"Execution time:" + (endTime - startTime));
            }
        }
    }
}
//printHelloThousandTimes,Execution time:42600