package org.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;
import org.powermock.reflect.exceptions.MethodNotFoundException;

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

  /**
   * https://github.com/jayway/powermock/issues/645
   */
  @Test
  public void mockStatic_npe() throws Exception {
    if (!isInstrumentedByJaCoCo(ClassThatContainsStaticMethod.class)) {
      return;
    }

    PowerMockito.mockStatic(ClassThatContainsStaticMethod.class);

    try {
      new ClassThatContainsStaticMethod();
      Assert.fail("NullPointerException expected");
    } catch (NullPointerException e) {
      // expected
    }
  }

  /**
   * Returns <code>true</code> if given class instrumented by JaCoCo.
   *
   * TODO(Godin): why {@link Class#getDeclaredMethod(String, Class[])} doesn't work?
   * TODO(Godin): add note that this is not part of JaCoCo API
   */
  private static boolean isInstrumentedByJaCoCo(Class<?> cls) {
    try {
      Whitebox.getMethod(cls, "$jacocoInit");
      return true;
    } catch (MethodNotFoundException e) {
      return false;
    }
  }

  @Test
  public void mockStatic() {
    PowerMockito.mockStatic(ClassThatContainsStaticMethod.class);

    if (isInstrumentedByJaCoCo(ClassThatContainsStaticMethod.class)) {
      try {
        PowerMockito.doCallRealMethod().when(ClassThatContainsStaticMethod.class, "$jacocoInit");
      } catch (Exception e) {
        throw new RuntimeException(e);
      }
    }

    PowerMockito.when(ClassThatContainsStaticMethod.staticMethod()).thenReturn("mocked");

    Assert.assertEquals("mocked", new ClassThatContainsStaticMethod().method());
  }

}
