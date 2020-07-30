import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * <p>滑动窗口最大值，leecode-347，链接：https://leetcode-cn.com/problems/sliding-window-maximum/</p>
 * <p>双端队列解法</p>
 */
public class SlidingWindowMaximum_Deque {

  private Deque<Integer> deque = new ArrayDeque<>();

  private int[] nums;

  public int[] maxSlidingWindow(int[] nums, int k) {
    if (nums == null || nums.length * k == 0) {
      return new int[0];
    }

    if (k == 1) {
      return nums;
    }

    this.nums = nums;
    int maxIdx = 0;

    for (int i = 0; i < k; i++) {
      cleanDeque(i, k);
      deque.addLast(i);

      if (nums[i] > nums[maxIdx]) {
        maxIdx = i;
      }
    }

    int[] result = new int[nums.length - k + 1];
    result[0] = nums[maxIdx];

    for (int i = k; i < nums.length; i++) {
      cleanDeque(i, k);
      deque.add(i);
      result[i - k + 1] = nums[deque.getFirst()];
    }

    return result;
  }

  private void cleanDeque(int i, int k) {
    if (!deque.isEmpty() && deque.getFirst() == i - k) {
      deque.removeFirst();
    }

    while (!deque.isEmpty() && nums[i] > nums[deque.getLast()]) {
      deque.removeLast();
    }
  }

  public static void main(String[] args) {
    int[] nums = new int[]{1,3,1,2,0,5};
    int k = 3;
    SlidingWindowMaximum_Deque slidingWindowMaximum_deque = new SlidingWindowMaximum_Deque();
    System.out.println(Arrays.toString(slidingWindowMaximum_deque.maxSlidingWindow(nums, k)));
  }
}
