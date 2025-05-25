package Contests;

public class _2380 {
        public int secondsToRemoveOccurrences(String s) {
            char[] charArr = s.toCharArray();
            int count = 1, ans = 0, i;

            while (count != 0) {
                i = 0;
                count = 0;

                while (i < charArr.length - 1) {
                    if (charArr[i] == '0' && charArr[i + 1] == '1') {

                        charArr[i] = '1';
                        charArr[i + 1] = '0';
                        count++;
                        i += 2;
                    } else {
                        i++;
                    }
                }

                if (count > 0) {
                    ans++;
                }
            }

            return ans;
        }
}

class Test_2380{
    public static void main(String[] args) {
        _2380 solution =  new _2380();
//        Input: s = "0110101"
//        Output: 4
        String s =  "0110101";
        System.out.println(solution.secondsToRemoveOccurrences(s));
    }
}
