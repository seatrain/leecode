package tree;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.NoSuchElementException;

public class RedBlackBST<Key extends Comparable<Key>, Value> {

  private static final boolean RED = true;
  private static final boolean BLACK = false;

  private Node root;

  private class Node {

    Key key;
    Value val;
    Node left, right;
    int size;
    boolean color;

    Node(Key key, Value val, boolean color, int N) {
      this.key = key;
      this.val = val;
      this.size = N;
      this.color = color;
    }

  }

  private boolean isRed(Node x) {
    if (x == null) {
      return false;
    }

    return x.color == RED;
  }

  private Node rotateLeft(Node h) {
    Node x = h.right;
    h.right = h.left;
    x.left = h;
    x.color = h.color;
    h.color = RED;
    x.size = h.size;
    h.size = 1 + size(h.left) + size(h.right);

    return x;
  }

  private Node rotateRight(Node h) {
    Node x = h.left;
    h.left = x.right;
    x.right = h;
    x.color = h.color;
    h.color = RED;
    x.size = h.size;
    h.size = 1 + size(h.left) + size(h.right);

    return x;
  }

  private void flipColors(Node h) {
    h.color = RED;

    h.left.color = BLACK;
    h.right.color = BLACK;
  }

  private int size(Node n) {
    return n == null ? 0 : n.size;
  }

  public void put(Key key, Value value) {
    root = put(root, key, value);
    root.color = BLACK;
  }

  private Node put(Node h, Key key, Value val) {
    if (h == null) {
      return new Node(key, val, RED, 1);
    }

    int cmp = key.compareTo(h.key);
    if (cmp < 0) {
      h.left = put(h.left, key, val);
    } else if (cmp > 0) {
      h.right = put(h.right, key, val);
    } else {
      h.val = val;
    }

    // fix-up any right-leaning links
    if (isRed(h.right) && !isRed(h.left)) {
      h = rotateLeft(h);
    }
    if (isRed(h.left) && isRed(h.left.left)) {
      h = rotateRight(h);
    }
    if (isRed(h.left) && isRed(h.right)) {
      flipColors(h);
    }
    h.size = size(h.left) + size(h.right) + 1;

    return h;
  }

  public void printAll() {
    print(root);
  }

  private void print(Node node) {
    if (node == null) {
      return;
    }

    print(node.left);
    System.out.println(node.key + ":" + node.val);
    print(node.right);
  }

  public boolean isEmpty() {
    return root == null;
  }

  public Key min() {
    if (isEmpty()) {
      throw new NoSuchElementException("calls min() with empty symbol table");
    }
    return min(root).key;
  }

  // the smallest key in subtree rooted at x; null if no such key
  private Node min(Node x) {
    // assert x != null;
    if (x.left == null) {
      return x;
    } else {
      return min(x.left);
    }
  }

  public Key max() {
    if (isEmpty()) {
      throw new NoSuchElementException("calls max() with empty symbol table");
    }
    return max(root).key;
  }

  // the largest key in the subtree rooted at x; null if no such key
  private Node max(Node x) {
    // assert x != null;
    if (x.right == null) {
      return x;
    } else {
      return max(x.right);
    }
  }

  public Iterable<Key> keys() {
    if (isEmpty()) {
      return new Queue<Key>();
    }
    return keys(min(), max());
  }

  public Iterable<Key> keys(Key lo, Key hi) {
    if (lo == null) {
      throw new IllegalArgumentException("first argument to keys() is null");
    }
    if (hi == null) {
      throw new IllegalArgumentException("second argument to keys() is null");
    }

    Queue<Key> queue = new Queue<Key>();
    // if (isEmpty() || lo.compareTo(hi) > 0) return queue;
    keys(root, queue, lo, hi);
    return queue;
  }

  private void keys(Node x, Queue<Key> queue, Key lo, Key hi) {
    if (x == null) {
      return;
    }
    int cmplo = lo.compareTo(x.key);
    int cmphi = hi.compareTo(x.key);
    if (cmplo < 0) {
      keys(x.left, queue, lo, hi);
    }
    if (cmplo <= 0 && cmphi >= 0) {
      queue.enqueue(x.key);
    }
    if (cmphi > 0) {
      keys(x.right, queue, lo, hi);
    }
  }

  public Value get(Key key) {
    if (key == null) {
      throw new IllegalArgumentException("argument to get() is null");
    }
    return get(root, key);
  }

  // value associated with the given key in subtree rooted at x; null if no such key
  private Value get(Node x, Key key) {
    while (x != null) {
      int cmp = key.compareTo(x.key);
      if (cmp < 0) {
        x = x.left;
      } else if (cmp > 0) {
        x = x.right;
      } else {
        return x.val;
      }
    }
    return null;
  }

  public static void main(String[] args) {
    RedBlackBST<String, Integer> st = new RedBlackBST<String, Integer>();
    for (int i = 0; !StdIn.isEmpty(); i++) {
      String key = StdIn.readString();
      st.put(key, i);
    }
    for (String s : st.keys()) {
      StdOut.println(s + " " + st.get(s));
    }
    StdOut.println();
  }
}
