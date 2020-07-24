import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * <p>前 K 个高频元素，leecode-347，链接：https://leetcode-cn.com/problems/top-k-frequent-elements/<p/>
 * <p>使用优先队列实现堆</p>
 */
public class TopKFrequentElements_PriorityQueue {

  public static int[] topKFrequent(int[] nums, int k) {
    HashMap<Integer, Integer> item2CountMap = new HashMap<>();
    for (int num : nums) {
      item2CountMap.put(num, item2CountMap.getOrDefault(num, 0) + 1);
    }
    PriorityQueue<Integer> heap = new PriorityQueue<>(k, Comparator.comparingInt(item2CountMap::get));
    for (Integer item : item2CountMap.keySet()) {
      heap.add(item);
      if (heap.size() > k) {
        heap.poll();
      }
    }

    int[] result = new int[k];
    int temp = 0;
    while (!heap.isEmpty()) {
      result[temp++] = heap.poll();
    }
    return result;
  }


  public static void main(String[] args) {
    int[] nums = new int[]{1, 1, 1, 2, 2, 3};
    int k = 2;
    System.out.println(Arrays.toString(topKFrequent(nums, k)));
  }
}
