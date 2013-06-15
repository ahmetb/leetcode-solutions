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
    public static class MyComparator implements Comparator<ListNode> {
        public int compare(ListNode n1, ListNode n2){
            return n1.val - n2.val;
        }
    }
    
    // o(nlogk)
    // Merge k Sorted Lists
    // http://leetcode.com/onlinejudge#question_23
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if (lists == null || lists.isEmpty()) return null;
        
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.size(), new MyComparator());
        for(ListNode n : lists)
            if (n != null) pq.add(n);
            
        ListNode head = null, prev = null;
        
        while(!pq.isEmpty()){
            ListNode node = pq.poll();
            
            if (node.next != null) pq.offer(node.next);
            
            if (head == null) head = node;
            else prev.next = node;
            
            prev = node;
        }
        
        return head;
    }
}