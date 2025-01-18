package linkedlists;

import java.util.HashSet;

public class LinkedListIntersection {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static void main(String[] args) {
        ListNode headA = new ListNode(1);
        headA.next = new ListNode(3);
        headA.next.next = new ListNode(4);
        headA.next.next.next = new ListNode(8);
        headA.next.next.next.next = new ListNode(7);
        headA.next.next.next.next.next = new ListNode(2);

        ListNode headB = new ListNode(6);
        headB.next = new ListNode(4);
        headB.next.next = headA.next.next.next;

        System.out.println((new LinkedListIntersection()).getIntersectionHashSetVisitor(headA, headB).val);
    }

    private ListNode getIntersection(ListNode headA, ListNode headB){
        ListNode ptrA = headA;
        ListNode ptrB = headB;

        while(ptrA != ptrB){
            ptrA = (ptrA.next != null ? ptrA.next : headB);
            ptrB = (ptrB.next != null ? ptrB.next : headA);
        }

        return ptrB;
    }

    private ListNode getIntersectionHashSetVisitor(ListNode headA, ListNode headB){
        HashSet<ListNode> visited = new HashSet<ListNode>();
        ListNode ptrA = headA;
        while(ptrA != null){
            visited.add(ptrA);
            ptrA = ptrA.next;
        }

        ListNode ptrB = headB;
        while(ptrB != null){
            if(visited.contains(ptrB)){
                return ptrB;
            }
            ptrB = ptrB.next;
        }

        return ptrB;
    }
}
