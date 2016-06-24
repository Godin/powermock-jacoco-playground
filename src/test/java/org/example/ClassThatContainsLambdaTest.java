package org.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ClassThatContainsLambda.class})
public class ClassThatContainsLambdaTest {

  @Test
  public void real() {
    Assert.assertEquals("real", new ClassThatContainsLambda().test());
  }

  @Test
  public void spy() {
    PowerMockito.spy(ClassThatContainsLambda.class);

    Assert.assertEquals("real", new ClassThatContainsLambda().test());
  }

  @Test
  public void mockStatic() {
    PowerMockito.mockStatic(ClassThatContainsLambda.class);

    Assert.assertNull(new ClassThatContainsLambda().test());

    Assert.assertEquals("foo", ClassThatContainsLambda.Executor.run(() -> "foo"));
  }

}
