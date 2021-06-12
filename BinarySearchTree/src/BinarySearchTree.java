public class binaryTree {
    public BSTitem root;

    public binaryTree() {
        root = null;
    }

    public String search(String key) {
        return SearchRec(key, root);
    }

    private static String SearchRec(String key, BSTitem root) {
        if (root == null)
            return null;
        if (root.key.equals(key))
            return root.key;
        if (root.key.compareTo(key) < 0)
            return SearchRec(key, root.right);
        return SearchRec(key, root.left);
    }

    public String Min(BSTitem root) {
        String minimum = root.key;
        while (root.left != null) {
            minimum = root.left.key;
            root = root.left;
        }
        return minimum;
    }

    public static BSTitem MinRoot(BSTitem root) {
        if (root == null)
            return null;
        else if (root.left != null)
            return MinRoot(root.left);
        return root;
    }

    public String Max(BSTitem root) {
        String maximum = root.key;
        while (root.right != null) {
            maximum = root.right.key;
            root = root.right;
        }
        return maximum;
    }
    public static BSTitem MaxRoot(BSTitem root) {
        if (root == null)
            return null;
        else if (root.right != null)
            return MaxRoot(root.right);
        return root;
    }

    public void insert(String key) {
        root = insertRec(root, key);
    }


    public BSTitem insertRec(BSTitem root, String key) {
        if (root == null) {
            root = new BSTitem(key);
            return root;
        }


        if (root.key.compareTo(key) > 0)
            root.left = insertRec(root.left, key);
        else if (root.key.compareTo(key) < 0)
            root.right = insertRec(root.right, key);
        return root;
    }

    public void de2lete (String key) {
        root = delete (root,key);
    }

    public static BSTitem delete(BSTitem root, String x) {

        if (root == null)
            return null;
        if (root.key.compareTo(x) < 0)
            root.setRightChild(delete(root.right, x));
        else if (root.key.compareTo(x) > 0)
            root.setLeftChild(delete(root.left, x));
        else {

            if (root.left == null && root.right == null) {
                root = null;
                return null;
            } else if (root.left == null || root.right == null) {
                BSTitem temp;
                if (root.left == null)
                    temp = root.right;
                else
                    temp = root.left;
                root = null;
                return temp;
            } else {
                BSTitem temp = MinRoot(root.right);
                root.key = temp.key;
                root.setRightChild(delete(root.right, temp.key));
            }
        }
        return root;
    }
    public BSTitem getSucc(BSTitem root, String key) {
        return successorRec(root, key);
    }

    public BSTitem successorRec(BSTitem root, String key) {
        BSTitem current = SearchRecRoot(key, root);
        if (current == null) {
            return current;
        }

        if (current.right != null) {
            return MinRoot(current.right);
        } else {
            BSTitem tmp = root.left;
            while (tmp.right != null)
                tmp = tmp.right;

            current = tmp;
        }
        return current;
    }

    private static BSTitem SearchRecRoot(String key, BSTitem root) {
        if (root == null)
            return null;
        if (root.key.equals(key))
            return root;
        if (root.key.compareTo(key) < 0)
            return SearchRecRoot(key, root.right);
        return SearchRecRoot(key, root.left);
    }
    public BSTitem getPredShell(BSTitem root, String key) {
        return predecessorRec(root, key);
    }
    public BSTitem predecessorRec(BSTitem root, String key) {
        BSTitem pre = null;
        while (root != null) {
            if (root.key.equals(key)) {
                if (root.left != null) {
                    pre = root.left;
                    while (pre.right != null)
                        pre = pre.right;
                }
                return pre;
            } else if (key.compareTo(root.key) > 0) {
                pre = root;
                root = root.right;
            }
        }
        return pre;
    }
}
