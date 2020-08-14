//给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
//
// 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
//
// 示例:
//
// 给定的有序链表： [-10, -3, 0, 5, 9],
//
//一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
//
//      0
//     / \
//   -3   9
//   /   /
// -10  5
//
// Related Topics 深度优先搜索 链表
// 👍 277 👎 0


class SortedListToBST {

  public static class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public static class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  public TreeNode sortedListToBST(ListNode head) {
    if (head == null) {
      return null;
    }

    return reverse(head, null);
  }

  private TreeNode reverse(ListNode start, ListNode end) {
    if (start == end) {
      return null;
    }

    ListNode middleNode = getMiddleNode(start, end);
    TreeNode left = reverse(start, middleNode);
    TreeNode right = reverse(middleNode.next, end);

    TreeNode treeNode = new TreeNode(middleNode.val);
    treeNode.left = left;
    treeNode.right = right;

    return treeNode;
  }

  private ListNode getMiddleNode(ListNode start, ListNode end) {
    ListNode slow = start;
    ListNode fast = start;

    while (fast.next != end && fast.next.next != end) {
      fast = fast.next.next;
      slow = slow.next;
    }

    return slow;
  }


  public static void main(String[] args) {
    ListNode node1 = new ListNode(-10);
    ListNode node2 = new ListNode(-3);
    ListNode node3 = new ListNode(0);
    ListNode node4 = new ListNode(5);
    ListNode node5 = new ListNode(9);
    node1.next = node2;
    node2.next = node3;
    node3.next = node4;
    node4.next = node5;


    SortedListToBST sortedListToBST = new SortedListToBST();
    TreeNode treeNode = sortedListToBST.sortedListToBST(node1);
    System.out.println(treeNode);
  }
}
