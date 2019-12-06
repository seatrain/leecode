/**
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) -- 将元素 x 推入栈中。 pop() -- 删除栈顶的元素。 top() -- 获取栈顶元素。 getMin() -- 检索栈中的最小元素。 示例:
 *
 * MinStack minStack = new MinStack(); minStack.push(-2); minStack.push(0); minStack.push(-3); minStack.getMin();   --> 返回 -3. minStack.pop(); minStack.top();      --> 返回 0. minStack.getMin();   --> 返回 -2.
 *
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/min-stack 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinStack {

  class Node {

    int value;
    Node next;
  }

  /**
   * 头结点
   */
  Node head;

  /**
   * 栈中最小智
   */
  int min;

  public MinStack() {

  }

  void push(int x) {
    Node node = new Node();
    node.value = x;

    if (head == null) {
      head = node;
      min = x;
    } else {
      node.next = head;
      head = node;
    }

    if (x < min) {
      min = x;
    }
  }

  void pop() {
    int value = head.value;
    if (value <= min) {
      Node temp = head.next;
      if (temp != null) {
        min = temp.value;
      }
      while (temp != null) {
        if (temp.value < min) {
          min = temp.value;
        }
        temp = temp.next;
      }
    }
    head = head.next;
  }

  int top() {
    return head.value;
  }

  int getMin() {
    return min;
  }

  public static void main(String[] args) {
    MinStack stack = new MinStack();
    stack.push(2147483646);
    stack.push(2147483646);
    stack.push(2147483647);
    System.out.println("top:" + stack.top());
    stack.pop();
    System.out.println("min:" + stack.getMin());
    stack.pop();
    System.out.println("min:" + stack.getMin());
    stack.pop();
    stack.push(-2147483648);
    System.out.println("top:" + stack.top());
    System.out.println("min:" + stack.getMin());
    stack.pop();
    System.out.println("min:" + stack.getMin());
  }
}
