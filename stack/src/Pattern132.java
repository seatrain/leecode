import java.util.Stack;

/**
 * <p> 132模式，leecode-456，链接：https://leetcode-cn.com/problems/132-pattern/ <p>
 * <p>单调栈解法</>
 */
public class Pattern132 {

  public static boolean find132pattern(int[] nums) {

    if (nums.length < 3) {
      return false;
    }

    boolean flag = false;
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < nums.length; i++) {
      int num = nums[i];
//        while (!stack.isEmpty() && ) {
//
//      }

      stack.push(num);
    }

    return false;
  }

  public static void main(String[] args) {
    int[] nums = new int[]{1, 0, 1, -4, -3};
    System.out.println(find132pattern(nums));
  }
}
