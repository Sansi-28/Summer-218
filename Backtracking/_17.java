package Backtracking;
import org.w3c.dom.ls.LSOutput;

import java.util.*;
public class _17 {
        List<String> ans = new ArrayList<>();
        public List<String> letterCombinations(String digits) {
            if (digits == null || digits.isEmpty()) {
                return ans;
            }
            Map<Integer, String> mp = new HashMap<>();
            mp.put(2, "abc");
            mp.put(3, "def");
            mp.put(4, "ghi");
            mp.put(5, "jkl");
            mp.put(6, "mno");
            mp.put(7, "pqrs");
            mp.put(8, "tuv");
            mp.put(9, "wxyz");
            helper(digits, "", mp);
            return ans;
        }

        private void helper(String digits, String str, Map<Integer, String> mp ){
            if(str.length() == digits.length()){
                ans.add(str);
                return;
            }

            String letters =  mp.get(Character.getNumericValue(digits.charAt(str.length())));

            for(char c : letters.toCharArray()){
                helper(digits, str + c, mp );
            }
            return;
        }
}

class Test_17{
    public static void main(String[] args) {
        _17 solution = new _17();
        String digits = "23";
        System.out.println(solution.letterCombinations(digits));
    }

}
