//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
//
// 示例 1:
//
// 输入: "abcabcbb"
//输出: 3
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
//
//
// 示例 2:
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
//
//
// 示例 3:
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
//
// Related Topics 哈希表 双指针 字符串 Sliding Window
// 👍 4179 👎 0


class LengthOfLongestSubstring {

  private String s;

  public int lengthOfLongestSubstring(String s) {
    if (s.length() <= 1) {
      return s.length();
    }

    int maxLength = 1;
    int subStringStart = 0;
    int subStringEnd = 0;
    int maxIndex = s.length() - 1;
    this.s = s;

    for (int i = 1; i < s.length(); i++) {
      char c = s.charAt(i);
      int index = lastIndexOf(subStringStart, subStringEnd, c);
      if (index >= 0) {
        subStringStart = Math.min(maxIndex, index + 1);
      }
      subStringEnd = Math.min(maxIndex, subStringEnd + 1);
      maxLength = Math.max(maxLength, subStringEnd - subStringStart + 1);
    }

    return maxLength;
  }

  /**
   * 获取c在字符串s中从start到end之间出现的最后一次的下标， 若不存在则返回-1
   *
   * @param start 开始下标 include
   * @param end 结束下标 include
   * @param c 目标字符
   * @return int 下标
   * @author seatrain
   * @date 2020/08/18 9:16
   */
  private int lastIndexOf(int start, int end, char c) {
    for (int i = end; i >= start; i--) {
      if (s.charAt(i) == c) {
        return i;
      }
    }

    return -1;
  }

  public static void main(String[] args) {
    String s = "abcabcbb";
    LengthOfLongestSubstring lengthOfLongestSubstring = new LengthOfLongestSubstring();
    System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring(s));
  }

}
