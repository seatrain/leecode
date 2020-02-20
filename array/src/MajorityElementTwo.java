import java.util.ArrayList;
import java.util.List;

/**
 * leecode-229-求众数2
 */
public class MajorityElementTwo {

  public static List<Integer> majorityElement(int[] nums) {
    List<Integer> elements = new ArrayList<>(3);
    int a = 0;
    int b = 0;
    int countA = 0;
    int countB = 0;

    for (int i = 0; i < nums.length; i++) {
      if (countA <= 0) {// init countA
        a = nums[i];
        countA = 2;
        countB--;
      } else if (a != nums[i]) {
        countA--;
        if (countB <= 0) {//init countB
          b = nums[i];
          countB = 2;
        } else if (b != nums[i]) {
          countB--;
        } else {
          countB += 2;
        }
      } else {
        countA += 2;
        countB--;
      }
    }

    if (countA > 0) {
      elements.add(a);
    }

    if (countB > 0) {
      elements.add(b);
    }

    return elements;
  }

  public static void main(String[] args) {
    int[] nums = new int[]{
        1, 2
    };

    MajorityElementTwo.majorityElement(nums);
  }
}
