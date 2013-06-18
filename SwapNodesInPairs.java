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
    // http://leetcode.com/onlinejudge#question_24
    public ListNode swapPairs(ListNode head) {
         if (head == null || head.next == null) return head;
         
         ListNode next = head.next;
         
         head.next = next.next;
         next.next = head;
         head = next;
         
         head.next.next = swapPairs(head.next.next);
         return head;
    }
}