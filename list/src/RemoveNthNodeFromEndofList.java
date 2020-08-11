/**
 * 删除链表的倒数第N个节点，leecode-19，链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 */
public class RemoveNthNodeFromEndofList {

  public static class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  public static ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode prev = null; // 被删除节点的前驱节点
    int length = 0;
    for (ListNode node = head; node != null; node = node.next) {
      if (prev != null) {
        prev = prev.next;
      }

      if (length - n >= 0 && prev == null) {
        prev = head;
      }

      length++;
    }

    if (prev == null) {
      head = head.next;
    } else {
      ListNode next = prev.next;
      if (next == null) {
        prev.next = null;
      } else {
        prev.next = prev.next.next;
      }
    }

    return head;
  }

  public static void main(String[] args) {
    ListNode l1 = new ListNode(1);
    ListNode l2 = new ListNode(2);
    ListNode l3 = new ListNode(3);
    ListNode l4 = new ListNode(4);
    ListNode l5 = new ListNode(5);
    l1.next = l2;
    l2.next = l3;
    l3.next = l4;
    l4.next = l5;

    removeNthFromEnd(l1, 2);
  }
}
