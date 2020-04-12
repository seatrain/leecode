package hash;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.SequentialSearchST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * 基于alg4中提供的链表实现的散列表
 */
public class MySeperateChainingHashST<Key, Value> {

  private static final int INIT_CAPACITY = 4;

  /**
   * 键总数
   */
  private int n;

  /**
   * 链表数量
   */
  private int m;

  private SequentialSearchST<Key, Value>[] st;

  public MySeperateChainingHashST() {
    this(INIT_CAPACITY);
  }

  public MySeperateChainingHashST(int m) {
    this.m = m;
    st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[m];
    for (int i = 0; i < m; i++) {
      st[i] = new SequentialSearchST<>();
    }
  }

  private int hash(Key key) {
    return (key.hashCode() & Integer.MAX_VALUE) % m;
  }

  public int size() {
    return n;
  }

  public boolean isEmpty() {
    return size() == 0;
  }

  public void put(Key key, Value value) {
    if (key == null) {
      throw new IllegalArgumentException("key cannot be null!");
    }

    int i = hash(key);
    if (!st[i].contains(key)) {
      n++;
    }
    st[i].put(key, value);
  }

  public Value get(Key key) {
    if (key == null) {
      throw new IllegalArgumentException("key cannot be null");
    }

    int i = hash(key);

    return st[i].get(key);
  }

  public Iterable<Key> keys() {
    Queue<Key> keys = new Queue<>();
    for (int i = 0; i < m; i++) {
      for (Key key : st[i].keys()) {
        keys.enqueue(key);
      }
    }

    return keys;
  }

  public static void main(String[] args) {
    MySeperateChainingHashST<String, Integer> st = new MySeperateChainingHashST<>();
    for (int i = 0; !StdIn.isEmpty(); i++) {
      String key = StdIn.readString();
      st.put(key, i);
    }

    // print keys
    for (String s : st.keys()) {
      StdOut.println(s + " " + st.get(s));
    }
  }
}
