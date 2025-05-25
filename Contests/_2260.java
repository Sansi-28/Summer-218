package Contests;
import java.util.*;
public class _2260 {
        public int minimumCardPickup(int[] cards) {
            Map<Integer, Integer> mp = new HashMap<>();
            int st = 0, end = 0, min = Integer.MAX_VALUE;
            boolean flag = false;
            for(int i = 0; i < cards.length; i++){
                if(mp.containsKey(cards[i])){
                    st = mp.get(cards[i]);
                    end = i;
                    if(end - st + 1 < min){
                        min = end - st + 1;
                    }
                }
                mp.put(cards[i], i);
            }

            if(min != Integer.MAX_VALUE){
                return min;
            }
            return -1;
        }
}

class Test_2260{
    public static void main(String[] args) {
        _2260 solution = new _2260();
//        Input: cards = [3,4,2,3,4,7]
//Output: 4
        int [] cards = {3, 4, 2, 3, 4, 7};
        System.out.println(solution.minimumCardPickup(cards));
    }
}
