/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy=new ListNode(0,head);
        ListNode slow= dummy;
        ListNode fast=dummy;
        //now fast stand at n+1 postion 
        for(int i=0;i<=n;i++){
            fast=fast.next;
        }
        while(fast!=null){
            slow =slow.next;
            fast=fast.next;
        }
        slow.next=slow.next.next;
        return dummy.next;
    }
}