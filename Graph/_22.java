package Graph;
import java.util.*;
public class _22 {
        public List<String> generateParenthesis(int n) {
            List<String> result = new ArrayList<>();
            backtrack(result, new StringBuilder(), 0, 0, n);
            return result;
        }

        private void backtrack(List<String> result, StringBuilder sb, int open, int close, int max) {
            if (sb.length() == max * 2) {
                result.add(sb.toString());
                return;
            }

            if (open < max) {
                sb.append('(');
                backtrack(result, sb, open + 1, close, max);
                sb.deleteCharAt(sb.length() - 1);  // Backtrack
            }

            if (close < open) {
                sb.append(')');
                backtrack(result, sb, open, close + 1, max);
                sb.deleteCharAt(sb.length() - 1);  // Backtrack
            }
        }

}

class Test_22{
    public static void main(String[] args) {
        _22 solution = new _22();
        int n = 3;
        System.out.println(solution.generateParenthesis(n));
    }
}
