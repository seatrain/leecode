/**
 * 环形链表，leecode-141，链接：https://leetcode-cn.com/problems/linked-list-cycle/
 */
public class LinkedListCycle {

  class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }

  public boolean hasCycle(ListNode head) {
    // 快慢指针
    if (head == null || head.next == null) {
      return false;
    }

    ListNode slow = head;
    ListNode fast = head.next;

    while (slow != fast) {
      if (fast.next == null || fast.next.next == null) {
        return false;
      }

      fast = fast.next.next;
      slow = slow.next;
    }

    return true;
  }
}
