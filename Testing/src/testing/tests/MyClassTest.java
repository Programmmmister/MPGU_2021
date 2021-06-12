package testing.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import testing.code.MyClass;

public class MyClassTest extends Assertions {
    @Test
    public void firstTestP()
    {
        MyClass myClass = new MyClass();

        int result = myClass.add(10);

        assertEquals(11, result);
    }

    @Test
    public void secondTest()
        {
            MyClass myClass = new MyClass();

           Throwable res = assertThrows(ArithmeticException.class, () -> myClass.throwsExceptions());
           assertEquals("test exceptions", res.getMessage());

        }
}
