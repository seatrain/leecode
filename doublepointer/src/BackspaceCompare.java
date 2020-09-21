//给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
//
// 注意：如果对空文本输入退格字符，文本继续为空。
//
//
//
// 示例 1：
//
// 输入：S = "ab#c", T = "ad#c"
//输出：true
//解释：S 和 T 都会变成 “ac”。
//
//
// 示例 2：
//
// 输入：S = "ab##", T = "c#d#"
//输出：true
//解释：S 和 T 都会变成 “”。
//
//
// 示例 3：
//
// 输入：S = "a##c", T = "#a#c"
//输出：true
//解释：S 和 T 都会变成 “c”。
//
//
// 示例 4：
//
// 输入：S = "a#c", T = "b"
//输出：false
//解释：S 会变成 “c”，但 T 仍然是 “b”。
//
//
//
// 提示：
//
//
// 1 <= S.length <= 200
// 1 <= T.length <= 200
// S 和 T 只含有小写字母以及字符 '#'。
//
//
//
//
// 进阶：
//
//
// 你可以用 O(N) 的时间复杂度和 O(1) 的空间复杂度解决该问题吗？
//
//
//
// Related Topics 栈 双指针
// 👍 151 👎 0

/**
 * 比较退格的字符串-844
 *
 * @author seatrain
 * @version 1.0
 * @date 2020/09/14 10:05
 */
public class BackspaceCompare {

  public static boolean backspaceCompare(String S, String T) {
    int s = S.length() - 1;
    int t = T.length() - 1;

    int sSkip = 0; // S的退格符数量
    int tSkip = 0; // T的退格符数量

    while (s >= 0 || t >= 0) {

      while (s >= 0) {
        if (S.charAt(s) == '#') {
          sSkip += 1;
          s -= 1;
        } else if (sSkip > 0) {
          sSkip -= 1;
          s -= 1;
        } else {
          break;
        }
      }

      while (t >= 0) {
        if (T.charAt(t) == '#') {
          tSkip += 1;
          t -= 1;
        } else if (tSkip > 0) {
          tSkip -= 1;
          t -= 1;
        } else {
          break;
        }
      }

      // 先进行s和t的有效性检测，避免出现index异常
      if (s >= 0 && t >= 0 && S.charAt(s) != T.charAt(t)) {
        return false;
      }

      s -= 1;
      t -= 1;

    }

    return s == t;
  }

  public static void main(String[] args) {


    String S = "xywrrmp";
    String T = "xywrrmu#p";

    System.out.println(backspaceCompare(S, T));
  }
}
