package org.jacoco.example;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.rule.PowerMockRule;

@PrepareForTest({ClassThatContainsStaticMethod.class})
public class ClassThatContainsStaticMethodTest {

    @Rule
    public PowerMockRule rule = new PowerMockRule();

    @Test
    public void test() {
        Assert.assertEquals(
                "hello",
                new ClassThatContainsStaticMethod().method()
        );
    }

    @Test
    public void test_mockStatic() {
        PowerMockito.spy(ClassThatContainsStaticMethod.class);

        PowerMockito.when(ClassThatContainsStaticMethod.staticMethod()).thenReturn("mocked");

        // NPE
        new ClassThatContainsStaticMethod();
    }

}
