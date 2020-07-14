import java.util.Stack;

/**
 * 字符串解码，leecode-394，链接：https://leetcode-cn.com/problems/decode-string/
 */
public class DecodeString {

  private static final char MULTIPLICATION_SING = '*';
  private static final char PLUS_SING = '+';
  private static final char LEFT_BRACKET_SING = '[';
  private static final char RIGHT_BRACKET_SING = ']';

  // 当前解析的位置
  int ptr = 0;

  public String decodeString(String s) {
    Stack<String> items = new Stack<>();

    while (ptr < s.length()) {
      char c = s.charAt(ptr);
      if (Character.isLetter(c)) {
        items.push(String.valueOf(c));
        ptr++;
      } else if (Character.isDigit(c)) {
        // 获取一个数字并进栈
        String digits = getDigits(s);
        items.push(digits);
      } else if (c == LEFT_BRACKET_SING) {
        items.push(String.valueOf(c));
        ptr++;
      } else { // 右括号
        String item = resolve(items);
        int count = Integer.parseInt(items.pop());
        items.push(intMultiplyString(count, item));
        ptr++;
      }
    }

    return finalizeResult(items);
  }

  private String finalizeResult(Stack<String> items) {
    StringBuilder result = new StringBuilder();
    while (!items.isEmpty()) {
      result.append(items.pop());
    }
    result.reverse();
    return result.toString();
  }

  // int * string
  private String intMultiplyString(int count, String item) {
    StringBuilder result = new StringBuilder();
    for (int i = 0; i < count; i++) {
      result.append(item);
    }
    return result.toString();
  }

  private String resolve(Stack<String> items) {
    StringBuilder result = new StringBuilder();
    while (!items.isEmpty()) {
      String pop = items.pop();
      if (pop.equals(String.valueOf(LEFT_BRACKET_SING))) {
        break;
      }
      result.append(pop);
    }
    return result.toString();
  }

  private String getDigits(String s) {
    StringBuilder ret = new StringBuilder();
    while (Character.isDigit(s.charAt(ptr))) {
      ret.append(s.charAt(ptr++));
    }
    return ret.toString();
  }

  public static void main(String[] args) {
    DecodeString decodeString = new DecodeString();
    String encodeString = "abc3[cd]xyz";

    System.out.println(decodeString.decodeString(encodeString));
  }
}
