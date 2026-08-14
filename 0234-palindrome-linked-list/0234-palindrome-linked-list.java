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
    public boolean isPalindrome(ListNode head) {

        // 1. Find the middle
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. Reverse the second half
        ListNode secondHalf = reverseList(slow);

        // 3. Compare first half and reversed second half
        ListNode firstHalf = head;
        ListNode temp = secondHalf;

        boolean result = true;

        while (temp != null) {
            if (firstHalf.val != temp.val) {
                result = false;
                break;
            }

            firstHalf = firstHalf.next;
            temp = temp.next;
        }

        // 4. Restore the linked list
        reverseList(secondHalf);

        return result;
    }

    private ListNode reverseList(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode temp = curr.next;

            curr.next = prev;

            prev = curr;
            curr = temp;
        }

        return prev;
    }
}