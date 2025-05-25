package Contests;
import java.util.*;
public class _2262 {
    /*
    * The core idea of the solution is to reverse the typical approach
    * of examining all substrings and instead focus on the contribution
    * of each character to the total appeal across all substrings.
    * For every character in the string, we determine how many substrings
    * it uniquely contributes to as a distinct character by tracking its
    * last occurrence. Specifically, for a character at index `i`, the number
    * of substrings in which it is counted as a new distinct character is the product
    * of the number of valid start positions (`i - lastSeen[c]`) and the number
    * of valid end positions (`n - i`). This shift in perspective—from evaluating
    * substrings to evaluating character contributions—allows us to compute
    * the total appeal in linear time, avoiding the inefficiency of a brute-force approach.
     */
        public long appealSum(String s) {
            long totalAppeal = 0;
            int[] lastSeen = new int[26];
            int n = s.length();

            Arrays.fill(lastSeen, -1);

            for (int i = 0; i < n; i++) {
                int ch = s.charAt(i) - 'a';
                totalAppeal += (i - lastSeen[ch]) * (long) (n - i);
                lastSeen[ch] = i;
            }

            return totalAppeal;
        }
}
class Test_2262{
    public static void main(String[] args) {
        _2262 solution = new _2262();
        String s = "abbca";
        System.out.println(solution.appealSum(s));
    }
}
