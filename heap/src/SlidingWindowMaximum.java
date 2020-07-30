import java.util.Arrays;

/**
 * <p>滑动窗口最大值，leecode-347，链接：https://leetcode-cn.com/problems/sliding-window-maximum/</p>
 * <p>暴力解法</p>
 */
public class SlidingWindowMaximum {

  public static int[] maxSlidingWindow(int[] nums, int k) {
    int[] result = new int[nums.length - k + 1];
    for (int i = 0; i < result.length; i++) {
      int max = nums[i];
      for (int j = i; j < i + k; j++) {
        if (max < nums[j]) {
          max = nums[j];
        }
      }
      result[i] = max;
    }

    return result;
  }

  public static void main(String[] args) {
    int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
    int k = 3;
    System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));
  }
}
