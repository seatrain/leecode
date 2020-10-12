//给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出
//这个重复的数。
//
// 示例 1:
//
// 输入: [1,3,4,2,2]
//输出: 2
//
//
// 示例 2:
//
// 输入: [3,1,3,4,2]
//输出: 3
//
//
// 说明：
//
//
// 不能更改原数组（假设数组是只读的）。
// 只能使用额外的 O(1) 的空间。
// 时间复杂度小于 O(n2) 。
// 数组中只有一个重复的数字，但它可能不止重复出现一次。
//
// 👍 893 👎 0

/**
 * 寻找重复数-287
 *
 * @author seatrain
 * @version 1.0
 * @date 2020/10/09 11:42
 */
public class FindDuplicate {

  public static int findDuplicate(int[] nums) {
    int start = 1;
    int end = nums.length - 1;

    while (start < end) {
      int count = 0;
      int mid = (start + end) / 2;
      for (int i = 0; i < nums.length; i++) {
        if (nums[i] <= mid) {
          count++;
        }
      }

      if (count > mid) {
        end = mid;
      } else {
        start = mid + 1;
      }

    }

    return start;
  }

  public static void main(String[] args) {
    int[] nums = new int[]{1, 3, 4, 2, 1};
    System.out.println(findDuplicate(nums));
  }
}
