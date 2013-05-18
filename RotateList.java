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

    // Rotate List
    // http://leetcode.com/onlinejudge#question_61
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) return head;
        ListNode cur = head, prev = null;
        
        int n = 0;
        while (cur != null){
            n++;
            prev = cur;
            cur = cur.next;
        }
        prev.next = head;
        
        int m = (n - (k%n)); // avoid redundant cycles
        cur = prev;
        
        while (m > 0){
            m--;
            prev = cur;
            cur = cur.next;
        }


        ListNode retVal = cur.next;
        cur.next = null;
        return retVal;
    }
}