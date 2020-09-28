//编写一个算法来判断一个数 n 是不是快乐数。
//
// 「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
//如果 可以变为 1，那么这个数就是快乐数。
//
// 如果 n 是快乐数就返回 True ；不是，则返回 False 。
//
//
//
// 示例：
//
// 输入：19
//输出：true
//解释：
//1 + 81 = 82
//64 + 4 = 68
//36 + 64 = 100
//1 + 0 + 0 = 1
//

/**
 * 快乐数-leetcode-202
 *
 * @author longsb3
 * @version 1.0
 * @date 2020/09/17 10:45
 */
public class IsHappy {

  public static int next(int n) {
    int sum = 0;

    while (n > 0) {
      int mod = n % 10;
      sum += mod * mod;
      n = n / 10;
    }

    return sum;
  }

  public static boolean isHappy(int n) {
    int slow = n;
    int fast = next(n);

    while (fast == 1 && fast != slow) {
      slow = next(slow);
      fast = next(next(fast));
    }

    return fast == 1;
  }

  public static void main(String[] args) {
    int n = 19;

    System.out.println(isHappy(n));
  }
}
