/**
 * leecode-160-相交链表,https://leetcode-cn.com/problems/intersection-of-two-linked-lists/ 优化解法
 */
public class IntersectionofTwoLinkedLists_2 {

  public static class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    if (headA == null || headB == null) {
      return null;
    }

    ListNode pA = headA;
    ListNode pB = headB;

    while (pA != pB) {
      pA = pA == null ? headA : pA.next;
      pB = pB == null ? headB : pB.next;
    }

    return pA;
  }
}
