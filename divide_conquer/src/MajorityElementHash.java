import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * leecode-169-多数元素-Hash算法
 */
public class MajorityElementHash {

  public static int majorityElement(int[] nums) {
    Map<Integer, Integer> count = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (count.containsKey(nums[i])) {
        count.put(nums[i], count.get(nums[i]) + 1);
      } else {
        count.put(nums[i], 1);
      }
    }

    Integer maxKey = 0;
    Integer maxValue = 0;
    Set<Integer> integers = count.keySet();
    for (Integer i : integers) {
      Integer tempValue = count.get(i);
      if (count.get(i) > maxValue) {
        maxValue = tempValue;
        maxKey = i;
      }
    }

    return maxKey;
  }

  public static void main(String[] args) {
    int[] nums = {
        3, 3, 4
    };

    System.out.println(MajorityElementHash.majorityElement(nums));
  }
}
