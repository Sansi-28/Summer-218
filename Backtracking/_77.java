package Backtracking;
import java.util.*;
public class _77 {
        List<List<Integer>> ans = new ArrayList<>();

        public List<List<Integer>> combine(int n, int k) {
            helper(1, n, k, new ArrayList<>());
            return ans;
        }

        private void helper(int start, int n, int k, List<Integer> temp) {
            if (temp.size() == k) {
                ans.add(new ArrayList<>(temp));
                return;
            }

            for (int i = start; i <= n; i++) {
                temp.add(i);
                helper(i + 1, n, k, temp);
                temp.remove(temp.size() - 1);
            }
        }
}
class Test_77{
    public static void main(String[] args) {
        _77 solution = new _77();

        System.out.println(solution.combine(4,2));
    }
}
