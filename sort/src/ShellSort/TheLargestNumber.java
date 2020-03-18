package ShellSort;

/**
 * leecode-179:给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。
 */
public class TheLargestNumber {

  public String largestNumber(int[] nums) {
    sort(nums);

    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < nums.length; i++) {
      stringBuilder.append(nums[i]);
    }

    return stringBuilder.toString();
  }

  private void sort(int[] nums) {
    int N = nums.length;
    int h = 1;
    while (h < N / 3) {
      h = h * 3 + 1;
    }

    while (h >= 1) {
      for (int i = h; i < N; i++) {
        for (int j = i; j >= h && less(nums[j - h], nums[j]); j -= h) {
          exchange(nums, j, j - h);
        }
      }
      h = h / 3;
    }
  }

  private boolean less(int a, int b) {
    String sa = String.valueOf(a);
    String sb = String.valueOf(b);

    int diff = sa.length() - sb.length();
    if (diff == 0) {
      return sa.compareTo(sb) < -1;
    } else if (diff > 0) {
      return Integer.parseInt(sa + sb) < Integer.parseInt(sb + sa);
    } else {
      return Integer.parseInt(sb + sa) < Integer.parseInt(sa + sb);
    }
  }

  private void exchange(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

  public static void main(String[] args) {
    int[] nums = {10, 2};
    TheLargestNumber theLargestNumber = new TheLargestNumber();
    theLargestNumber.sort(nums);
  }
}
