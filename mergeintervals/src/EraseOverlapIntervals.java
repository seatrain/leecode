//给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
//
// 注意:
//
//
// 可以认为区间的终点总是大于它的起点。
// 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
//
//
// 示例 1:
//
//
//输入: [ [1,2], [2,3], [3,4], [1,3] ]
//
//输出: 1
//
//解释: 移除 [1,3] 后，剩下的区间没有重叠。
//
//
// 示例 2:
//
//
//输入: [ [1,2], [1,2], [1,2] ]
//
//输出: 2
//
//解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
//
//
// 示例 3:
//
//
//输入: [ [1,2], [2,3] ]
//
//输出: 0
//
//解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
//
// Related Topics 贪心算法
// 👍 210 👎 0

import java.util.Arrays;

/**
 * 无重叠区间-435
 *
 * @author seatrain
 * @version 1.0
 * @date 2020/09/28 10:42
 */
public class EraseOverlapIntervals {

  public static int eraseOverlapIntervals(int[][] intervals) {
    int removed = 0;
    Arrays.sort(intervals, (i1, i2) -> {
      int result = i1[0] - i2[0];
      if (result == 0) {
        return i1[1] - i2[1];
      }
      return result;
    });
    int pointer = 0;
    for (int i = 1; i < intervals.length; i++) {
      int pointerHi = intervals[pointer][1];
      int iLo = intervals[i][0];
      int iHi = intervals[i][1];

      if (pointerHi <= iLo) {
        pointer = i;
      } else {
        if (pointerHi <= iHi) {
          removed += 1;
        } else {
          removed += 1;
          pointer = i;
        }
      }

    }

    return removed;
  }
}
