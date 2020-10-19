//给定一个二叉树，找出其最小深度。
//
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
//
// 说明: 叶子节点是指没有子节点的节点。
//
// 示例:
//
// 给定二叉树 [3,9,20,null,null,15,7],
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
// 返回它的最小深度 2.
// Related Topics 树 深度优先搜索 广度优先搜索
// 👍 382 👎 0

//leetcode submit region begin(Prohibit modification and deletion)

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的最小深度-111
 *
 * @author seatrain
 * @version 1.0
 * @date 2020/10/14 9:49
 */
public class MinDepth {

  public int minDepth(TreeNode root) {
    int minDepth = 0;
    if (root == null) {
      return minDepth;
    }

    Queue<TreeNode> nodes = new LinkedList<>();
    nodes.add(root);
    while (!nodes.isEmpty()) {
      int currLevelNodes = nodes.size();
      minDepth += 1;

      for (int i = 0; i < currLevelNodes; i++) {
        TreeNode node = nodes.remove();
        if (node.left == null && node.right == null) {
          return minDepth;
        }

        if(node.left != null) {
          nodes.offer(node.left);
        }

        if(node.right != null) {
          nodes.offer(node.right);
        }
      }
    }

    return minDepth;
  }
}
