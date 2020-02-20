package QuickSort;

/**
 * leecode-75-颜色分类
 */
public class SortColor {

  private static void sortColors(int[] nums, int lo, int hi) {
    if (hi <= lo) {
      return;
    }

    int lt = lo;
    int gt = hi;
    int i = lo + 1;
    int v = nums[lo];

    while (i <= gt) {
      if (nums[i] < v) {
        swap(nums, i++, lt++);
      } else if (nums[i] > v) {
        swap(nums, i, gt--);
      } else {
        i++;
      }
    }

    sortColors(nums, lo, lt - 1);
    sortColors(nums, gt + 1, hi);
  }

  private static void swap(int[] nums, int i, int j) {
    int swap = nums[i];
    nums[i] = nums[j];
    nums[j] = swap;
  }

  public static void sortColors(int[] nums) {
    sortColors(nums, 0, nums.length - 1);
  }
}
