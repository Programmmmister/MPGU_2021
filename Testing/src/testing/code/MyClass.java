package testing.code;

public class MyClass {
    public int add(int value)
    {
        return value + 1;
    }

    public void throwsExceptions()
    {
        throw new ArithmeticException("test exceptions");
    }
}
