package mergesort;

/**
 * leecode-88-合并两个有序数组
 */
public class MergeTwoSortedArray {

  public void merge(int[] nums1, int m, int[] nums2, int n) {

    // tp:target array point -> nums1
    // sp:source array point -> nums2
    for (int sp = 0, tp = 0; tp < nums1.length && sp < nums2.length; tp++) {
      if (tp > sp + m - 1) {
        nums1[tp] = nums2[sp++];
      } else if (nums1[tp] > nums2[sp]) {
        moveItems(nums1, tp, nums1.length - 1);
        nums1[tp] = nums2[sp++];
      }

    }
  }

  private void moveItems(int[] a, int begin, int end) {
    if (end - begin >= 0) {
      System.arraycopy(a, begin, a, begin + 1, end - begin);
    }
  }

  public static void main(String[] args) {
    int[] num1 = new int[]{4, 5, 6, 0, 0, 0};
    int[] num2 = new int[]{1, 2, 3};
    MergeTwoSortedArray mergeTwoSortedArray = new MergeTwoSortedArray();
    mergeTwoSortedArray.merge(num1, 3, num2, 3);
    for (int i = 0; i < num1.length; i++) {
      System.out.println(num1[i]);
    }
  }
}
