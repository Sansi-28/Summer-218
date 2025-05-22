package DP;
import java.util.*;
public class _983 {
        private int [] mem;

        public int mincostTickets(int[] days, int[] costs) {
            mem = new int[days.length];
            Arrays.fill(mem, -1);
            return helper (days, costs, 0);
        }

        private int helper(int [] days, int [] costs, int st){

            int n = days.length;

            if(st >= n)return 0;

            if(mem[st] != -1){
                return mem[st];
            }

            int min = Integer.MAX_VALUE;

            for(int i = 0; i < 3; i++){

                int temp = st;

                if(i == 0){

                    temp = st + 1;

                    int m = helper(days, costs, temp);

                    if(min > m + costs[0])min = m + costs[0];

                }else if(i == 1){

                    while(temp < n && days[temp] < days[st] + 7)temp++;

                    int m = helper(days, costs, temp);

                    if(min > m + costs[1])min = m + costs[1];

                }else{

                    while(temp < n && days[temp] < days[st] + 30)temp++;

                    int m = helper(days, costs, temp);

                    if(min > m + costs[2])min = m + costs[2];

                }
            }

            mem[st] = min;

            return min;
    }
}

class Test_983{
    public static void main(String[] args) {
        _983 solution = new _983();

        int [] days = {1, 4, 6, 7, 8, 20};
        int [] costs = {2, 7, 15};

        System.out.println(solution.mincostTickets(days, costs));
    }
}
