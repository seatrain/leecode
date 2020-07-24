import java.util.Arrays;

/**
 * <p> 最短无序连续子数组，leecode-581，链接：https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray/
 */
public class ShortestUnsortedContinuousSubarray {

  public static int findUnsortedSubarray(int[] nums) {
    int[] sortedNum = nums.clone();
    Arrays.sort(sortedNum);

    int start = nums.length - 1;
    int end = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != sortedNum[i]) {
        start = Math.min(start, i);
        end = Math.max(end, i);
      }
    }
    return end - start > 0 ? end - start + 1 : 0;
  }

  public static void main(String[] args) {
    int[] nums = new int[]{2, 6, 4, 8, 10, 9, 15};
    System.out.println(findUnsortedSubarray(nums));
  }
}
