import java.util.Arrays;

/**
 * 柱状图中的最大矩形，leecode-84，链接：https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
 */
public class LargestRectangleInHistogram {

  public static int largestRectangleArea(int[] heights) {
    int result = 0;
    for (int sortedHeight : heights) {
      int max = 0;
      for (int height : heights) {
        if (height >= sortedHeight) {
          max += sortedHeight;
        } else {
          result = Math.max(max, result);
          max = 0;
        }
      }
      result = Math.max(max, result);
    }

    return result;
  }

  public static void main(String[] args) {
    int[] hegihts = new int[]{2,1,5,6,2,3};
    System.out.println(LargestRectangleInHistogram.largestRectangleArea(hegihts));
  }
}
