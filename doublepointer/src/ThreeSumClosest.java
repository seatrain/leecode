//给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和
//。假定每组输入只存在唯一答案。
//
//
//
// 示例：
//
// 输入：nums = [-1,2,1,-4], target = 1
//输出：2
//解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
//
//
//
//
// 提示：
//
//
// 3 <= nums.length <= 10^3
// -10^3 <= nums[i] <= 10^3
// -10^4 <= target <= 10^4
//
// Related Topics 数组 双指针
// 👍 565 👎 0

import java.util.Arrays;

/**
 * 最接近的三数之和
 *
 * @author seatrain
 * @version 1.0
 * @date 2020/09/11 11:36
 */
public class ThreeSumClosest {

  public static int threeSumClosest(int[] nums, int target) {
    int length = nums.length;
    if (length == 0) {
      return 0;
    }

    int minSub = Integer.MAX_VALUE;
    int result = 0;

    Arrays.sort(nums);
    for (int a = 0; a < length; a++) {
      int b = a + 1;
      int c = length - 1;

      if (a > 0 && nums[a] == nums[a - 1]) {
        continue;
      }

      while (b < c) {
        int tempResult = nums[a] + nums[b] + nums[c];

        if (tempResult == target) {
          return tempResult;
        }

        int tempSubAbs = Math.abs(tempResult - target);
        if (tempSubAbs < minSub) {
          minSub = tempSubAbs;
          result = tempResult;
        }

        if (tempResult > target) {
          c -= 1;
        } else {
          b += 1;
        }
      }
    }

    return result;
  }

  public static void main(String[] args) {
    int[] nums = new int[]{-1, 2, 1, -4};
    int target = 1;
    System.out.println(threeSumClosest(nums, target));
  }
}
