package com.bridgelabz.exerciseProblems;

class LegacyAPI{
    @Deprecated
    public void oldFeature(){
        System.out.println("Old Feature");
    }

    public void newFeature(){
        System.out.println("New Feature");
    }
}
public class DeprecatedAnnotation {
    public static void main(String[] args) {
        LegacyAPI obj = new LegacyAPI();
        obj.oldFeature();
        obj.newFeature();
    }
}
