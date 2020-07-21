import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <p>移掉K位数字，leecode-402，链接：https://leetcode-cn.com/problems/remove-k-digits/
 */
public class RemoveKDigits {

  public static String removeKdigits(String num, int k) {
    Deque<Character> deque = new ArrayDeque<>();

    for (char c : num.toCharArray()) {
      while (k > 0 && !deque.isEmpty() && c < deque.peekLast()) {
        deque.pollLast();
        k -= 1;
      }
      deque.addLast(c);
    }

    while (k > 0) {
      deque.removeLast();
      k -= 1;
    }

    StringBuilder result = new StringBuilder();
    boolean leadingZero = true;
    for (Character c : deque) {
      if (leadingZero && c == '0') {
        continue;
      }
      leadingZero = false;
      result.append(c);
    }

    if (result.length() == 0) {
      return "0";
    }
    return result.toString();
  }


  public static void main(String[] args) {
    String num = "10";
    int k = 1;
    System.out.println(removeKdigits(num, k));
  }
}
