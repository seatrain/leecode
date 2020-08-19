//给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。如果不存在符合条件的子数组，返回
// 0。
//
//
//
// 示例：
//
// 输入：s = 7, nums = [2,3,1,2,4,3]
//输出：2
//解释：子数组 [4,3] 是该条件下的长度最小的子数组。
//
//
//
//
// 进阶：
//
//
// 如果你已经完成了 O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。
//
// Related Topics 数组 双指针 二分查找
// 👍 410 👎 0

/**
 * 长度最小的子数组
 *
 * @author seatrain
 * @version 1.0
 * @date 2020/08/19 10:38
 */
public class MinSubArrayLen {

  public int minSubArrayLen(int s, int[] nums) {
    int length = nums.length;
    if (length == 0) {
      return 0;
    }

    int minLength = Integer.MAX_VALUE;
    int start = 0;
    int end = 0;
    int sum = 0;

    while (end < length) {
      sum += nums[end];
      while (sum >= s) {
        minLength = Math.min(minLength, end - start + 1);
        sum -= nums[start++];
      }
      end++;
    }

    return minLength == Integer.MAX_VALUE ? 0 : minLength;
  }

  public static void main(String[] args) {
    MinSubArrayLen minSubArrayLen = new MinSubArrayLen();
    int[] nums = new int[]{1, 4, 4};
    int s = 4;

    System.out.println(minSubArrayLen.minSubArrayLen(s, nums));
  }

}
