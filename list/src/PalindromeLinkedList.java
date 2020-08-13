import java.util.ArrayList;
import java.util.List;

/**
 * leecode-234-回文链表,https://leetcode-cn.com/problems/palindrome-linked-list/
 */
public class PalindromeLinkedList {

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
    List<Integer> items = new ArrayList<>();
    for (ListNode node = head; node != null; node = node.next) {
      items.add(node.val);
    }

    int start = 0;
    int end = items.size() - 1;

    while (end >= start) {
      if (!items.get(start++).equals(items.get(end--))) {
        return false;
      }

    }

    return true;
  }



  public static void main(String[] args) {
    ListNode listNode1 = new ListNode(1);
    ListNode listNode2 = new ListNode(1);
    ListNode listNode3 = new ListNode(2);
    ListNode listNode4 = new ListNode(1);
    listNode1.next = listNode2;
    listNode2.next = listNode3;
    listNode3.next = listNode4;

    PalindromeLinkedList palindromeLinkedList = new PalindromeLinkedList();
  }
}
