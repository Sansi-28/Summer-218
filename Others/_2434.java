package Others;
import java.util.*;
public class _2434 {
        public String robotWithString(String s) {
            int n = s.length();
            int[] freq = new int[26];


            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                freq[c - 'a']++;
            }

            StringBuilder result = new StringBuilder();
            Deque<Character> stack = new ArrayDeque<>();

            int minChar = 0;

            for (int i = 0; i < n; i++) {
                char c = s.charAt(i);
                stack.push(c);
                freq[c - 'a']--;


                while (minChar < 26 && freq[minChar] == 0) {
                    minChar++;
                }


                while (!stack.isEmpty() && (stack.peek() - 'a') <= minChar) {
                    result.append(stack.pop());
                }
            }


            while (!stack.isEmpty()) {
                result.append(stack.pop());
            }

            return result.toString();
        }

}

class Test_2434{
    public static void main(String[] args) {
        _2434 solution = new _2434();
//         Input: s = "zza"
//Output: "azz"
        String s = "zza";
        System.out.println(solution.robotWithString(s));
    }
}
