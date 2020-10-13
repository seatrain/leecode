import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
//
// 例如：
//给定二叉树 [3,9,20,null,null,15,7],
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
//
// 返回锯齿形层次遍历如下：
//
// [
//  [3],
//  [20,9],
//  [15,7]
//]
//
// Related Topics 栈 树 广度优先搜索
// 👍 279 👎 0

/**
 * 二叉树的锯齿形层次遍历-103
 *
 * @author seatrain
 * @version 1.0
 * @date 2020/10/13 9:51
 */
public class ZigzagLevelOrder {

  public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> vals = new LinkedList<>();
    if (root == null) {
      return vals;
    }

    Queue<TreeNode> nodes = new LinkedList<>();
    int currLevel = 1;
    nodes.offer(root);

    while (!nodes.isEmpty()) {
      int currLevelNodeSize = nodes.size();
      LinkedList<Integer> currLevelValues = new LinkedList<>();

      for (int i = 0; i < currLevelNodeSize; i++) {
        TreeNode node = nodes.remove();

        if (node.left != null) {
          nodes.add(node.left);
        }

        if (node.right != null) {
          nodes.add(node.right);
        }

        if (currLevel % 2 == 0) { // 偶数层，从右到左添加元素
          currLevelValues.addFirst(node.val);
        } else {
          currLevelValues.add(node.val);
        }

      }
      vals.add(currLevelValues);
      currLevel += 1;
    }

    return vals;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(3);
    TreeNode node1 = new TreeNode(9);
    TreeNode node2 = new TreeNode(20);
    TreeNode node3 = new TreeNode(15);
    TreeNode node4 = new TreeNode(7);
    root.left = node1;
    root.right = node2;
    node2.left = node3;
    node2.right = node4;
    System.out.println(zigzagLevelOrder(root));
  }
}
