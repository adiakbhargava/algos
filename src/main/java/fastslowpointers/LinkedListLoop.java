package fastslowpointers;

public class LinkedListLoop {
    private static class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val){this.val = val;}
        ListNode(int val, ListNode next){this.val = val; this.next = next;}
    }
    public static void main(String[] args) {
        // llist with cycle
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = head.next.next;
        System.out.println("CYCLE IS PRESENT IN LIST : " + ((new LinkedListLoop()).detectLinkedListLoop(head)
        ? "YES" : "NO"));

        // llist with no cycle
        ListNode head1 = new ListNode(0);
        head1.next = new ListNode(1);
        head1.next.next = new ListNode(2);
        head1.next.next.next = new ListNode(3);
        head1.next.next.next.next = new ListNode(4);
        head1.next.next.next.next.next = new ListNode(5);
        System.out.println("CYCLE IS PRESENT IN LIST : " + ((new LinkedListLoop()).detectLinkedListLoop(head1)
                ? "YES" : "NO"));
    }

    private boolean detectLinkedListLoop(ListNode head){
        // fastPtr moves at double the nodes of slow pointer
        ListNode fastPtr = head;
        ListNode slowPtr = head;

        // traverse through list until fastPtr is null or its next node is null (indicates llist does not contain a cycle)
        // or until fastPtr and slowPtr cross each other (indicates cycle is present in llist)
        while(fastPtr != null && fastPtr.next != null){
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            if(fastPtr == slowPtr){
                return true;
            }
        }

        return false;
    }
}
