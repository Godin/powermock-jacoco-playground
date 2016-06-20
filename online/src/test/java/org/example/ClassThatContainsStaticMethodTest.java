package org.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ClassThatContainsStaticMethod.class})
public class ClassThatContainsStaticMethodTest {

  @Test
  public void real() {
    Assert.assertEquals("real", new ClassThatContainsStaticMethod().method());
  }

  @Test
  public void spy() throws Exception {
    PowerMockito.spy(ClassThatContainsStaticMethod.class);

    PowerMockito.when(ClassThatContainsStaticMethod.staticMethod()).thenReturn("mocked");

    Assert.assertEquals("mocked", new ClassThatContainsStaticMethod().method());
  }

  @Test
  public void mockStatic() {
    PowerMockito.mockStatic(ClassThatContainsStaticMethod.class);

    PowerMockito.when(ClassThatContainsStaticMethod.staticMethod()).thenReturn("mocked");

    Assert.assertEquals("mocked", new ClassThatContainsStaticMethod().method());
  }

}
