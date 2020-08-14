import java.util.ArrayList;
import java.util.List;

/**
 * leecode-143-重排链表,https://leetcode-cn.com/problems/reorder-list/
 */
public class ReorderList {

  public static class ListNode {

    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }

  // 使用数组保存链表的元素
  // 使用头尾两个指针指向数组的头和尾
  // 使用指针在链表上移动，每次移动两格，第一格的值替换为头节点的值，第二格的值替换为尾节点的值
  public void reorderList(ListNode head) {
    List<Integer> valList = new ArrayList<>();
    for (ListNode node = head; node != null; node = node.next) {
      valList.add(node.val);
    }

    int size = valList.size();
    if (size == 0 || size == 1) {
      return;
    }

    int start = 0;
    int end = size - 1;

    for (ListNode node = head; node != null && end >= start; ) {
      node.val = valList.get(start++);
      if (node.next != null) {
        node.next.val = valList.get(end--);
        node = node.next;
      }
      node = node.next;
    }

    head = head;
  }

  public static void main(String[] args) {
    ListNode node1 = new ListNode(1);
    ListNode node2 = new ListNode(2);
    ListNode node3 = new ListNode(3);
    ListNode node4 = new ListNode(4);
    ListNode node5 = new ListNode(5);

    node1.next = node2;
    node2.next = node3;
    node3.next = node4;
    node4.next = node5;

    ReorderList reorderList = new ReorderList();
    reorderList.reorderList(node1);

  }
}
