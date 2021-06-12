package dll;


public class dllElement<T> {
    T data;
    dllElement<T> prev;
    dllElement<T> next;

    dllElement(T value){
        data = value;
    }
}
