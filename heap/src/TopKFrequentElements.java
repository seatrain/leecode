import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 前 K 个高频元素，leecode-347，链接：https://leetcode-cn.com/problems/top-k-frequent-elements/
 */
public class TopKFrequentElements {

  public static int[] topKFrequent(int[] nums, int k) {
    HashMap<Integer, Integer> item2CountMap = new HashMap<>();
    for (int item : nums) {
      item2CountMap.computeIfPresent(item, (key, val) -> val += 1);
      item2CountMap.putIfAbsent(item, 1);
    }

    List<Entry<Integer, Integer>> list = new ArrayList<>(item2CountMap.entrySet());
    ValueComparator vc=new ValueComparator();
    list.sort(vc);

    int[] result = new int[k];
    for(int i = 0; i < k; i++) {
      result[i] = list.get(i).getKey();
    }

    return result;
  }

  private static class ValueComparator implements Comparator<Map.Entry<Integer, Integer>>{

    @Override
    public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
      return o2.getValue() - o1.getValue();
    }
  }

  public static void main(String[] args) {
    int[] nums = new int[]{1,1,1,2,2,3};
    int k = 2;
    System.out.println(Arrays.toString(topKFrequent(nums, k)));
  }
}
