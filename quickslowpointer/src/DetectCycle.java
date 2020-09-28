//给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
//
// 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
//
// 说明：不允许修改给定的链表。
//
//
//
// 示例 1：
//
// 输入：head = [3,2,0,-4], pos = 1
//输出：tail connects to node index 1
//解释：链表中有一个环，其尾部连接到第二个节点。
//
//
//
//
// 示例 2：
//
// 输入：head = [1,2], pos = 0
//输出：tail connects to node index 0
//解释：链表中有一个环，其尾部连接到第一个节点。
//
//
//
//
// 示例 3：
//
// 输入：head = [1], pos = -1
//输出：no cycle
//解释：链表中没有环。
//
//
//
//
//
//
// 进阶：
//你是否可以不用额外空间解决此题？
// Related Topics 链表 双指针
// 👍 628 👎 0

//leetcode submit region begin(Prohibit modification and deletion)

/**
 * 环形链表2-142
 *
 * @author seatrain
 * @version 1.0
 * @date 2020/09/22 9:40
 */
public class DetectCycle {

  public static ListNode detectCycle(ListNode head) {
    if (head == null || head.next == null) {
      return null;
    }

    ListNode slow = head;
    ListNode fast = head;

    while (true) {
      if (fast == null || fast.next == null) {
        return null;
      }

      slow = slow.next;
      fast = fast.next.next;

      if (fast == slow) {
        break;
      }
    }

    fast = head;
    while (fast != slow) {
      fast = fast.next;
      slow = slow.next;
    }

    return slow;
  }

  public static void main(String[] args) {
    ListNode listNode1 = new ListNode(1);
    ListNode listNode2 = new ListNode(2);
    ListNode listNode3 = new ListNode(3);
    ListNode listNode4 = new ListNode(4);

    listNode1.next = listNode2;
    listNode2.next = listNode3;
    listNode3.next = listNode4;
    listNode4.next = listNode2;

    detectCycle(listNode1);
  }
}
