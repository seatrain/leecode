//给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
//
//
//
// 示例 1：
//
// 输入：[-4,-1,0,3,10]
//输出：[0,1,9,16,100]
//
//
// 示例 2：
//
// 输入：[-7,-3,2,3,11]
//输出：[4,9,9,49,121]
//
//
//
//
// 提示：
//
//
// 1 <= A.length <= 10000
// -10000 <= A[i] <= 10000
// A 已按非递减顺序排序。
//
// Related Topics 数组 双指针
// 👍 116 👎 0

import java.util.Arrays;

/**
 * 有序数组的平方
 *
 * @author seatrain
 * @version 1.0
 * @date 2020/08/27 10:38
 */
public class SortedSquares {

  public int[] sortedSquares(int[] nums) {
    int length = nums.length;
    int[] result = new int[length];
    int splitIndex = 0; // nums[0] - nums[splitIndex] less than 0, split index not include

    for (int num : nums) {
      if (num < 0) {
        splitIndex += 1;
      }
    }

    int negativePointer = splitIndex - 1;
    int positivePointer = splitIndex;
    int index = 0;

    while (negativePointer >= 0 && positivePointer < length) {
      int item;
      if (Math.abs(nums[negativePointer]) > nums[positivePointer]) {
        item = nums[positivePointer++];
      } else {
        item = nums[negativePointer--];
      }
      result[index++] = item * item;
    }

    while (negativePointer >= 0) {
      int item = nums[negativePointer--];
      result[index++] = item * item;
    }

    while (positivePointer < length) {
      int item = nums[positivePointer++];
      result[index++] = item * item;
    }

    return result;
  }

  public static void main(String[] args) {
    int[] nums = new int[]{-4,-1,0,3,10};
    SortedSquares sortedSquares = new SortedSquares();

    System.out.println(Arrays.toString(sortedSquares.sortedSquares(nums)));
  }
}
