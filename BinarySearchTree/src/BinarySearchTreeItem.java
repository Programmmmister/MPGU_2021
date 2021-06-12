public class BSTitem {
    String key;
    BSTitem p;
    BSTitem left;
    BSTitem right;
    BSTitem(String key) {
        this.key = key;
        right = null;
        left = null;
        p = null;
    }
    public void setRightChild(BSTitem n)
    {
        right = n;
    }

    public void setLeftChild(BSTitem n){
        left = n;
    }
}
