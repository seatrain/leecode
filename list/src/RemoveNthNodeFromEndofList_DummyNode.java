/**
 * 删除链表的倒数第N个节点，leecode-19，链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/ 哑节点解法
 */
public class RemoveNthNodeFromEndofList_DummyNode {

  public static class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  public static ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode first = dummy;
    ListNode second = dummy;

    for (int i = 1; i <= n + 1; i++) {
      first = first.next;
    }

    while (first != null) {
      second = second.next;
      first = first.next;
    }

    second.next = second.next.next;

    return dummy.next;
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
