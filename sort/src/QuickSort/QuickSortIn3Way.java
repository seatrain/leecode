package QuickSort;

import java.util.Arrays;
import java.util.Random;

/**
 * 三段式切分快速排序
 */
public class QuickSortIn3Way {

  /**
   * Rearranges the array in ascending order, using the natural order.
   *
   * @param a the array to be sorted
   */
  public static void sort(Comparable[] a) {
    sort(a, 0, a.length - 1);
  }

  private static void sort(Comparable[] a, int lo, int hi) {
    if (hi <= lo) {
      return;
    }

    int lt = lo;
    int i = lo + 1;
    int gt = hi;
    Comparable v = a[lo];

    while (i <= gt) {
      int cmp = a[i].compareTo(v);
      if (cmp < 0) {
        exch(a, lt++, i++);
      } else if (cmp == 0) {
        i++;
      } else {
        exch(a, i, gt--);
      }
    }

    sort(a, lo, lt - 1);
    sort(a, gt + 1, hi);
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
      nums[i] = 10 - i;
    }

    QuickSortIn3Way.sort(nums, 0, nums.length - 1);

    System.out.println(Arrays.toString(nums));
  }
}
