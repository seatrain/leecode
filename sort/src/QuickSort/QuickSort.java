package QuickSort;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {

  public static void sort(int[] nums, int lo, int hi) {
    if (hi <= lo) {
      return;
    }

    int j = partion(nums, lo, hi);
    sort(nums, lo, j - 1);
    sort(nums, j + 1, hi);
  }

  private static int partion(int[] nums, int lo, int hi) {
    int i = lo;
    int j = hi + 1;

    int v = nums[lo];
    while (true) {
      while (nums[++i] < v) {
        if (i == hi) {
          break;
        }
      }

      while (nums[--j] > v) {
        if (j == lo) {
          break;
        }
      }

      if (i >= j) {
        break;
      }

      swap(nums, i, j);
    }

    swap(nums, lo, j);
    return j;
  }

  private static void swap(int[] nums, int i, int j) {
    int swap = nums[i];
    nums[i] = nums[j];
    nums[j] = swap;
  }

  public static void main(String[] args) {
    int[] nums = new int[10];
    Random random = new Random();
    for (int i = 0; i < nums.length; i++) {
      nums[i] = 10 - i;
    }

    QuickSort.sort(nums, 0, nums.length - 1);

    System.out.println(Arrays.toString(nums));
  }
}
