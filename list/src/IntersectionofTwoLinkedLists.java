/**
 * leecode-160-相交链表,https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 * 暴力解法
 */
public class IntersectionofTwoLinkedLists {

  public static class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    for (ListNode itemA = headA; itemA != null; itemA = itemA.next) {

      for (ListNode itemB = headB; itemB != null; itemB = itemB.next) {
        if (itemA == itemB) {
          return itemA;
        }
      }
    }

    return null;
  }
}
