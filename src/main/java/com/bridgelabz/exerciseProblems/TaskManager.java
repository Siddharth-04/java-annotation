package com.bridgelabz.exerciseProblems;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface TaskInfo {
    String priority();
    String assignedTo();
}

public class TaskManager {
    @TaskInfo(priority = "High",assignedTo = "Madahv")
    public static void payment(){
        System.out.println("Payment Method");
    }

    @TaskInfo(priority = "Low", assignedTo = "Dhruv")
    public static void feedback(){
        System.out.println("Feedback Method");
    }
    public static void main(String[] args) {
        Class c = TaskManager.class;

        Method [] methods = c.getDeclaredMethods();
        for (Method m : methods) {
            TaskInfo taskInfo = m.getAnnotation(TaskInfo.class);
            if(m.isAnnotationPresent(TaskInfo.class)){
                System.out.println(m.getName() + ", " + taskInfo.priority() + ", " + taskInfo.assignedTo());
            }
        }
    }
}
//payment, High, Madahv
//feedback, Low, Dhruv