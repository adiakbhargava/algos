package linkedlists;

public class RemoveKElement {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        printLinkedList(head);
        head = (new RemoveKElement()).removeKthElement(head, 3);
        printLinkedList(head);
    }

    private ListNode removeKthElement(ListNode head, int k){
        // create a dummy node to point to the head (in case we need to remove the head from the list)
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        // set leader and trailer nodes to the beginning of list
        ListNode leader = dummy;
        ListNode trailer = dummy;

        // have leader node traverse through list until it is k elements away from trailer
        for(int i = 0; i < k; i++){
            leader = leader.next;
            // return head if k is larger than size of list
            if(leader == null){
                return head;
            }
        }

        // have leader node traverse through list until it is at the last node (trailer node should be at the previous node from the kth element we want to remove)
        while(leader.next != null){
            leader = leader.next;
            trailer = trailer.next;
        }

        // remove kth element
        trailer.next = trailer.next.next;

        // return head of modified linked list
        return dummy.next;
    }

    private static void printLinkedList(ListNode head){
        while(head != null){
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println();
    }

}
