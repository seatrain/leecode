//给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
//
//
//
// 示例 1:
//
// 输入: [3,0,1]
//输出: 2
//
//
// 示例 2:
//
// 输入: [9,6,4,2,3,5,7,0,1]
//输出: 8
//
//
//
//
// 说明:
//你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现?
// Related Topics 位运算 数组 数学
// 👍 314 👎 0

/**
 * 缺失数字-268
 *
 * @author seatrain
 * @version 1.0
 * @date 2020/09/30 9:39
 */
public class MissingNumber {

  public static int missingNumber(int[] nums) {
    int result = nums.length;

    for (int i = 0; i < nums.length; i++) {
      while (nums[i] != i) {
        if (nums[i] == -1) {
          result = i;
          break;
        }
        swap(nums, i, nums[i]);
      }
    }

    return result;
  }

  private static void swap(int[] nums, int fromIndex, int toIndex) {
    if (toIndex == nums.length) {
      nums[fromIndex] = -1;
    } else {
      int temp = nums[fromIndex];
      nums[fromIndex] = nums[toIndex];
      nums[toIndex] = temp;
    }
  }

  public static void main(String[] args) {
    int[] nums = new int[]{3, 0, 1};
    System.out.println(missingNumber(nums));
  }
}
