import java.util.stream.IntStream;

/**
 * 算法4：基于堆的优先队列
 */
public class MaxPQ<Key extends Comparable<Key>> {

  private Key[] pq;

  private int capacity = 0;

  private int size = 0;

  /**
   * 创建一个优先队列
   */
  public MaxPQ() {

  }

  /**
   * 创建一个初始容量为max的优先队列
   *
   * @param max 初始容量
   */
  public MaxPQ(int max) {
    capacity = max + 1;
    pq = (Key[]) new Comparable[capacity + 1];
  }

  /**
   * 用a[] 中的元素创建一个优先队列
   *
   * @param a 初始数组
   */
  public MaxPQ(Key[] a) {

  }

  /**
   * 向优先队列中插入一个元素
   *
   * @param v 被插入元素
   */
  public void insert(Key v) {
    pq[++size] = v;
    swim(size);
  }

  private void swim(int k) {
    while (k > 1 && less(k / 2, k)) {
      exch(k / 2, k);
      k = k / 2;
    }
  }

  /**
   * 返回最大元素
   *
   * @return 优先队列中的最大元素
   */
  public Key max() {
    return isEmpty() ? null : pq[1];
  }

  /**
   * 删除并返回最大元素
   *
   * @return 被删除的最大元素
   */
  public Key delMax() {
    Key max = pq[1];
    exch(1, size--);
    pq[size + 1] = null;
    sink(1);
    return max;
  }

  /**
   * 返回队列是否为空
   *
   * @return 队列是否为空
   */
  public boolean isEmpty() {
    return size() == 0;
  }

  /**
   * 返回优先队列中的元素个数
   *
   * @return 优先队列中的元素个数
   */
  public int size() {
    return size;
  }

  /**
   * 比较队列中i和j位置的元素的大小
   */
  private boolean less(int i, int j) {
    return pq[i].compareTo(pq[j]) < 0;
  }

  /**
   * 交换队列中i和j的元素
   */
  private void exch(int i, int j) {
    Key temp = pq[i];
    pq[i] = pq[j];
    pq[j] = temp;
  }

  private void sink(int k) {
    while (2 * k <= size) {
      int j = 2 * k;

      if (j < size && less(j, j + 1)) {
        j++;
      }

      if (!less(k, j)) {
        break;
      }

      exch(k, j);
      k = j;
    }
  }

  public static void main(String[] args) {
    MaxPQ<Integer> nums = new MaxPQ<>(10);
    IntStream.range(0, 10).forEach(
        nums::insert
    );

    System.out.println(nums.max());
    System.out.println(nums.delMax());
    System.out.println(nums.max());
  }
}
