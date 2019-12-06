/**
 * 844：比较退格字符串
 */
public class Solution {

  class MyStack {

    class Node {

      char value;
      Node next;
    }

    private Node head;

    private int size;

    public MyStack() {
    }

    public void push(char c) {
      Node node = new Node();
      node.value = c;
      node.next = head;
      head = node;
      size++;
    }

    public void pop() {
      if (head != null) {
        head = head.next;
        size--;
      }

    }


    public boolean equals(MyStack testStack) {
      if (testStack == null || testStack.size != this.size) {
        return false;
      }

      Node temp = this.head;
      Node testTemp = testStack.head;
      while (temp != null && testTemp != null) {
        if (temp.value != testTemp.value) {
          return false;
        }
        temp = temp.next;
        testTemp = testTemp.next;
      }

      return true;
    }
  }

  public boolean backspaceCompare(String S, String T) {
    MyStack stack1 = formatString(S);
    MyStack stack2 = formatString(T);
    return stack1.equals(stack2);
  }

  public MyStack formatString(String s) {
    MyStack stack = new MyStack();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if ('#' == c) {
        stack.pop();
      } else {
        stack.push(c);
      }
    }
    return stack;
  }
}
