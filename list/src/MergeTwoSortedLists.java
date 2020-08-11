/**
 * 合并两个有序链表，leecode-21，链接：https://leetcode-cn.com/problems/merge-two-sorted-lists/
 */
public class MergeTwoSortedLists {

  public class ListNode {

    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }

  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode prevHead = new ListNode(-1);
    ListNode prev = prevHead;

    while (l1 != null && l2 != null) {
      int val = 0;

      if (l1.val - l2.val > 0) {
        val = l2.val;
        l2 = l2.next;
      } else {
        val = l1.val;
        l1 = l1.next;
      }

      ListNode node = new ListNode(val);
      prev.next = node;
      prev = prev.next;
    }

    while (l1 != null) {
      int val = l1.val;
      ListNode node = new ListNode(val);
      prev.next = node;
      prev = prev.next;
      l1 = l1.next;
    }

    while (l2 != null) {
      int val = l2.val;
      ListNode node = new ListNode(val);
      prev.next = node;
      prev = prev.next;
      l2 = l2.next;
    }

    return prevHead.next;
  }

}
