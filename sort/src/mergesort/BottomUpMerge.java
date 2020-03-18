package mergesort;

import java.util.Random;

/**
 * 使用分治的思想实现归并排序，自底向上地归并
 */
public class BottomUpMerge {

  private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
    for (int i = lo; i <= hi; i++) {
      aux[i] = a[i];
    }

    int leftStart = lo;
    int rightStart = mid + 1;

    for (int i = lo; i <= hi; i++) {
      if (leftStart > mid) {
        a[i] = aux[rightStart++];
      } else if (rightStart > hi) {
        a[i] = aux[leftStart++];
      } else if (less(aux[leftStart], aux[rightStart])) {
        a[i] = aux[leftStart++];
      } else {
        a[i] = aux[rightStart++];
      }
    }
  }


  public static void sort(Comparable[] a) {
    Comparable[] aux = new Comparable[a.length];
    int N = a.length;
    for (int size = 1; size < N; size = size + size) {
      for (int lo = 0; lo < N - size; lo += size + size) {
        merge(a, aux, lo, lo + size - 1, Math.min(lo + size + size - 1, N - 1));
      }
    }
  }

  private static boolean isSorted(Comparable[] a) {
    return isSorted(a, 0, a.length - 1);
  }

  private static boolean isSorted(Comparable[] a, int lo, int hi) {
    for (int i = lo + 1; i <= hi; lo++) {
      if (less(a[i], a[i - 1])) {
        return false;
      }
    }
    return true;
  }

  private static boolean less(Comparable v, Comparable w) {
    return v.compareTo(w) < 0;
  }

  // print array to standard output
  private static void show(Comparable[] a) {
    for (int i = 0; i < a.length; i++) {
      System.out.println(a[i]);
    }
  }

  public static void main(String[] args) {
    Integer[] a = new Integer[10];
    Random random = new Random();
    for (int i = 0; i < a.length; i++) {
      a[i] = random.nextInt();
    }
    BottomUpMerge.sort(a);
    show(a);
  }
}
