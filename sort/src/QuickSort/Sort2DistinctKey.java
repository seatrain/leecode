package QuickSort;

import java.util.Arrays;
import java.util.Random;

/**
 * 对已知只具有两种主键值的数组进行排序
 */
public class Sort2DistinctKey {

  /**
   * Rearranges the array in ascending order, using the natural order.
   *
   * @param a the array to be sorted
   */
  public static void sort(Comparable[] a) {
    int lo = 0, hi = a.length - 1;
    int lt = 0, i = lo + 1;
    Comparable v = a[lo];

    while (i <= hi) {
      int cmp = a[i].compareTo(v);
      if (cmp < 0) {
        exch(a, lo++, i++);
      } else {
        i++;
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
      System.out.println(a[i]);
    }
  }

  public static void main(String[] args) {
    Comparable[] nums = new Comparable[10];
    Random random = new Random();
    for (int i = 0; i < nums.length; i++) {
      nums[i] = 10 - i > 5 ? 1 : 0;
    }

    System.out.println(Arrays.toString(nums));

    Sort2DistinctKey.sort(nums);

    System.out.println(Arrays.toString(nums));
  }
}
