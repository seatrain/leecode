//给定一个由若干 0 和 1 组成的数组 A，我们最多可以将 K 个值从 0 变成 1 。
//
// 返回仅包含 1 的最长（连续）子数组的长度。
//
//
//
// 示例 1：
//
// 输入：A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
//输出：6
//解释：
//[1,1,1,0,0,1,1,1,1,1,1]
//粗体数字从 0 翻转到 1，最长的子数组长度为 6。
//
// 示例 2：
//
// 输入：A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
//输出：10
//解释：
//[0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
//粗体数字从 0 翻转到 1，最长的子数组长度为 10。
//
//
//
// 提示：
//
//
// 1 <= A.length <= 20000
// 0 <= K <= A.length
// A[i] 为 0 或 1
//
// Related Topics 双指针 Sliding Window
// 👍 90 👎 0

/**
 * TODO
 *
 * @author seatrain
 * @version 1.0
 * @date 2020/08/19 13:52
 */
public class LongestOnesII {


  public int longestOnes(int[] A, int K) {
    int left = 0;
    int right = 0;
    int length = A.length;
    int maxLength = 0;
    int count = 0;

    while (right < length) {
      count += A[right] == 0 ? 1 : 0;

      while (count > K) {
        count -= A[left] == 0 ? 1 : 0;
        left++;
      }

      maxLength = Math.max(maxLength, right - left + 1);
      right++;
    }

    return maxLength;
  }


  public static void main(String[] args) {
    int[] A = new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
    int K = 2;
    LongestOnesII longestOnesII = new LongestOnesII();
    System.out.println(longestOnesII.longestOnes(A, K));
  }
}
