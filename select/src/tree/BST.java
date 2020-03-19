package tree;

public class BST<Key extends Comparable<Key>, Value> {

  private Node root;

  private class Node {

    private Key key;
    private Value value;
    private Node left, right;
    private int N;

    public Node(Key key, Value val, int N) {
      this.key = key;
      this.value = val;
      this.N = N;
    }
  }

  public int size() {
    return size(root);
  }

  private int size(Node node) {
    return node == null ? 0 : node.N;
  }

  public Node get(Key key) {
    return get(root, key);
  }

  private Node get(Node node, Key key) {
    if (node == null) {
      return null;
    }

    int compareTo = key.compareTo(node.key);
    if (compareTo > 0) {
      return get(node.right, key);
    } else if (compareTo < 0) {
      return get(node.left, key);
    } else {
      return node;
    }
  }

  public void put(Key key, Value value) {
    root = put(root, key, value);
  }

  // 遇到小于key的节点，选择右子树，遇到大于key的节点，选择左子树。遇到相等的则替换
  // 更新N的值
  private Node put(Node node, Key key, Value value) {
    if (node == null) {
      return new Node(key, value, 1);
    }
    int compareTo = key.compareTo(node.key);
    if (compareTo > 0) {
      node.right = put(node.right, key, value);
    } else if (compareTo < 0) {
      node.left = put(node.left, key, value);
    } else {
      node.value = value;
    }

    node.N = size(node.left) + size(node.right) + 1;

    return node;
  }

  public Value max() {
    return max(root);
  }

  private Value max(Node node) {
    if (node == null) {
      return null;
    }

    if (node.right == null) {
      return node.value;
    } else {
      return max(node.right);
    }
  }

  private Value min() {
    return min(root);
  }

  private Value min(Node node) {
    if (node == null) {
      return null;
    }

    if (node.left == null) {
      return node.value;
    } else {
      return min(node.left);
    }
  }

  // 获取二叉树中顺序排序，顺序为K的节点的值（0, 1, 2, 3 ... k）
  public Value select(int k) {
    return select(root, k).value;
  }

  public Node select(Node node, int k) {
    if (node == null) {
      return null;
    }

    int t = size(node.left);
    if (k == t) {
      return node;
    } else if (t > k) {
      return select(node.left, k);
    } else {
      return select(node.right, k - t - 1);
    }

  }

  public static void main(String[] args) {
    BST<Integer, Integer> bst = new BST<>();
    bst.put(1, 1);
    bst.put(2, 2);
    bst.put(3, 3);
    bst.put(4, 4);
    bst.put(4, 4);
    System.out.println(bst.max());
    System.out.println(bst.min());
    System.out.println(bst.select(1));
  }
}
