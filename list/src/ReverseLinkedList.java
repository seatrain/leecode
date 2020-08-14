
/**
 * leecode-206-反转链表,https://leetcode-cn.com/problems/reverse-linked-list/
 * 迭代法
 */
public class ReverseLinkedList {

  public static class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  public ListNode reverseList(ListNode head) {
    ListNode curr = head;
    ListNode prev = null;

    while (curr != null) {
      ListNode next = curr.next;
      curr.next = prev;
      prev = curr;

      curr = next;
    }

    return prev;
  }
}
