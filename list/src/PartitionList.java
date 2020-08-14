/**
 * 分隔链表，leecode-86，链接：https://leetcode-cn.com/problems/partition-list/
 */
public class PartitionList {

  public static class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  public static ListNode partition(ListNode head, int x) {
    ListNode smaller = new ListNode(-1);
    ListNode greater = new ListNode(-1);

    ListNode smallerIterator = smaller;
    ListNode greaterIterator = greater;

    for (ListNode node = head; node != null; node = node.next) {
      if (node.val < x) {
        smallerIterator.next = node;
        smallerIterator = smallerIterator.next;

      } else {
        greaterIterator.next = node;
        greaterIterator = greaterIterator.next;

      }



    }

    smallerIterator.next = null;
    greaterIterator.next = null;

    if (smaller.next != null) {
      smallerIterator.next = greater.next;
    } else {
      smaller.next = greater.next;
    }

    return smaller.next;
  }

  public static void main(String[] args) {
    ListNode node1 = new ListNode(1);
    ListNode node2 = new ListNode(4);
    ListNode node3 = new ListNode(3);
    ListNode node4 = new ListNode(2);
    ListNode node5 = new ListNode(5);
    ListNode node6 = new ListNode(2);
    node1.next = node2;
    node2.next = node3;
    node3.next = node4;
    node4.next = node5;
    node5.next = node6;

    partition(node1, 3);
  }
}
