package linkedlists;
public class LinkedListReversal {
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
        System.out.println(head.val + " -> " + head.next.val +
                " -> " + head.next.next.val + " -> " + head.next.next.next.val);
        head = (new LinkedListReversal()).reverseLinkedListRecursive(head);
        System.out.println(head.val + " -> " + head.next.val +
                " -> " + head.next.next.val + " -> " + head.next.next.next.val);

        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        System.out.println(head1.val + " -> " + head1.next.val +
                " -> " + head1.next.next.val + " -> " + head1.next.next.next.val);
        head1 = (new LinkedListReversal()).reverseLinkedList(head1);
        System.out.println(head1.val + " -> " + head1.next.val +
                " -> " + head1.next.next.val + " -> " + head1.next.next.next.val);

    }

    private ListNode reverseLinkedList(ListNode head){
        ListNode prevNode = null;
        ListNode currNode = head;

        while(currNode != null){
            ListNode nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        }

        return prevNode;
    }

    private ListNode reverseLinkedListRecursive(ListNode head){
        if(head == null || head.next == null){
            return head;
        }

        ListNode newHead = reverseLinkedListRecursive(head.next);

        head.next.next = head;
        head.next = null;

        return newHead;
    }

}
