package QuickSort;

/**
 * leecode-56-合并区间
 */
public class MergedInterval {

  private static void swap(int[][] nums, int i, int j) {
    int[] swap = nums[i];
    nums[i] = nums[j];
    nums[j] = swap;
  }

  private static int partion(int[][] nums, int lo, int hi) {
    int v = nums[lo][0];
    int i = lo;
    int j = hi + 1;

    while (true) {
      while (nums[++i][0] < v) {
        if (i == hi) {
          break;
        }
      }

      while (nums[--j][0] > v) {
        if (j == lo) {
          break;
        }
      }

      if (j <= i) {
        break;
      }

      swap(nums, i, j);
    }

    swap(nums, lo, j);
    return j;
  }

  private static void sort(int[][] nums, int lo, int hi) {
    if (hi <= lo) {
      return;
    }

    int j = partion(nums, lo, hi);
    sort(nums, lo, j - 1);
    sort(nums, j + 1, hi);
  }

  public static int[][] merge(int[][] intervals) {
    if (intervals.length > 0) {
      int[][] merged = new int[intervals.length][intervals[0].length];
      sort(intervals, 0, intervals.length - 1);

      merged[0] = intervals[0];
      int mergedPoint = 0;
      for (int intervalPoint = 1; intervalPoint < intervals.length; intervalPoint++) {
        if (merged[mergedPoint][0] <= intervals[intervalPoint][0] && intervals[intervalPoint][0] <= merged[mergedPoint][1]) { // inRange
          merged[mergedPoint][1] = Math.max(merged[mergedPoint][1], intervals[intervalPoint][1]);
        } else {
          merged[++mergedPoint] = intervals[intervalPoint];
        }
      }

      int[][] result = new int[mergedPoint + 1][mergedPoint + 1];
      for (int i = 0; i <= mergedPoint; i++) {
        result[i] = merged[i];
      }
      return result;
    }
    return new int[0][0];
  }

  public static void main(String[] args) {
    int[][] intervals = new int[][]{
        {2, 6}, {1, 3}, {8, 10}, {15, 18}
    };

    MergedInterval.merge(intervals);
  }
}
