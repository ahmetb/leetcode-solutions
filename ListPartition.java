
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {

    // List Partition
    // http://leetcode.com/onlinejudge#question_86
    public ListNode partition(ListNode head, int x) {
        ListNode cur = head, prev = null, next = null;
        ListNode FS = null, LS = null, FB = null, LB = null;
                    
        while (cur != null){
            next = cur.next;
            
            ListNode f = null, l = null;

            if (cur.val < x){
                if (LS == null)
                    FS = cur;
                else {
                    ListNode tmp = LS.next;
                    if (tmp != cur){
                        LS.next = cur;
                        cur.next = tmp;    
                    }
                }
                LS = cur;
                LS.next = null;
            } else { // >= x
                if (LB == null)
                    FB = cur;
                else {
                    ListNode tmp = LB.next;
                    if (tmp != cur){
                        LB.next = cur;
                        cur.next = tmp;    
                    }
                }
                LB = cur;
                LB.next = null;
            }

            prev = cur;
            cur = next;
        }
        
        // arrange LastSmaller->FirstBigger
        if (LS != null) LS.next = FB;
        return FS != null ? FS : FB;
    }

}