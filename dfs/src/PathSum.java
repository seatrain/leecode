//给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
//
// 说明: 叶子节点是指没有子节点的节点。
//
// 示例:
//给定如下二叉树，以及目标和 sum = 22，
//
//               5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \    / \
//        7    2  5   1
//
//
// 返回:
//
// [
//   [5,4,11,2],
//   [5,8,4,5]
//]
//
// Related Topics 树 深度优先搜索
// 👍 369 👎 0

//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 路径综合II-113
 *
 * @author seatrain
 * @version 1.0
 * @date 2020/10/22 9:44
 */
public class PathSum {

  private int target;

  private List<List<Integer>> result = new ArrayList<>();

  public List<List<Integer>> pathSum(TreeNode root, int sum) {
    if (root == null) {
      return result;
    }

    Integer tempSum = 0;
    this.target = sum;
    LinkedList<Integer> nodeValList = new LinkedList<>();
    traverse(root, tempSum, nodeValList);

    return result;
  }

  private void traverse(TreeNode root, Integer tempSum, LinkedList<Integer> nodeValList) {
    int val = root.val;
    nodeValList.add(val);
    tempSum += val;

    if (root.left == null && root.right == null) {
      if (tempSum == target) {
        result.add(new ArrayList<>(nodeValList));
      }
      nodeValList.removeLast();
      tempSum -= val;
      return;
    }

    if (root.left != null) {
      traverse(root.left, tempSum, nodeValList);
    }

    if (root.right != null) {
      traverse(root.right, tempSum, nodeValList);
    }

    tempSum -= val;
    if(!nodeValList.isEmpty()) {
      nodeValList.removeLast();
    }
  }

}
