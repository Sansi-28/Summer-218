package Graph;
import java.util.*;
public class _127 {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            Set<String> wordSet = new HashSet<>(wordList);
            if (!wordSet.contains(endWord)) return 0;


            wordSet.add(beginWord);


            Map<String, List<String>> graph = new HashMap<>();
            for (String word1 : wordSet) {
                graph.putIfAbsent(word1, new ArrayList<>());
                for (String word2 : wordSet) {
                    if (!word1.equals(word2) && diff(word1, word2) == 1) {
                        graph.get(word1).add(word2);
                    }
                }
            }


            Queue<String> queue = new LinkedList<>();
            Set<String> visited = new HashSet<>();

            queue.offer(beginWord);
            visited.add(beginWord);
            int level = 1;

            while (!queue.isEmpty()) {
                int size = queue.size();
                while (size-- > 0) {
                    String curr = queue.poll();
                    if (curr.equals(endWord)) return level;

                    for (String neighbor : graph.getOrDefault(curr, new ArrayList<>())) {
                        if (!visited.contains(neighbor)) {
                            visited.add(neighbor);
                            queue.offer(neighbor);
                        }
                    }
                }
                level++;
            }

            return 0;
        }

        private int diff(String s1, String s2) {
            int count = 0;
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) != s2.charAt(i)) count++;
            }
            return count;
        }
}

class Test_127{
    public static void main(String[] args) {
        _127 solution = new _127();
//        Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
        String beginWord = "hit";
        String endWord = "cog";
//        String [] list = {"hot","dot","dog","lot","log","cog"};
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");

        System.out.println(solution.ladderLength(beginWord, endWord, wordList));
    }
}
