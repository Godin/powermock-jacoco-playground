package org.jacoco.example;

public class ClassThatContainsStaticMethod {

    public String method() {
        return staticMethod();
    }

    public static String staticMethod() {
        return "hello";
    }

}
