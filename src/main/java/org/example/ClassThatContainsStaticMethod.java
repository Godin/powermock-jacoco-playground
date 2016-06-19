package org.example;

public final class ClassThatContainsStaticMethod {

  public String method() {
    return staticMethod();
  }

  public static String staticMethod() {
    return "real";
  }

}
