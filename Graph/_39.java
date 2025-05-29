package Graph;
import java.util.*;
public class _39 {
        Set<List<Integer>> ans = new HashSet<>();

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<Integer> temp = new ArrayList<>();
            List<List<Integer>> req = new ArrayList<>();
            helper(candidates, target, 0, temp, 0);
            req.addAll(ans);
            return req;
        }

        private void helper(int[] candidates, int target, int sum, List<Integer> temp, int indx) {
            if (sum > target) return;
            if (sum == target) {
                ans.add(new ArrayList<>(temp));
                return;
            }

            for (int i = indx; i < candidates.length; i++) {
                temp.add(candidates[i]);
                helper(candidates, target, sum + candidates[i], temp, i);
                temp.remove(temp.size() - 1);
            }
        }
}
class Test_39{
    public static void main(String[] args) {
        _39 solution = new _39();
//        Input: candidates = [2,3,6,7], target = 7
        int [] candidates = {2, 3, 6, 7};
        int target = 7;
        System.out.println(solution.combinationSum(candidates, target));
    }
}
