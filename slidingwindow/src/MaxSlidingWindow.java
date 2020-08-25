//给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
//
// 示例:
//
// 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
//输出: [3,3,5,5,6,7]
//解释:
//
//  滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
//
//
//
// 提示：
//
// 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。
//
// 注意：本题与主站 239 题相同：https://leetcode-cn.com/problems/sliding-window-maximum/
// Related Topics 队列 Sliding Window
// 👍 88 👎 0

/**
 * 剑指offer 59：移动窗口的最大值
 *
 * @author seatrain
 * @version 1.0
 * @date 2020/08/20 9:42
 */
public class MaxSlidingWindow {

  public int[] maxSlidingWindow(int[] nums, int k) {
    int length = nums.length;
    if (length == 0) {
      return new int[0];
    }
    int[] maxNums = new int[length - k + 1];

    for (int i = 0; i < length - k + 1; i++) {
      if (i == 0) {
        maxNums[0] = getMax(nums, 0, k);
      } else {
        if (nums[i - 1] == maxNums[i - 1]) {
          maxNums[i] = getMax(nums, i, i + k);
        } else {
          if (nums[i + k - 1] > maxNums[i - 1]) {
            maxNums[i] = nums[i + k - 1];
          } else {
            maxNums[i] = maxNums[i - 1];
          }
        }
      }
    }

    return maxNums;
  }

  /**
   * 获取数组nums从start下标到end下标之间的最大值
   *
   * @param nums 进行处理的数组
   * @param start 起始下标 包含
   * @param end 结束下标 不包含
   * @return int
   * @author seatrain
   * @date 2020/08/20 9:56
   */
  private int getMax(int[] nums, int start, int end) {
    int max = nums[start];
    for (int i = start + 1; i < end; i++) {
      if (nums[i] > max) {
        max = nums[i];
      }
    }

    return max;
  }
}
