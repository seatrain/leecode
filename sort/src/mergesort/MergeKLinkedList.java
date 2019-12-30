package mergesort;

/**
 * Leecode-23-合并K个有序链表
 */
public class MergeKLinkedList {

  public static class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  public ListNode mergeKLists(ListNode[] lists) {

    if (lists != null && lists.length > 0) {
      return mergeKLists(lists, 0, lists.length - 1);
    }

    return null;
  }

  public ListNode mergeKLists(ListNode[] lists, int lo, int hi) {
    ListNode head = null;
    for (int i = lo; i <= hi; i++) {
      if (lists[i] == null) {
        continue;
      } else {
        if (head == null) {
          head = lists[i];
          continue;
        }
      }
      mergeTwoList(head, lists[i]);
    }
    return head;
  }

  // merge l1 and l2 into l1
  private void mergeTwoList(ListNode l1, ListNode l2) {
    ListNode p1 = l1;
    ListNode p2 = l2;

    while (p2 != null) {
      if (p1 == null) {
        p1 = new ListNode(p2.val);
        p2 = p2.next;
      } else if (p2.val <= p1.val) {
        int oldVal = p1.val;
        p1.val = p2.val;

        ListNode oldNode = p1.next;
        p1.next = new ListNode(oldVal);
        if (p1.next != null) {
          p1.next.next = oldNode;
        }
        p1 = p1.next;
        p2 = p2.next;
      } else if (p1.next == null) {
        p1.next = new ListNode(p2.val);
        p2 = p2.next;
        p1 = p1.next;
      } else {
        p1 = p1.next;
      }
    }
  }

  public static void main(String[] args) {
    ListNode[] lists = new ListNode[2];
    lists[0] = new ListNode(1);
    lists[1] = new ListNode(0);

    MergeKLinkedList mergeKLinkedList = new MergeKLinkedList();
    ListNode listNode = mergeKLinkedList.mergeKLists(lists);
    while (listNode != null) {
      System.out.println(listNode.val);
      listNode = listNode.next;
    }
  }
}
