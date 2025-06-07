package Contests;
import java.util.*;
public class _3566 {


        public boolean checkEqualPartitions(int[] nums, long target) {
            int n = nums.length;
            int totalMasks = 1 << n;

            // Store subset masks that have product == target
            List<Integer> validMasks = new ArrayList<>();

            // Generate all valid subset masks
            for (int mask = 1; mask < totalMasks - 1; mask++) {
                long product = 1L;
                boolean valid = true;

                for (int i = 0; i < n; i++) {
                    if ((mask & (1 << i)) != 0) {
                        product *= nums[i];
                        // Early pruning
                        if (product > target || target % product != 0) {
                            valid = false;
                            break;
                        }
                    }
                }

                if (valid && product == target) {
                    validMasks.add(mask);
                }
            }

            // Try all pairs of disjoint valid masks that together cover the whole set
            int fullMask = (1 << n) - 1;
            int sz = validMasks.size();
            for (int i = 0; i < sz; i++) {
                for (int j = i + 1; j < sz; j++) {
                    int m1 = validMasks.get(i);
                    int m2 = validMasks.get(j);
                    if ((m1 & m2) == 0 && (m1 | m2) == fullMask) {
                        return true;
                    }
                }
            }

            return false;
        }
}

class Test_3566{
    public static void main(String[] args) {
        _3566 solution = new _3566();
//        Input: nums = [3,1,6,8,4], target = 24
//
//Output: true
        int[] nums = { 3,1,6,8,4 };
        int target = 24;
        System.out.println(solution.checkEqualPartitions(nums, target));
    }
}
