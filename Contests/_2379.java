package Contests;
import java.util.*;
public class _2379 {
        public int minimumRecolors(String blocks, int k) {
            int st = 0, end = 0, W = 0, min = Integer.MAX_VALUE;
            for(int i = 0; i < k ; i++){
                if(blocks.charAt(i) == 'W')W++;
            }
            end = k-1;
            min = W;

            for(int i = end + 1; i < blocks.length() ; i++){
                if(blocks.charAt(i) == 'W')W++;
                if(blocks.charAt(st++) == 'W')W--;
                if(W < min)min = W;
            }

            return min;
        }

}
class Test_2379{
    public static void main(String[] args) {
//        Input: blocks = "WBBWWBBWBW", k = 7
//Output: 3
        _2379 solution = new _2379();
        String blocks =  "WBBWWBBWBW";
        int k = 7;
        System.out.println(solution.minimumRecolors(blocks, k));
    }
}