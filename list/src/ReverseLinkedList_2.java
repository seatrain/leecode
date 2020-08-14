
/**
 * leecode-206-反转链表,https://leetcode-cn.com/problems/reverse-linked-list/ 递归法
 */
public class ReverseLinkedList_2 {

  public static class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  public ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode p = reverseList(head.next);
    head.next.next = head;
    head.next = null;
    return p;
  }
}
