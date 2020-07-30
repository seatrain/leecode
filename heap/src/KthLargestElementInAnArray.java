import java.util.PriorityQueue;

/**
 * leecode-215-数组中的第K个最大元素
 */
public class KthLargestElementInAnArray {

  public static int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k, (Integer::compareTo));
    for (int num : nums) {
      priorityQueue.add(num);
      if (priorityQueue.size() > k) {
        priorityQueue.poll();
      }
    }

    return priorityQueue.peek();
  }

  public static void main(String[] args) {
    int[] nums = new int[]{3, 2, 1, 5, 6, 4};
    int k = 2;
    System.out.println(findKthLargest(nums, k));
  }
}
