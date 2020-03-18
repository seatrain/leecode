package QuickSort;

/**
 * 生成能够让快速排序运行数独最快的测试用例数组
 */
public class BaseCase {

  public static void best(int[] a) {
    best(a, 0, a.length - 1);
  }

  private static void best(int[] a, int lo, int hi) {
    if (hi <= lo) {
      return;
    }

    int mid = lo + (hi - lo) / 2;
    best(a, lo, mid - 1);
    best(a, mid + 1, hi);
    exch(a, lo, mid);
  }

  private static void exch(int[] a, int i, int j) {
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }
}
