import java.util.Arrays;
import java.util.Stack;

/**
 * 每日温度，leecode-739，链接：https://leetcode-cn.com/problems/daily-temperatures/ 使用递减栈处理
 */
public class DailyTemperatures_stack {

  public int[] dailyTemperatures(int[] T) {
    int[] result = new int[T.length];
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < T.length; i++) {
      while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
        Integer pop = stack.pop();
        result[pop] = i - pop;
      }
      stack.push(i);
    }

    return result;
  }

  public static void main(String[] args) {
    DailyTemperatures_stack dailyTemperatures = new DailyTemperatures_stack();
    int[] T = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
    int[] result = dailyTemperatures.dailyTemperatures(T);
    System.out.println(Arrays.toString(result));
  }
}
