//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
//
//
//
// 示例：
//二叉树：[3,9,20,null,null,15,7],
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
//
//
// 返回其层次遍历结果：
//
// [
//  [3],
//  [9,20],
//  [15,7]
//]
//
// Related Topics 树 广度优先搜索
// 👍 665 👎 0

//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的层序遍历-102
 *
 * @author seatrain
 * @version 1.0
 * @date 2020/10/12 10:30
 */
public class LevelOrder {


  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> vals = new ArrayList<>();
    if (root == null) {
      return vals;
    }

    Queue<TreeNode> nodes = new LinkedList<>();
    nodes.offer(root);

    while (!nodes.isEmpty()) {
      List<Integer> curLevelVals = new LinkedList<>();
      int curLevelSize = nodes.size();
      for (int i = 0; i < curLevelSize; i++) {
        TreeNode node = nodes.remove();
        if (node.left != null) {
          nodes.offer(node.left);
        }

        if (node.right != null) {
          nodes.offer(node.right);
        }

        curLevelVals.add(node.val);
      }
      vals.add(curLevelVals);
    }

    return vals;
  }
}
