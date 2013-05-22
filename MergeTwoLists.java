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
    // Merge Two Sorted Lists
    // http://leetcode.com/onlinejudge#question_21
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null, prev = null;
        int i = 0;
        while(l1 != null || l2 != null){
            ListNode smaller = (l1 == null) ? l2 : (l2 == null ? l1 : (l1.val<l2.val ? l1 : l2));
            
            if (i == 0)
                head = smaller;
            else {
                prev.next = smaller;
            }
            
            if (smaller == l1) l1 = l1.next;
            if (smaller == l2) l2 = l2.next;
            prev = smaller;
            
            i++;
        }
        return head;
    }
}