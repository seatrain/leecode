import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * <p>下一个更大元素 I，leecode-496，链接：https://leetcode-cn.com/problems/next-greater-element-i/ <p>
 * <p>单调栈解法</>
 */
public class NextGreaterElement1 {

  public static int[] nextGreaterElement(int[] children, int[] parent) {
    int[] result = new int[children.length];
    Map<Integer, Integer> map = new HashMap<>(parent.length);
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < parent.length; i++) {
      while (!stack.isEmpty() && parent[i] > parent[stack.peek()]) {
        Integer index = stack.pop();
        map.put(parent[index], parent[i]);
      }
      stack.push(i);
    }

    while (!stack.isEmpty()) {
      Integer index = stack.pop();
      map.put(parent[index], -1);
    }

    for (int i = 0; i < children.length; i++) {
      result[i] = map.get(children[i]);
    }
    return result;
  }

  public static void main(String[] args) {
    int[] children = new int[]{1, 3, 5, 2, 4};
    int[] parent = new int[]{6, 5, 4, 3, 2, 1, 7};
    System.out.println(Arrays.toString(nextGreaterElement(children, parent)));
  }
}
