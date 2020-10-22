import java.util.LinkedList;
import java.util.List;

//给定一个二叉树，返回所有从根节点到叶子节点的路径。
//
// 说明: 叶子节点是指没有子节点的节点。
//
// 示例:
//
// 输入:
//
//   1
// /   \
//2     3
// \
//  5
//
//输出: ["1->2->5", "1->3"]
//
//解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
// Related Topics 树 深度优先搜索
// 👍 385 👎 0

/**
 * 二叉树的所有路径-257
 *
 * @author seatrain
 * @version 1.0
 * @date 2020/10/21 9:22
 */
public class BinaryTreePaths {

  public List<String> binaryTreePaths(TreeNode root) {
    LinkedList<String> result = new LinkedList<>();
    LinkedList<String> nodeValList = new LinkedList<>();
    if (root != null) {
      traverse(root, nodeValList, result);
    }
    return result;
  }

  private void traverse(TreeNode node, LinkedList<String> nodeValList, LinkedList<String> result) {
    nodeValList.addLast(String.valueOf(node.val));
    if (node.left == null && node.right == null) {
      result.add(format(nodeValList));
      nodeValList.removeLast();
      return;
    }

    if (node.left != null) {
      traverse(node.left, nodeValList, result);
    }

    if (node.right != null) {
      traverse(node.right, nodeValList, result);
    }
    nodeValList.removeLast();
  }

  private String format(LinkedList<String> list) {
    return String.join("->", list);
  }

}
