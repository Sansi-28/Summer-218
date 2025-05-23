package DP;
import java.util.*;
public class _139 {
        private final HashMap<Integer, Boolean> memo = new HashMap<>();
        public boolean wordBreak(String s, List<String> wordDict) {
            Set<String> hs = new HashSet<>(wordDict);
            char [] charArray = s.toCharArray();
            StringBuilder sb = new StringBuilder();
            return helper(charArray, hs, 0, memo);

        }

        private boolean helper(char[] charArray, Set<String> hs, int st, Map<Integer, Boolean> memo) {
            if (st == charArray.length) return true;

            if (memo.containsKey(st)) return memo.get(st);

            StringBuilder current = new StringBuilder();
            for (int i = st; i < charArray.length; i++) {
                current.append(charArray[i]);
                if (hs.contains(current.toString())) {
                    if (helper(charArray, hs, i + 1, memo)) {
                        memo.put(st, true);
                        return true;
                    }
                }
            }

            memo.put(st, false);
            return false;
        }
}

class Test_139{
    public static void main(String[] args) {
        _139 solution = new _139();
        String s = s = "catsandog";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("cats");
        wordDict.add("dog");
        wordDict.add("sand");
        wordDict.add("and");
        wordDict.add("cat");
        System.out.println(solution.wordBreak(s, wordDict));
    }
}
