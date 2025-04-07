package com.bridgelabz.beginnerLevel;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Todo{
    String task();
    String assignedTo();
    String priority() default "MEDIUM";
}

public class ToDoAnnotation {
    @Todo(task="Go to exercise",assignedTo = "Madhav")
    public static void exercise(){
        System.out.println("Go to exercise");
    }

    @Todo(task="Go to office",assignedTo = "Dhruv",priority = "HIGH")
    public void goToOffice(){
        System.out.println("Going to office");
    }

    @Todo(task="Go Play !",assignedTo = "Madhav",priority = "HIGH")
    public void play(){
        System.out.println("Playing");
    }

    public static void main(String[] args) {
        Class c = ToDoAnnotation.class;
        Method [] methods = c.getDeclaredMethods();

        for(Method m : methods){
            if(m.isAnnotationPresent(Todo.class)){
                Todo todo = m.getAnnotation(Todo.class);
                System.out.println(m.getName() + "," + todo.assignedTo() + "," + todo.task() + "," + todo.priority());
            }
        }
    }
}
//play,Madhav,Go Play !,HIGH
//goToOffice,Dhruv,Go to office,HIGH
//exercise,Madhav,Go to exercise,MEDIUM