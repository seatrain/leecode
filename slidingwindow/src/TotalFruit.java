//在一排树中，第 i 棵树产生 tree[i] 型的水果。
//你可以从你选择的任何树开始，然后重复执行以下步骤：
//
//
// 把这棵树上的水果放进你的篮子里。如果你做不到，就停下来。
// 移动到当前树右侧的下一棵树。如果右边没有树，就停下来。
//
//
// 请注意，在选择一颗树后，你没有任何选择：你必须执行步骤 1，然后执行步骤 2，然后返回步骤 1，然后执行步骤 2，依此类推，直至停止。
//
// 你有两个篮子，每个篮子可以携带任何数量的水果，但你希望每个篮子只携带一种类型的水果。
//
// 用这个程序你能收集的水果树的最大总量是多少？
//
//
//
// 示例 1：
//
// 输入：[1,2,1]
//输出：3
//解释：我们可以收集 [1,2,1]。
//
//
// 示例 2：
//
// 输入：[0,1,2,2]
//输出：3
//解释：我们可以收集 [1,2,2]
//如果我们从第一棵树开始，我们将只能收集到 [0, 1]。
//
//
// 示例 3：
//
// 输入：[1,2,3,2,2]
//输出：4
//解释：我们可以收集 [2,3,2,2]
//如果我们从第一棵树开始，我们将只能收集到 [1, 2]。
//
//
// 示例 4：
//
// 输入：[3,3,3,1,2,1,1,2,3,3,4]
//输出：5
//解释：我们可以收集 [1,2,1,1,2]
//如果我们从第一棵树或第八棵树开始，我们将只能收集到 4 棵水果树。
//
//
//
//
// 提示：
//
//
// 1 <= tree.length <= 40000
// 0 <= tree[i] < tree.length
//
// Related Topics 双指针
// 👍 44 👎 0

import java.util.HashMap;

/**
 * 水果成篮
 *
 * @author seatrain
 * @version 1.0
 * @date 2020/08/20 10:27
 */
public class TotalFruit {

  public int totalFruit(int[] tree) {
    int length = tree.length;
    int left = 0;
    int right = 0;
    int maxLength = 0;
    Count count = new Count(3);

    while (right < length) {
      count.put(tree[right], 1);
      if (count.size() > 2) {
        while (count.size() > 2) {
          int item = tree[left];
          count.put(item, -1);
          if (count.get(item) == 0) {
            count.remove(item);
          }
          left++;
        }
      } else {
        maxLength = Math.max(maxLength, right - left + 1);
      }
      right++;
    }

    return maxLength;
  }

  static class Count extends HashMap<Integer, Integer> {

    public Count(int i) {
      super(3);
    }

    @Override
    public Integer get(Object key) {
      Integer value = super.get(key);
      return value == null ? 0 : value;
    }

    @Override
    public Integer put(Integer key, Integer value) {
      int result = 0;
      if (containsKey(key)) {
        result = get(key) + value;
        super.put(key, result);
      } else {
        result = 1;
        super.put(key, result);
      }

      return result;
    }
  }


  public static void main(String[] args) {
    int[] tree = new int[]{3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4};
    TotalFruit totalFruit = new TotalFruit();
    System.out.println(totalFruit.totalFruit(tree));
  }
}
