import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树中序遍历，leecode-94，链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 */
public class BinaryTreeInorderTraversal {

  public static class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public static List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> result = new LinkedList<>();
    if(root != null) {
      inorderTraversal(root, result);
    }
    return result;
  }

  private static void inorderTraversal(TreeNode root, List<Integer> result) {
    if (root.left != null) {
      inorderTraversal(root.left, result);
    }

    result.add(root.val);

    if (root.right != null) {
      inorderTraversal(root.right, result);
    }

  }

  public static void main(String[] args) {
    TreeNode treeNode1 = new TreeNode(1);
    TreeNode treeNode2 = new TreeNode(2);
    TreeNode treeNode3 = new TreeNode(3);

    treeNode1.right = treeNode2;
    treeNode2.left = treeNode3;

    List<Integer> integerList = inorderTraversal(treeNode1);

    integerList.forEach(
        System.out::println
    );
  }
}
