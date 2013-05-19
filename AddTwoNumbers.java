
public class Solution {

    // Add Two Numbers
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sum = null, head = null;
        int c = 0;
        
        ListNode cur1 = l1, cur2 =l2;
        
        while (!(cur1 == null && cur2 == null)){
            int d1 = 0, d2 = 0;
            
            if (cur1 != null){
                d1 = cur1.val;
                cur1 = cur1.next;
            }
            
            if (cur2 != null){
                d2 = cur2.val;
                cur2 = cur2.next;
            }
            
            int add = (d1+d2+c);
            c = add/10;
            ListNode digit = new ListNode(add % 10);
            
            if (sum == null){
                sum = digit;
                head = digit;
            } 
            else {
                sum.next = digit;
                sum = sum.next;
            }
        }
        
        if (c != 0){
            sum.next = new ListNode(c);
        }
        
        return head;
    }
}