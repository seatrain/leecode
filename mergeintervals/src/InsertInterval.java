//给出一个无重叠的 ，按照区间起始端点排序的区间列表。
//
// 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
//
//
//
// 示例 1：
//
// 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
//输出：[[1,5],[6,9]]
//
//
// 示例 2：
//
// 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
//输出：[[1,2],[3,10],[12,16]]
//解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
//
//
//
//
// 注意：输入类型已在 2019 年 4 月 15 日更改。请重置为默认代码定义以获取新的方法签名。
// Related Topics 排序 数组
// 👍 205 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * 插入区间-57
 *
 * @author seatrain
 * @version 1.0
 * @date 2020/09/29 9:19
 */
public class InsertInterval {

  public static int[][] insert(int[][] intervals, int[] newInterval) {
    LinkedList<int[]> result = new LinkedList<>();

    if (intervals.length == 0) {
      result.add(newInterval);
    }

    for (int i = 0; i < intervals.length; i++) {
      if (newInterval[1] >= intervals[i][1]) {
        if (newInterval[0] <= intervals[i][1]) {
          newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
        } else {
          result.add(intervals[i]);
        }
      } else {
        if (newInterval[1] >= intervals[i][0]) {
          newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
          newInterval[1] = intervals[i][1];
        } else {
          result.add(newInterval);
          for (int j = i; j < intervals.length; j++) {
            result.add(intervals[j]);
          }
          break;
        }
      }
    }

    if (result.size() > 0) {
      if (newInterval[0] > result.get(result.size() - 1)[1]) {
        result.add(newInterval);
      }
    } else {
      result.add(newInterval);
    }

    return result.toArray(new int[result.size()][2]);
  }

  public static void main(String[] args) {
    int[][] intervals = new int[][]{{1, 3}, {6, 9}};
    int[] newInterval = new int[]{2, 5};

    System.out.println(Arrays.deepToString(insert(intervals, newInterval)));
  }
}
