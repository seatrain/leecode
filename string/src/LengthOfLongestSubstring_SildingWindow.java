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

import java.util.HashSet;

// 滑动窗口+HashSet解法
class LengthOfLongestSubstring_SildingWindow {


  public int lengthOfLongestSubstring(String s) {
    int right = -1;
    int length = s.length();
    int maxLength = 0;

    HashSet<Character> set = new HashSet<>();

    for (int i = 0; i < length; i++) {
      if (i != 0) {
        set.remove(s.charAt(i - 1));
      }

      while (right + 1 < length && !set.contains(s.charAt(right + 1))) {
        right += 1;
        set.add(s.charAt(right));
      }

      maxLength = Math.max(maxLength, right - i + 1);
    }

    return maxLength;
  }


  public static void main(String[] args) {
    String s = "abcabcbb";
    LengthOfLongestSubstring_SildingWindow lengthOfLongestSubstring = new LengthOfLongestSubstring_SildingWindow();
    System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring(s));
  }

}
