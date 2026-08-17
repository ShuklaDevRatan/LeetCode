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
    public ListNode rotateRight(ListNode head, int k) {

        // 1. Find length
        ListNode len = head;
        int count = 0;

        if (head == null || head.next == null) {
            return head;
        }

        while (len != null) {
            len = len.next;
            count++;
        }

        // 2. Reduce k
        k = k % count;

        if (k == 0) {
            return head;
        }

        // 3. Reverse the entire list
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode temp = curr.next;

            curr.next = prev;

            prev = curr;
            curr = temp;
        }

        head = prev;

        // 4. Reverse first k nodes
        prev = null;
        curr = head;
        int i = 0;

        ListNode firstPartTail = head;

        while (curr != null && i < k) {
            ListNode temp = curr.next;

            curr.next = prev;

            prev = curr;
            curr = temp;

            i++;
        }

        // 5. Reverse remaining nodes
        ListNode secondPrev = null;
        ListNode secondCurr = curr;

        while (secondCurr != null) {
            ListNode temp = secondCurr.next;

            secondCurr.next = secondPrev;

            secondPrev = secondCurr;
            secondCurr = temp;
        }

        // 6. Connect both parts
        firstPartTail.next = secondPrev;

        return prev;
    }
}