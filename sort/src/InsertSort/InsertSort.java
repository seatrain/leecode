package InsertSort;

import java.util.Random;

public class InsertSort {

  /**
   * Rearranges the array in ascending order, using the natural order.
   *
   * @param a the array to be sorted
   */
  public static void sort(Comparable[] a) {
    for (int i = 1; i < a.length; i++) {
      for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
        exch(a, j, j - 1);
      }
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
      System.out.printf("%d\t", a[i]);
    }
    System.out.println();
  }

  public static void main(String[] args) {
    Comparable[] a = new Integer[10];
    for (int i = 0; i < 10; i++) {
      a[i] = new Random().nextInt();
    }

    show(a);
    InsertSort.sort(a);
    assert InsertSort.isSorted(a, 0, a.length);
    show(a);
  }
}
