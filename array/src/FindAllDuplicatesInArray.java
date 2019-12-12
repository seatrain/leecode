import java.util.ArrayList;
import java.util.List;

/**
 * lecode 442 将负号作为出现一次的标记，标记在num[i]位置的元素上，当num[i] = i的元素再次出现时，检测num[i]是否为负数 leecode-442
 */
public class FindAllDuplicatesInArray {

  public List<Integer> findDuplicates(int[] nums) {
    List<Integer> result = new ArrayList<>();

    for (int i = 0; i < nums.length; i++) {
      int index = Math.abs(nums[i]);
      if (nums[index - 1] < 0) {
        result.add(index);
      } else {
        nums[index - 1] *= -1;
      }
    }
    return result;
  }

}
