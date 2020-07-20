import java.util.Stack;

/**
 * <p>柱状图中的最大矩形，leecode-84，链接：https://leetcode-cn.com/problems/largest-rectangle-in-histogram/ <p>
 * <p>单调栈解法</>
 */
public class LargestRectangleInHistogram_stack {

  public static int largestRectangleArea(int[] heights) {
    Stack<Integer> stack = new Stack<>();
    int result = 0;
    if (heights.length == 0) {
      return 0;
    }

    if (heights.length == 1) {
      return heights[0];
    }

    int[] newHeights = new int[heights.length + 2];
    System.arraycopy(heights, 0, newHeights, 1, heights.length);
    heights = newHeights;
    for (int i = 0; i < heights.length; i++) {
      while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
        int curHeight = heights[stack.pop()];
        int curWidth = !stack.isEmpty() ? i - stack.peek() - 1 : 1;
        result = Math.max(result, curHeight * curWidth);
      }
      stack.push(i);
    }

    return result;
  }

  public static void main(String[] args) {
    int[] hegihts = new int[]{1, 1};
    System.out.println(LargestRectangleInHistogram_stack.largestRectangleArea(hegihts));
  }
}
