package mergesort;

/**
 * leecode-21-合并有序链表
 */
public class MergeTwoSortedLinkedList {

  public static class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode p = null;
    ListNode head = null;
    ListNode p1 = l1;
    ListNode p2 = l2;

    while (p1 != null || p2 != null) {
      if (p1 == null) {
        p = addNode(p, p2);
        p2 = p2.next;
      } else if (p2 == null) {
        p = addNode(p, p1);
        p1 = p1.next;
      } else if (p1.val <= p2.val) {
        p = addNode(p, p1);
        p1 = p1.next;
      } else {
        p = addNode(p, p2);
        p2 = p2.next;
      }

      if (head == null) {
        head = p;
      }

    }
    return head;
  }

  private ListNode addNode(ListNode target, ListNode source) {
    if (source != null) {
      if (target != null) {
        ListNode old = target;
        target = new ListNode(source.val);
        old.next = target;
      } else {
        target = new ListNode(source.val);
      }
    }
    return target;
  }

  public static void main(String[] args) {
    ListNode l1 = new ListNode(1);
    ListNode l2 = new ListNode(2);

    MergeTwoSortedLinkedList mergeTwoSortedLinkedList = new MergeTwoSortedLinkedList();
    mergeTwoSortedLinkedList.mergeTwoLists(l1, l2);
  }
}
