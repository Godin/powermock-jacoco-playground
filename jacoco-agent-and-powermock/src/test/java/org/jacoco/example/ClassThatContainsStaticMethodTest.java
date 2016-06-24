package org.jacoco.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
public class ClassThatContainsStaticMethodTest {

    /**
     * TODO
     */
    @PrepareForTest({ClassThatContainsStaticMethod.class})
    @Test
    public void test() {
        Assert.assertEquals(
                "hello",
                new ClassThatContainsStaticMethod().method()
        );
    }

}
