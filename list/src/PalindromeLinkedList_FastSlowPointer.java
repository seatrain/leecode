/**
 * leecode-234-回文链表,https://leetcode-cn.com/problems/palindrome-linked-list/ 快慢指针
 */
public class PalindromeLinkedList_FastSlowPointer {

  public static class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  // 讲列表中的元素放入数组之中，然后使用双指针，头指针从头部开始遍历，尾指针从尾部开始遍历，指导头部和尾部指针相遇
  // 若出现值不相等的情况，则说明不为回文
  public boolean isPalindrome(ListNode head) {
    if (head == null) {
      return true;
    }

    ListNode firstHalfEnd = endOfFirstHalf(head);
    ListNode secondHalfStart = reverseList(firstHalfEnd.next);

    for (ListNode nodeFirst = head, nodeSecond = secondHalfStart; nodeFirst != secondHalfStart && nodeSecond != null; nodeFirst = nodeFirst.next, nodeSecond = nodeSecond.next) {
      if (nodeFirst.val != nodeSecond.val) {
        return false;
      }
    }

    return true;
  }

  // 获取回文第一部分的结尾
  private ListNode endOfFirstHalf(ListNode head) {
    ListNode fast = head;
    ListNode slow = head;
    while (fast.next != null && fast.next.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }

    return slow;
  }

  private ListNode reverseList(ListNode head) {
    ListNode prev = null;
    ListNode curr = head;
    while (curr != null) {
      ListNode nextTemp = curr.next;
      curr.next = prev;
      prev = curr;
      curr = nextTemp;
    }
    return prev;
  }


  public static void main(String[] args) {
    ListNode listNode1 = new ListNode(1);
    ListNode listNode2 = new ListNode(1);
    ListNode listNode3 = new ListNode(2);
    ListNode listNode4 = new ListNode(1);
    listNode1.next = listNode2;
    listNode2.next = listNode3;
    listNode3.next = listNode4;

    PalindromeLinkedList_FastSlowPointer palindromeLinkedList = new PalindromeLinkedList_FastSlowPointer();
  }
}
