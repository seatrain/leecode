import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 盛最多水的容器，leecode-11，链接：https://leetcode-cn.com/problems/container-with-most-water/
 */
public class ContainerWithMostWater {

  int max = 0;

  int maxIndex = 0;

  public int maxArea(int[] height) {
    max = Math.min(height[0], height[1]);

    for (int i = 1; i < height.length; i++) {
      if (height[maxIndex] < height[i]) {
        maxIndex = i;
      }
      calculate(i, height);
    }
    return max;
  }

  private void calculate(int index, int[] heights) {

    for (int j = 0; j <= maxIndex; j++) {
      int area = (index - j) * Math.min(heights[j], heights[index]);
      max = Math.max(area, max);
    }
  }

  public static void main(String[] args) {
    ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
    int[] heights = new int[]{1,8,6,2,5,4,8,3,7};
    System.out.println(containerWithMostWater.maxArea(heights));
  }
}
