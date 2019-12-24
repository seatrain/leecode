/**
 * leecode 206 反转链表
 */
public class ReverseStack {

  public class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  public ListNode reverseList(ListNode head) {
    ListNode reveredHead = null;

    while (head != null) {
      ListNode old = reveredHead;
      reveredHead = new ListNode(head.val);
      reveredHead.next = old;

      head = head.next;
    }
    return reveredHead;
  }
}
