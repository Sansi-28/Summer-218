package Daily_Questions;

public class _2894 {
        public int differenceOfSums(int n, int m) {
            int i = 1, num1 = 0, num2 = 0;
            while(i <= n){
                if(i%m != 0){
                    num1 = num1 + i;
                }
                i++;
            }
            return 2*num1 - (n*(n+1)/2);
        }
}
class Test_2894{
    public static void main(String[] args) {
        int n = 10, m =3;
        _2894 solution = new _2894();
        System.out.println(solution.differenceOfSums(n,m));
    }
}
