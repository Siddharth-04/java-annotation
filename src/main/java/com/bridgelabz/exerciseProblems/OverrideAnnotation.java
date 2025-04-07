package com.bridgelabz.exerciseProblems;

class Animal{
    public void makeSound(){
        System.out.println("Animal's Sound");
    }
}

class Dog extends Animal{
    @Override
    public void makeSound(){
        System.out.println("Bark");
    }
}

public class OverrideAnnotation {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.makeSound();
    }
}
//Bark