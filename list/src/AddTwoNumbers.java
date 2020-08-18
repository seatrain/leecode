/**
 * leecode-2-两数相加,https://leetcode-cn.com/problems/add-two-numbers/
 */
public class AddTwoNumbers {


  public static class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode dum = new ListNode(-1);
    ListNode iterator = dum;

    int carry = 0; // 进位

    // 当两个链表其中一个链表尚未遍历结束 或 还有进位未处理的情况下继续循环处理
    while (l1 != null || l2 != null || carry > 0) {
      int val1 = l1 == null ? 0 : l1.val;
      int val2 = l2 == null ? 0 : l2.val;

      int sum = val1 + val2 + carry;
      int val = sum % 10; // 当前节点的值
      carry = sum / 10; // 进位值

      // add new node
      iterator.next = new ListNode(val);
      iterator = iterator.next;

      l1 = l1 == null ? null : l1.next;
      l2 = l2 == null ? null : l2.next;
    }

    return dum.next;
  }


  public static void main(String[] args) {
    ListNode l1_1 = new ListNode(1);
    ListNode l1_2 = new ListNode(9);
    ListNode l1_3 = new ListNode(9);
    ListNode l1_4 = new ListNode(9);
    ListNode l1_5 = new ListNode(9);
    ListNode l1_6 = new ListNode(9);
    ListNode l1_7 = new ListNode(9);
    ListNode l1_8 = new ListNode(9);
    ListNode l1_9 = new ListNode(9);
    ListNode l1_10 = new ListNode(9);
    l1_1.next = l1_2;
    l1_2.next = l1_3;
    l1_3.next = l1_4;
    l1_4.next = l1_5;
    l1_5.next = l1_6;
    l1_6.next = l1_7;
    l1_7.next = l1_8;
    l1_8.next = l1_9;
    l1_9.next = l1_10;

    ListNode l2_1 = new ListNode(9);

    AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
    System.out.println(addTwoNumbers.addTwoNumbers(l1_1, l2_1));
  }
}
