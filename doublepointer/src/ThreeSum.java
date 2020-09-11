import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复
//的三元组。
//
// 注意：答案中不可以包含重复的三元组。
//
//
//
// 示例：
//
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
//
// Related Topics 数组 双指针
// 👍 2534 👎 0

/**
 * 三数之和-15
 *
 * @author seatrain
 * @version 1.0
 * @date 2020/08/31 16:59
 */
public class ThreeSum {

  public List<List<Integer>> threeSum(int[] nums) {
    int length = nums.length;
    if (length == 0) {
      return new ArrayList<>(0);
    }

    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(nums);

    for (int a = 0; a < length; a++) {
      // a 去重过滤
      if (a != 0 && nums[a] == nums[a - 1]) {
        continue;
      }

      // c从最右端开始
      int c = length - 1;
      int target = -nums[a];

      for (int b = a + 1; b < length; b++) {
        // b 去重过滤
        if (b > a + 1 && nums[b] == nums[b - 1]) {
          b += 1;
          continue;
        }

        while (b < c && nums[b] + nums[c] > target) {
          c -= 1;
        }

        // 最小的nums[b] + 最小的nums[c] 的情况下， nums[b] + nums[c] 依然大于 -nums[a]
        // 表明：在当前的a情况下，查找不到不到a+b+c=0的组合
        if (b == c) {
          break;
        }

        if (nums[b] + nums[c] == target) {
          List<Integer> item = new ArrayList<>(3);
          item.add(nums[a]);
          item.add(nums[b]);
          item.add(nums[c]);
          result.add(item);
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
    ThreeSum threeSum = new ThreeSum();
    List<List<Integer>> lists = threeSum.threeSum(nums);
    for (List<Integer> list : lists) {
      Object[] objects = list.toArray();
      System.out.println(Arrays.toString(objects));
    }
  }
}
