package org.example;

import org.junit.Assert;
import org.junit.Test;

public class ClassThatContainsStaticMethod2Test {

  @Test
  public void real() {
    Assert.assertEquals("real", new ClassThatContainsStaticMethod().method());
  }

}
