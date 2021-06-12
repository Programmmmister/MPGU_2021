  public class DynamicArray<T> {
        private final int SIZE = 10;
        private final int RATE = 2;
        private T[] Arr;

        public DynamicArray() {
            Arr = (T[]) new Object[SIZE];

        }

        public DynamicArray(int firstSize) {
            if (firstSize > -1) {
                Arr = (T[]) new Object[firstSize];
            } else {
                Arr = (T[]) new Object[SIZE];
            }
        }

        public T get(int index) {
            if (capacity() <= index | index < 0) {
                throwException();
            }
            return Arr[index];
        }

        public void set(int index, T value) {
            if (capacity() <= index | index < 0) {
                throwException();
            }
            Arr[index] = value;
        }

        public void resize(int newSize) {
            if (newSize < 0) {
                throwException();
            }
            T[] newArray = Arr.clone();
            Arr = (T[]) new Object[newSize];
            if (Math.min(newSize, newArray.length) >= 0)
                System.arraycopy(newArray, 0, Arr, 0, Math.min(newSize, newArray.length));
        }

        public int capacity() {
            return Arr.length;
        }

        public int size() {
            int number = 0;
            for (int i = 0; i < capacity(); i++) {
                if (Arr[i] != null) {
                    number = i;
                }
            }
            return number + 1;
        }

        public int findFirst(T value) {
            for (int i = 0; i < capacity(); i++) {
                if (Arr[i] == value) {
                    return i;
                }
            }
            return -1;
        }

        public int findLast(T value) {
            for (int i = capacity() - 1; i > -1; i--) {
                if (Arr[i] == value) {
                    return i;
                }
            }
            return -1;
        }
        public void add(T value){
            if (size() >= capacity()) {
              resize(capacity() * RATE + 1);
            }
            set(size(), value);
        }

      public void insert(int index, T value) {
            if (index < 0) {
                throwException();
            }
            int number = -1;
            if (index >= capacity()) {
                resize(Math.max(capacity() * RATE + 1, index + 1));
            }
            if (Arr[index] != null) {
                int oldSize = capacity();
                for (int i = 0; i < capacity(); i++) {
                    if (Arr[i] != null) {
                        number = i;
                    }
                }
                if (number == capacity() - 1) {
                    resize(capacity() * RATE + 1);
                }
                if (oldSize - index >= 0) System.arraycopy(Arr, index, Arr, index + 1, oldSize - index);
            }
            Arr[index] = value;
        }

        public void remove(int index) {
            if (capacity() <= index | index < 0) {
                throwException();
            }
            Arr[index] = null;
            if (capacity() - 1 - index >= 0) System.arraycopy(Arr, index + 1, Arr, index, capacity() - 1 - index);
        }

        public void throwException() {
            throw new ArithmeticException("Negative way");
        }
    }