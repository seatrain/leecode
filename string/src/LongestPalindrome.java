//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
//
// 示例 1：
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
//
//
// 示例 2：
//
// 输入: "cbbd"
//输出: "bb"
//
// Related Topics 字符串 动态规划
// 👍 2576 👎 0

/**
 * 最长回文字符串
 *
 * @author seatrain
 * @version 1.0
 * @date 2020/08/18 10:21
 */
public class LongestPalindrome {

  private String s;

  public String longestPalindrome(String s) {
    int length = s.length();
    if (length <= 1) {
      return s;
    }

    this.s = s;

    String maxStr = s.substring(0, 1);
    for (int interval = 1; interval <= length; interval++) {
      for (int start = 0; start < length; start ++) {
        int end = start + interval;
        if (end < length) {
          if (palindromeString(start, end)) {
            if (maxStr.length() < end - start + 1) {
              maxStr = s.substring(start, end + 1);
            }
            break;
          }

        }
      }
    }

    return maxStr;
  }

  /**
   * 判断s的start到end之间的字符串是否未回文字符串
   *
   * @param start 起始下标
   * @param end 终点下标
   * @return boolean
   * @author seatrain
   * @date 2020/08/18 10:42
   */
  private boolean palindromeString(int start, int end) {
    while (start <= end) {
      if (s.charAt(start++) != s.charAt(end--)) {
        return false;
      }
    }

    return true;
  }


  public static void main(String[] args) {
    LongestPalindrome longestPalindrome = new LongestPalindrome();
    String s = "caba";
    System.out.println(longestPalindrome.longestPalindrome(s));
  }
}
