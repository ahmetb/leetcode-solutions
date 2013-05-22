/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:

    // Remove Nth Node From End of List
    // http://leetcode.com/onlinejudge#question_19
    ListNode *removeNthFromEnd(ListNode *head, int n) {
        int i = 0;
        ListNode *back, *forward = head, *prev = NULL;
        
        while(forward){
            i++;
            forward = forward->next;
            
            if (i == n){
                back = head;
            } else if (i > n){
                prev = back;
                back = back->next;
            }
        }
        
        if (prev)
            prev->next = back->next;
        else {
            head = back->next;
        }
        
        delete back;
        
        return head;
    }
};