package rbt;

public class RBT {

    private static final COLOR RED = COLOR.RED;
    private static final COLOR BLACK = COLOR.BLACK;
    public Node root;

    private class Node<Key,Value> {
        Key key;
        Value value;
        Node left, right;
        COLOR color; // color of parent link

        public Node (Key key, Value value, COLOR color) {
            this.key = key;
            this.value = value;
            this.color = color;
        }
    }

    private boolean isRed(Node x) {
        if (x == null) return false;
        return x.color == RED;
    }

    private Node rotateLeft(Node h) {
        assert isRed(h.right);
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        changeRoot(h,x);
        return x;
    }

    private Node rotateRight(Node h) {
        assert isRed(h.left);
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        changeRoot(h,x);
        return x;
    }

    private void changeRoot(Node h, Node x) {
        if (h == root) {
            root = x;
            root.color = BLACK;
        }
    }

    private void flipColors(Node h) {
        assert !isRed(h);
        assert isRed(h.left);
        assert isRed(h.right);
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    public <Key,Value> Value get(Key key) {
        Node x = root;
        while (x != null) {
            int cmp = ((Comparable)key).compareTo(x.key);
            if (cmp < 0) x = x.left;
            else if (cmp > 0) x = x.right;
            else if (cmp == 0) return (Value) x.value;
        }
        return null;
    }

    public  <Key,Value> Node put(Key key, Value val) {
        Node node = put(root, key, val);
        if (root == null) root = node;
        return node;
    }

     private  <Key,Value> Node put(Node h, Key key, Value val) {
        if (h == null) return new Node(key, val, RED);
        int cmp = ((Comparable)key).compareTo(h.key);
        if (cmp < 0) h.left = put(h.left, key, val);
        else if (cmp > 0) h.right = put(h.right, key, val);
        else if (cmp == 0) h.value = val;
        if (isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);
        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        if (isRed(h.left) && isRed(h.right)) flipColors(h);
        return h;
    }
}
