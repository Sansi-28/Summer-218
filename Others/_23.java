package Others;
import java.util.*;

  /*Definition for singly-linked list.*/
class ListNode {
      int val;
      ListNode next;
           ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

public class _23 {
        public ListNode mergeKLists(ListNode[] lists) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();

            for(ListNode node : lists){
                ListNode curr = node;
                while(curr != null){
                    pq.offer(curr.val);
                    curr = curr.next;
                }
            }
            ListNode root = new ListNode(-1,null);
            root.next = null;
            ListNode curr = root;
            while(!pq.isEmpty()){
                ListNode temp = new ListNode(pq.poll(), null);
                curr.next = temp;
                curr = curr.next;
            }

            return root.next;
        }
}

class Test_23{
    public static void main(String[] args) {
//        Input: lists = [[1,4,5],[1,3,4],[2,6]]
//Output: [1,1,2,3,4,4,5,6]
        
    }
}
