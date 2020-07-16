/**
 * 接雨水，leecode-42，链接：https://leetcode-cn.com/problems/trapping-rain-water/
 */
public class TrappingRainWater {

  public int trap(int[] height) {
    int result = 0;
    for (int i = 1; i < height.length - 1; i++) {
      int maxLeft = 0;
      int maxRight = 0;
      for (int j = i - 1; j >= 0; j--) {
        if (height[j] > maxLeft) {
          maxLeft = height[j];
        }
      }

      for (int j = i + 1; j < height.length; j++) {
        if (height[j] > maxRight) {
          maxRight = height[j];
        }
      }

      int min = Math.min(maxLeft, maxRight);
      if (min > height[i]) {
        result += min - height[i];
      }
    }
    return result;
  }

  public static void main(String[] args) {
    int[] height = new int[]{2, 0, 2};
    TrappingRainWater trappingRainWater = new TrappingRainWater();
    System.out.println(trappingRainWater.trap(height));
  }
}
