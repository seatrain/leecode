//给定一个正整数数组 nums。
//
// 找出该数组内乘积小于 k 的连续的子数组的个数。
//
// 示例 1:
//
//
//输入: nums = [10,5,2,6], k = 100
//输出: 8
//解释: 8个乘积小于100的子数组分别为: [10], [5], [2], [6], [10,5], [5,2], [2,6], [5,2,6]。
//需要注意的是 [10,5,2] 并不是乘积小于100的子数组。
//
//
// 说明:
//
//
// 0 < nums.length <= 50000
// 0 < nums[i] < 1000
// 0 <= k < 10^6
//
// Related Topics 数组 双指针
// 👍 168 👎 0

/**
 * 乘积小于K的子数组-713
 *
 * @author seatrain
 * @version 1.0
 * @date 2020/09/14 10:58
 */
public class NumSubarrayProductLessThanK {

  public int numSubarrayProductLessThanK(int[] nums, int k) {
    int result = 0;

    for (int i = 0; i < nums.length; i++) {
      int multiply = nums[i];
      if (multiply < k) {
        result += 1;
      } else {
        continue;
      }

      for (int j = i + 1; j < nums.length; j++) {
        if (nums[j] < k) {
          multiply *= nums[j];
          if (multiply < k) {
            result += 1;
          } else {
            break;
          }
        }
      }
    }

    return result;
  }
}
