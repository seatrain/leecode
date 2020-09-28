//给出一个区间的集合，请合并所有重叠的区间。
//
//
//
// 示例 1:
//
// 输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出: [[1,6],[8,10],[15,18]]
//解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
//
//
// 示例 2:
//
// 输入: intervals = [[1,4],[4,5]]
//输出: [[1,5]]
//解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
//
// 注意：输入类型已于2019年4月15日更改。 请重置默认代码定义以获取新方法签名。
//
//
//
// 提示：
//
//
// intervals[i][0] <= intervals[i][1]
//
// Related Topics 排序 数组
// 👍 627 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 合并区间-56
 *
 * @author seatrain
 * @version 1.0
 * @date 2020/09/27 14:16
 */
public class Merge {

  public static int[][] merge(int[][] intervals) {
    if (intervals.length == 0) {
      return new int[0][2];
    }

    Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));

    List<int[]> result = new ArrayList<>();
    result.add(intervals[0]);

    for (int i = 1; i < intervals.length; i++) {
      int left = intervals[i][0];
      int right = intervals[i][1];

      int size = result.size();
      if (result.get(size - 1)[1] < left) {
        result.add(new int[]{left, right});
      } else {
        result.get(size - 1)[1] = Math.max(result.get(size - 1)[1], right);
      }
    }

    return result.toArray(new int[result.size()][]);
  }

  public static void main(String[] args) {
//    int[][] intervals = new int[][]{{1,3},{2,6},{8,10},{15,18}};
//    int[][] intervals = new int[][]{{1, 4}, {0, 1}};
    int[][] intervals = new int[][]{{1, 4}, {2, 3}};
//    int[][] intervals = new int[][]{{2, 3}, {4, 5}, {6, 7}, {8, 9}, {1, 10}};
    System.out.println(Arrays.deepToString(merge(intervals)));
  }
}
