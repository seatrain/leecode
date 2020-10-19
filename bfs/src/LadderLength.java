//给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
//
//
//
// 每次转换只能改变一个字母。
// 转换过程中的中间单词必须是字典中的单词。
//
//
// 说明:
//
//
// 如果不存在这样的转换序列，返回 0。
// 所有单词具有相同的长度。
// 所有单词只由小写字母组成。
// 字典中不存在重复的单词。
// 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
//
//
// 示例 1:
//
// 输入:
//beginWord = "hit",
//endWord = "cog",
//wordList = ["hot","dot","dog","lot","log","cog"]
//
//输出: 5
//
//解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
//     返回它的长度 5。
//
//
// 示例 2:
//
// 输入:
//beginWord = "hit"
//endWord = "cog"
//wordList = ["hot","dot","dog","lot","log"]
//
//输出: 0
//
//解释: endWord "cog" 不在字典中，所以无法进行转换。
// Related Topics 广度优先搜索
// 👍 472 👎 0

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * 单词接龙-127
 *
 * @author seatrain
 * @version 1.0
 * @date 2020/10/14 10:05
 */
public class LadderLength {

  private String endWord;

  private Map<String, LinkedList<String>> dict = new HashMap<>();

  // 将列表中的单词组成一棵多叉树，父节点为beginWord，叶节点为endWord，查找从beginWord到endWord的最短路径
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    if (!wordList.contains(endWord)) {
      return 0;
    }

    this.endWord = endWord;
    int minDepth = 1;
    Queue<String> queue = new LinkedList<>();
    queue.add(beginWord);

    formatDict(wordList);

    HashSet<String> hasVisitedList = new HashSet<>();
    hasVisitedList.add(beginWord);
    boolean flag = true;
    while (flag) {
      flag = false;
      int queueSize = queue.size();
      for (int i = 0; i < queueSize; i++) {
        String parent = queue.remove();
        for (int j = 0; j < parent.length(); j++) {
          String key = parent.substring(0, j) + "*" + parent.substring(j + 1);
          LinkedList<String> children = dict.get(key);
          if (children != null) {
            if (children.contains(endWord)) {
              minDepth += 1;
              return minDepth;
            } else {
              for (String child : children) {
                if (!hasVisitedList.contains(child)) {
                  hasVisitedList.add(child);
                  queue.offer(child);
                  flag = true;
                }
              }
            }
          }
        }

      }
      minDepth += 1;
    }

    return 0;
  }

  private void formatDict(List<String> wordList) {
    for (String word : wordList) {
      for (int i = 0; i < word.length(); i++) {
        String key = word.substring(0, i) + "*" + word.substring(i + 1);
        LinkedList<String> value = dict.getOrDefault(key, new LinkedList<>());
        value.offer(word);
        dict.put(key, value);
      }
    }
  }

}
