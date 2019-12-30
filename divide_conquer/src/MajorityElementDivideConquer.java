/**
 * leecode-169-多数元素-分治算法
 */
public class MajorityElementDivideConquer {

  private static int countInRange(int[] nums, int target, int lo, int hi) {
    int count = 0;
    for (int i = lo; i <= hi; i++) {
      if (nums[i] == target) {
        count++;
      }
    }
    return count;
  }

  private static int majorityElement(int[] nums, int lo, int hi) {
    if (hi <= lo) {
      return nums[hi];
    }

    int mid = lo + (hi - lo) / 2;
    int leftItem = majorityElement(nums, lo, mid);
    int rightItem = majorityElement(nums, mid + 1, hi);

    int leftCount = countInRange(nums, leftItem, lo, hi);
    int rightCount = countInRange(nums, rightItem, lo, hi);

    return leftCount > rightCount ? leftItem : rightItem;
  }

  public static int majorityElement(int[] nums) {
    return majorityElement(nums, 0, nums.length - 1);
  }

  public static void main(String[] args) {
    int[] nums = {
        3, 3, 4
    };

    System.out.println(MajorityElementDivideConquer.majorityElement(nums));
  }
}
