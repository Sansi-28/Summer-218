package DP;

public class _97 {
        public boolean isInterleave(String s1, String s2, String s3) {
            if(s1.length() + s2.length() != s3.length()) return false;
            return helper(s1, s2, s3, 0, 0, 0, new Boolean[s1.length()+1][s2.length()+1]);
        }

        private boolean helper(String s1, String s2, String s3, int i, int j, int k, Boolean[][] memo) {
            if (k == s3.length()) return true;
            if (memo[i][j] != null) return memo[i][j];

            boolean valid = false;
            if (i < s1.length() && s1.charAt(i) == s3.charAt(k))
                valid = valid || helper(s1, s2, s3, i+1, j, k+1, memo);
            if (j < s2.length() && s2.charAt(j) == s3.charAt(k))
                valid = valid ||  helper(s1, s2, s3, i, j+1, k+1, memo);

            return memo[i][j] = valid;
        }
}

class Test_97{
    public static void main(String[] args) {
        _97 solution = new _97();
//        Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
//Output: true
        String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";
        System.out.println(solution.isInterleave(s1, s2, s3));
    }
}
