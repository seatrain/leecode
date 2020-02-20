/**
 * leecode-215-数组中的第K个最大元素
 */
public class KthLargestElementInAnArray {

  class MaxKElements {

    private int[] elements;
    private int n;

    public MaxKElements(int initCapacity) {
      elements = new int[initCapacity + 1];
      n = 0;
    }

    public void insert(int element) {
      elements[++n] = element;
      swim(n);
    }

    private void swim(int k) {
      while (k > 1 && less(k / 2, k)) {
        swap(k, k / 2);
        k = k / 2;
      }
    }

    private boolean less(int i, int j) {
      return elements[i] < elements[j];
    }

    private void swap(int i, int j) {
      int swap = elements[i];
      elements[i] = elements[j];
      elements[j] = swap;
    }
  }

  public int findKthLargest(int[] nums, int k) {

  }
}
