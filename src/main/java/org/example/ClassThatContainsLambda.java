package org.example;

import java.util.concurrent.Callable;

public final class ClassThatContainsLambda {

  public String test() {
    return Executor.run(() -> "real");
  }

  static class Executor {
    static String run(Callable<String> callable) {
      try {
        return callable.call();
      } catch (Exception e) {
        throw new RuntimeException(e);
      }
    }
  }

}
