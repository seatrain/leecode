package ShellSort;

import SelectSort.SelectSort;
import java.util.Random;

public class ShellSort {

  /**
   * Rearranges the array in ascending order, using the natural order.
   *
   * @param a the array to be sorted
   */
  public static void sort(Comparable[] a) {
    int N = a.length;
    int h = 1;
    while (h < N / 3) {
      h = h * 3 + 1; // 1, 4, 13, 40, 121
    }
    while (h >= 1) {// 将数组变为h有序
      for (int i = h; i < N; i++) {
        for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
          exch(a, j, j - h);
        }
      }
      h = h / 3;
    }
  }

  // is v < w ?
  private static boolean less(Comparable v, Comparable w) {
    return v.compareTo(w) < 0;
  }

  // exchange a[i] and a[j]
  private static void exch(Object[] a, int i, int j) {
    Object swap = a[i];
    a[i] = a[j];
    a[j] = swap;
  }

  // is the array a[lo..hi) sorted
  private static boolean isSorted(Comparable[] a, int lo, int hi) {
    for (int i = lo + 1; i < hi; i++) {
      if (less(a[i], a[i - 1])) {
        return false;
      }
    }
    return true;
  }

  // print array to standard output
  private static void show(Comparable[] a) {
    for (int i = 0; i < a.length; i++) {
      System.out.print(a[i] + "\t");
    }
    System.out.println();
  }

  public static void main(String[] args) {
    Comparable[] a = new Integer[10];
    for (int i = 0; i < 10; i++) {
      a[i] = new Random().nextInt();
    }

    show(a);
    ShellSort.sort(a);
    assert ShellSort.isSorted(a, 0, a.length);
    show(a);
  }
}
