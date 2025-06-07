package Others;
import java.util.*;
public class _3556 {
        public long sumOfLargestPrimes(String s) {
            int n = s.length();
            TreeSet<Long> primes = new TreeSet<>();

            for (int i = 0; i < n; i++) {
                for (int j = i; j < Math.min(n, i + 12); j++) {
                    String str = s.substring(i, j + 1);
                    long num = Long.parseLong(str);

                    if (isPrime(num)) {
                        primes.add(num);
                        if (primes.size() > 3) {
                            primes.pollFirst();
                        }
                    }
                }
            }

            long sum = 0;
            for (long prime : primes) {
                sum += prime;
            }

            return sum;
        }

        private boolean isPrime(long n) {
            if (n <= 1)
                return false;
            if (n == 2 || n == 3)
                return true;
            if (n % 2 == 0 || n % 3 == 0)
                return false;
            for (long i = 5; i * i <= n; i += 6) {
                if (n % i == 0 || n % (i + 2) == 0)
                    return false;
            }
            return true;
        }

}
class Test_3556{
    public static void main(String[] args) {
        _3556 solution = new _3556();
//        Input: s = "12234"
//
//Output: 1469
        String s = "12234";
        System.out.println(solution.sumOfLargestPrimes(s));
    }
}
