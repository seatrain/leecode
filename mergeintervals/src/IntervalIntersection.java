//给定两个由一些 闭区间 组成的列表，每个区间列表都是成对不相交的，并且已经排序。
//
// 返回这两个区间列表的交集。
//
// （形式上，闭区间 [a, b]（其中 a <= b）表示实数 x 的集合，而 a <= x <= b。两个闭区间的交集是一组实数，要么为空集，要么为闭区间
//。例如，[1, 3] 和 [2, 4] 的交集为 [2, 3]。）
//
//
//
// 示例：
//
//
//
// 输入：A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]
//输出：[[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
//
//
//
//
// 提示：
//
//
// 0 <= A.length < 1000
// 0 <= B.length < 1000
// 0 <= A[i].start, A[i].end, B[i].start, B[i].end < 10^9
//
// Related Topics 双指针
// 👍 84 👎 0

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 区间列表的交集-986
 *
 * @author seatrain
 * @version 1.0
 * @date 2020/09/22 10:55
 */
public class IntervalIntersection {

  public static int[][] intervalIntersection(int[][] A, int[][] B) {
    ArrayList<int[]> result = new ArrayList<>();
    int a = 0;
    int b = 0;

    while (a < A.length && b < B.length) {
      int lo = Math.max(A[a][0], B[b][0]);
      int hi = Math.min(A[a][1], B[b][1]);

      if(lo <= hi) {
        result.add(new int[]{lo, hi});
      }

      if(A[a][1] == hi) {
        a++;
      }else {
        b++;
      }

    }

    return result.toArray(new int[result.size()][2]);
  }

  public static void main(String[] args) {
    int[][] A = new int[][]{{0, 2}, {5, 10}, {13, 23}, {24, 25}};
    int[][] B = new int[][]{{1, 5}, {8, 12}, {15, 24}, {25, 26}};

    System.out.println(Arrays.deepToString(intervalIntersection(A, B)));

  }
}
