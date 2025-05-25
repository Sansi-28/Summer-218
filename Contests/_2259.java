package Contests;

public class _2259 {
        public String removeDigit(String number, char digit) {
            char [] charArray = number.toCharArray();
            boolean flag = false;
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < number.length() ; i++ ){
                if(i <  number.length()-1 && charArray[i] < charArray[i + 1] && charArray[i] == digit && !flag){
                    flag = true;
                    continue;
                }
                sb.append(charArray[i]);
            }
            StringBuilder bs = new StringBuilder();
            if(sb.length() == number.length()){
                for(int i = number.length() - 1; i >= 0; i-- ){
                    if(charArray[i] == digit && !flag){
                        flag = true;
                        continue;
                    }
                    bs.append(charArray[i]);
                }
                bs.reverse();
                return bs.toString();

            }

            return sb.toString();

        }
}
class Test_2259{
    public static void main(String[] args) {
        String str = "123";
        char c = '3';
        _2259 solution = new _2259();
        System.out.println(solution.removeDigit(str, c));
    }
}
