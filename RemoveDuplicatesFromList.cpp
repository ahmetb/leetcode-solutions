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
    // Remove Duplicates from Sorted List
    ListNode *deleteDuplicates(ListNode *head) {
        bool prevSet = false;
        ListNode* prev;
        ListNode* cur = head;
        
        while(cur != NULL){
            ListNode* next = cur->next;
            
            if (prevSet && cur->val == prev->val){
                ListNode* tmp = prev->next;
                prev->next = next;
            } else {
                prev = cur;
                prevSet = true;    
            }
            cur = next;
        }
        return head;
    }
};