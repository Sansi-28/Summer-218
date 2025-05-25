package Contests;
import java.util.*;
public class _2261 {
        public int countDistinct(int[] nums, int k, int p) {
            Set<String> set = new HashSet<>();
            int n = nums.length;

            for (int i = 0; i < n; i++) {
                int count = 0;
                StringBuilder sb = new StringBuilder();

                for (int j = i; j < n; j++) {
                    if (nums[j] % p == 0) {
                        count++;
                    }

                    if (count > k) {
                        break;
                    }

                    sb.append(nums[j]).append(",");
                    set.add(sb.toString());
                }
            }

            return set.size();
        }
}
class Test_2261{
    public static void main(String[] args) {
        _2261 solution = new _2261();
//        Input: nums = [2,3,3,2,2], k = 2, p = 2
        int [] nums = {2, 3, 3, 2, 2};
        int k = 2;
        int p = 2;
        System.out.println(solution.countDistinct(nums, k, p));
    }
}
