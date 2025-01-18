package fastslowpointers;

import linkedlists.PalindromicLinkedList;

public class LinkedListMidpoint {
    private static class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val){this.val = val;}
        ListNode(int val, ListNode next){this.val = val; this.next = next;}
    }
    public static void main(String[] args) {
        // for odd length llist
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(7);
        head.next.next.next.next = new ListNode(3);
        ListNode mid = (new LinkedListMidpoint()).findMidpoint(head);
        System.out.println("ODD LENGTH LIST --");
        printLinkedList(head);
        System.out.println("Middle Node : " + mid.val);
        printLinkedList(mid);

        // for even length llist
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(7);
        head1.next.next.next = new ListNode(3);
        mid = (new LinkedListMidpoint()).findMidpoint(head1);
        System.out.println("\nEVEN LENGTH LIST --");
        printLinkedList(head1);
        System.out.println("Middle Node : " + mid.val);
        printLinkedList(mid);

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(4);
        head2.next.next.next.next = new ListNode(5);
        head2.next.next.next.next.next = new ListNode(6);
        head2.next.next.next.next.next.next = new ListNode(7);
        head2.next.next.next.next.next.next.next = new ListNode(8);
        System.out.println("\nSIZE 8 LIST --");
        printLinkedList(head2);
        System.out.println("Quarter Node : " + (new LinkedListMidpoint()).findQuarterpoint(head2).val);


    }

    private ListNode findMidpoint(ListNode head){
        // declare slow and fast pointers
        ListNode slowPtr = head;
        ListNode fastPtr = head;

        // while the fast pointer is not null or its next node, move the fast pointer by two nodes, and the slow pointer by one node
        // for even length lists, it's advisable to ask the interviewer which inner node we would want to count as the middle node
        // as two nodes can technically be counted as being the 'middle node'
        // if it's the first inner node : fastPtr.next.next == null -> break
        // if it's the second inner node : fast == null -> break

        // while(fastPtr.next != null && fastPtr.next.next != null){ // for odd, returns middle node; for even, returns innermost middle node
        while(fastPtr != null && fastPtr.next != null){ // for odd, returns middle node; for even, returns outermost middle node
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
        }

        // return slow pointer once fast pointer is at last node or is null (depends on if length of list is even or odd)
        return slowPtr;
    }

    private ListNode findQuarterpoint(ListNode head){
        // declare slow and fast pointers
        ListNode slowPtr = head;
        ListNode fastPtr = head;

        // while the fast pointer is not null or its next node, move the fast pointer by two nodes, and the slow pointer by one node
        // for even length lists, it's advisable to ask the interviewer which inner node we would want to count as the middle node
        // as two nodes can technically be counted as being the 'middle node'
        // if it's the first inner node : fastPtr.next.next == null -> break
        // if it's the second inner node : fast == null -> break

        // while(fastPtr.next != null && fastPtr.next.next != null){ // for odd, returns middle node; for even, returns innermost middle node
        while(fastPtr.next.next.next != null && fastPtr.next.next.next.next != null){ // for odd, returns middle node; for even, returns outermost middle node
            fastPtr = fastPtr.next.next.next.next;
            slowPtr = slowPtr.next;
        }

        // return slow pointer once fast pointer is at last node or is null (depends on if length of list is even or odd)
        return slowPtr;
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
