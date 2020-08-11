import java.util.HashSet;
import java.util.Set;

/**
 * 环形链表，leecode-141，链接：https://leetcode-cn.com/problems/linked-list-cycle/
 */
public class LinkedListCycle2 {

  class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }

  public ListNode hasCycle(ListNode head) {
    Set<ListNode> set = new HashSet<>();
    for (; head != null; head = head.next) {
      if (set.contains(head)) {
        return head;
      }
      set.add(head);
    }

    return null;
  }
}
