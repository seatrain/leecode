import java.util.Arrays;

/**
 * 每日温度，leecode-739，链接：https://leetcode-cn.com/problems/daily-temperatures/
 */
public class DailyTemperatures {

  public int[] dailyTemperatures(int[] T) {
    int[] result = new int[T.length];
    int maxIndex = T.length - 1;
    int max = T[T.length - 1];

    for (int i = T.length - 1; i >= 0; i--) {
      int item = T[i];
      if (item >= max) { // 当前值大于最大值
        result[i] = 0;
        maxIndex = i;
        max = item;
      } else { // 当前值小于最大值
        for (int j = i; j <= maxIndex; j++) {
          if (T[j] > item) {
            result[i] = j - i;
            break;
          }
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    DailyTemperatures dailyTemperatures = new DailyTemperatures();
    int[] T = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
    int[] result = dailyTemperatures.dailyTemperatures(T);
    System.out.println(Arrays.toString(result));
  }
}
