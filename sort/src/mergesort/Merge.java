package mergesort;

import java.util.Random;

public class Merge {

  private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
    assert isSorted(a, lo, mid);
    assert isSorted(a, mid + 1, hi);

    // copy to aux[]
    for (int i = 0; i <= hi; i++) {
      aux[i] = a[i];
    }

    // merge back to a[]
    int i = lo, j = mid + 1;
    for (int k = lo; k <= hi; k++) {
      if (i > mid) {
        a[k] = aux[j++];
      } else if (j > hi) {
        a[k] = aux[i++];
      } else if (less(aux[j], aux[i])) {
        a[k] = a[j++];
      } else {
        a[k] = a[i++];
      }
    }
    assert isSorted(a, lo, hi);
  }

  private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
    if (hi <= lo) {
      return;
    }

    int mid = lo + (hi - lo) / 2;
    sort(a, aux, lo, mid);
    sort(a, aux, mid + 1, hi);
    merge(a, aux, lo, mid, hi);
  }

  public static void sort(Comparable[] a) {
    Comparable[] aux = new Comparable[a.length];
    sort(a, aux, 0, a.length - 1);
    assert isSorted(a);
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
    Merge.sort(a);
    show(a);
  }
}
