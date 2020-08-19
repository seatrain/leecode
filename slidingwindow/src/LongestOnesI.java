//给定一个二进制数组， 计算其中最大连续1的个数。
//
// 示例 1:
//
//
//输入: [1,1,0,1,1,1]
//输出: 3
//解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
//
//
// 注意：
//
//
// 输入的数组只包含 0 和1。
// 输入数组的长度是正整数，且不超过 10,000。
//
// Related Topics 数组
// 👍 115 👎 0

/**
 * 最大连续1的个数
 *
 * @author seatrain
 * @version 1.0
 * @date 2020/08/19 13:52
 */
public class LongestOnesI {

  public int findMaxConsecutiveOnes(int[] nums) {
    int length = nums.length;
    if (length == 0) {
      return 0;
    }

    int start = 0;
    int end = 0;
    int maxLength = 0;
    boolean countFlag = false;

    while (end < length) {
      int item = nums[end];

      if (item == 1) {
        if (!countFlag) {
          start = end;
          countFlag = true;
        }
        maxLength = Math.max(maxLength, end - start + 1);
      } else {
        if (countFlag) {
          countFlag = false;
        }
      }
      end++;
    }

    return maxLength;
  }
}
