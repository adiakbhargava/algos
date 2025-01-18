package linkedlists;

public class PalindromicLinkedList {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(1);
        printLinkedList(head);
        System.out.println((new PalindromicLinkedList()).isPalindrome(head));

        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(3);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(2);
        printLinkedList(head1);
        System.out.println((new PalindromicLinkedList()).isPalindrome(head1));

        ListNode head2 = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);
        printLinkedList(head);
        System.out.println((new PalindromicLinkedList()).isPalindrome(head));
    }

    private boolean isPalindrome(ListNode head){
        // get midpoint of list
        ListNode midPoint = findMidPoint(head);
        // reverse the second half of list
        ListNode reversedHead = reverseList(midPoint);
        // have pointer at beginning of first half of list
        ListNode ptr1 = head;
        // have pointer at beginning of first half of reversed list
        ListNode ptr2 = reversedHead;

        // iterate through both lists until ptr2 is null
        // we choose ptr2 as it only comprises the second half of the original list, so it is shorter
        while(ptr2 != null){
            if(ptr1.val != ptr2.val){
                return false;
            }
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        return true;
    }

    private ListNode reverseList(ListNode head){
        ListNode curr = head;
        ListNode prev = null;

        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    private ListNode findMidPoint(ListNode head){
        // declare and initialize fast and slow node (fast node will move double the slow node)
        ListNode fast = head;
        ListNode slow = head;

        // until fast or fast.next is equal to null, have fast move by 2 nodes
        // have slow node move by one node
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    private static void printLinkedList(ListNode head){
        while(head != null){
            if(head.next == null){
                System.out.print(head.val);
            } else{
                System.out.print(head.val + " -> ");
            }
            head = head.next;
        }
        System.out.println();
    }
}
