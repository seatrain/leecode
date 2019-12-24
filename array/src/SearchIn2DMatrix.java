/**
 * leecode-74
 */
public class SearchIn2DMatrix {

  public boolean searchMatrix(int[][] matrix, int target) {
    boolean found = false;

    if (matrix != null && matrix.length > 0) {
      int row = 0;
      int column = matrix[0].length - 1;

      while (row < matrix.length && column >= 0) {
        if (matrix[row][column] == target) {
          found = true;
          break;
        } else if (matrix[row][column] > target) {
          column--;
        } else {
          row++;
        }
      }
    }
    return found;
  }

  public static void main(String[] args) {
    int[][] matrix = new int[][]{
        {1, 3, 5, 7},
        {10, 11, 16, 20},
        {23, 30, 34, 50}
    };
    SearchIn2DMatrix searchIn2DMatrix = new SearchIn2DMatrix();
    System.out.println(searchIn2DMatrix.searchMatrix(matrix, 11));
  }
}
