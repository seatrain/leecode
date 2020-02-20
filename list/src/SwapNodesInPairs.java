/**
 * leecode-24-亮亮交换链表中的节点
 */
public class SwapNodesInPairs {

  public static class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  public static ListNode swapPairs(ListNode head) {
    ListNode temp = head;
    ListNode p = head;

    boolean headSwaped = false;
    int num = 0;

    while (temp.next != null) {
      if (num % 2 == 0) {
        ListNode old = temp;
        temp = temp.next;
        old.next = temp.next;
        temp.next = old;
        p.next = temp;

        if (!headSwaped) {
          p = temp;
          head = temp;
          headSwaped = true;
        }
      }
      temp = temp.next;
      p = p.next;
      num++;
    }

    return head;
  }

  public static void main(String[] args) {
    ListNode node1 = new ListNode(1);
    ListNode node2 = new ListNode(2);
    ListNode node3 = new ListNode(3);
    ListNode node4 = new ListNode(4);
    node1.next = node2;
    node2.next = node3;
    node3.next = node4;

    printfListNode(node1);
    SwapNodesInPairs.swapPairs(node1);
    printfListNode(node1);
  }

  public static void printfListNode(ListNode head) {
    ListNode temp = head;
    while (temp != null) {
      System.out.print(temp.val + "->");
      temp = temp.next;
    }
    System.out.println();
  }
}
