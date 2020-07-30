import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <p>合并K个排序链表，leecode-23，链接：https://leetcode-cn.com/problems/merge-k-sorted-lists/</p>
 * <p>优先队列</p>
 */
public class MergekSortedLists {

  public static class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  public ListNode mergeKLists(ListNode[] lists) {
    PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
    for (int i = 0; i < lists.length; i++) {
      ListNode list = lists[i];
      while (list != null) {
        queue.add(list);
        list = list.next;
      }
    }

    if (queue.isEmpty()) {
      return null;
    }

    ListNode head = new ListNode(queue.poll().val);
    ListNode tail = head;
    while (!queue.isEmpty()) {
      int val = queue.poll().val;
      tail.next = new ListNode(val);
      tail = tail.next;
    }

    return head;
  }

  public static void main(String[] args) {
    MergekSortedLists mergekSortedLists = new MergekSortedLists();
    ListNode listNode1_1 = new ListNode(-2);
    ListNode listNode1_2 = new ListNode(-1);
    ListNode listNode1_3 = new ListNode(-1);
    ListNode listNode1_4 = new ListNode(-1);
    listNode1_1.next = listNode1_2;
    listNode1_2.next = listNode1_3;
    listNode1_3.next = listNode1_4;

    ListNode listNode2_1 = new ListNode(1);
    ListNode listNode2_2 = new ListNode(3);
    ListNode listNode2_3 = new ListNode(4);
    listNode2_1.next = listNode2_2;
    listNode2_2.next = listNode2_3;

    ListNode[] lists = new ListNode[]{listNode1_1, null};
    ListNode result = mergekSortedLists.mergeKLists(lists);
    while (result != null) {
      System.out.println(result.val);
      result = result.next;
    }
  }
}
