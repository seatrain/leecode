/**
 * leecode-92-反转链表 II,https://leetcode-cn.com/problems/reverse-linked-list-ii/ 迭代法
 */
public class ReverseLinkedListII {

  public static class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  private ListNode reversedStart;
  private ListNode reversedEnd;

  public ListNode reverseBetween(ListNode head, int m, int n) {
    if (m == n) {
      return head;
    }

    ListNode prev = new ListNode(-1);
    prev.next = head;
    ListNode mp = prev;
    ListNode np = prev;

    int length = 1;
    for (ListNode node = head; node != null && length <= n; node = node.next, length++) {
      if (length < m) {
        mp = mp.next;
      }
      np = np.next;
    }

    ListNode npNext = np.next;
    reverse(mp.next, np.next);
    mp.next = reversedStart;
    reversedEnd.next = npNext;

    return prev.next;
  }

  private void reverse(ListNode start, ListNode end) {
    reversedStart = null;
    ListNode curr = start;
    reversedEnd = start;
    while (curr != end) {
      ListNode node = curr.next;
      curr.next = reversedStart;
      reversedStart = curr;
      curr = node;
    }

  }

  public static void main(String[] args) {
    ListNode node1 = new ListNode(3);
    ListNode node2 = new ListNode(5);
//    ListNode node3 = new ListNode(3);
//    ListNode node4 = new ListNode(4);
//    ListNode node5 = new ListNode(5);
    node1.next = node2;
//    node2.next = node3;
//    node3.next = node4;
//    node4.next = node5;

    ReverseLinkedListII reverseLinkedListII = new ReverseLinkedListII();
    reverseLinkedListII.reverseBetween(node1, 1, 2);

  }
}
