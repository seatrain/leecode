public class MyQueue {

  private Node head;

  private Node tail;

  class Node {

    int value;
    Node next;
  }

  /**
   * Initialize your data structure here.
   */
  public MyQueue() {

  }

  /**
   * Push element x to the back of queue.
   */
  public void push(int x) {
    Node node = new Node();
    node.value = x;

    if (tail == null) {
      tail = node;
    } else {
      tail.next = node;
      tail = node;
    }

    if (head == null) {
      head = node;
    }
  }

  /**
   * Removes the element from in front of queue and returns that element.
   */
  public int pop() {
    Node oldNode = head;
    head = head.next;
    return oldNode.value;
  }

  /**
   * Get the front element.
   */
  public int peek() {
    return head.value;
  }

  /**
   * Returns whether the queue is empty.
   */
  public boolean empty() {
    return head == null;
  }
}
