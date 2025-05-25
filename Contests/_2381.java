package Contests;

public class _2381 {
    public String shiftingLetters(String s, int[][] shifts) {

            int [] diff = new int [s.length() + 1];

            for (int[] arr : shifts) {
                int st = arr[0], end = arr[1], dir = arr[2];
                if (dir == 0) {
                    diff[st] = diff[st] - 1;
                    diff[end + 1] = diff[end + 1] + 1;
                } else {
                    diff[st] = diff[st] + 1;
                    diff[end + 1] = diff[end + 1] -1;
                }
            }
            int sum = 0;
            for(int e = 0; e < diff.length; e++){
                sum = sum + diff[e];
                diff[e] = sum;

            }

            StringBuilder sb = new StringBuilder();
            for (int e = 0; e < s.length(); e++) {
                int shift = diff[e] % 26;
                if (shift < 0) shift += 26;

                char c = (char)((s.charAt(e) - 'a' + shift) % 26 + 'a');
                sb.append(c);
            }

            return sb.toString();
        }
}
class Test_2381{
    public static void main(String[] args) {
        _2381 solution = new _2381();
//        Input: s = "abc", shifts = [[0,1,0],[1,2,1],[0,2,1]]
//Output: "ace"
        int [][] shifts = {
            {0, 1, 0}, {1, 2, 1}, {0, 2, 1}
        };
        String s = "abc";
        System.out.println(solution.shiftingLetters(s, shifts));
    }
}
