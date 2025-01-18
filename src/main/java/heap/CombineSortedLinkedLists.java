package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class CombineSortedLinkedLists {
    private static class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val){this.val = val;}
        ListNode(int val, ListNode next){this.val = val; this.next = next;}

        static class ListNodeComparator implements Comparator<ListNode> {
            // modifies compare method so that it prioritizes nodes based off their value
            public int compare(ListNode nodeOne, ListNode nodeTwo){
                return (nodeOne.val < nodeTwo.val ? -1 : nodeOne.val == nodeTwo.val ? 0 : 1);
            }
        }
    }
    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(6);

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(4);
        head2.next.next = new ListNode(6);

        ListNode head3 = new ListNode(3);
        head3.next = new ListNode(7);

        ListNode[] lists = {head1, head2, head3};

        System.out.println("First List : ");
        printLinkedList(head1);

        System.out.println("Second List : ");
        printLinkedList(head2);

        System.out.println("Third List : ");
        printLinkedList(head3);

        System.out.println("Combined List : ");
        printLinkedList((new CombineSortedLinkedLists()).combineSortedLists(lists));
    }

    private ListNode combineSortedLists(ListNode[] lists){
        // 1. Init
        PriorityQueue<ListNode> heap = new PriorityQueue<>(new ListNode.ListNodeComparator());
        // add each head node from the list into the priority queue assuming they are not null
        for(ListNode head : lists){
            if(head != null){
                heap.add(head);
            }
        }

        // create a dummy node (will eventually point to the combined list)
        ListNode dummyNode = new ListNode(-1);
        // create a current node used for traversal
        ListNode currNode = dummyNode;

        while(!heap.isEmpty()){
            // get head of the heap
            ListNode smallestNode = heap.poll();
            // set current node's next node to the smallest node
            currNode.next = smallestNode;
            // set current node to its next node (now the smallest node)
            currNode = currNode.next;

            // if the smallest node is not a singular node, add its next node to heap
            if(smallestNode.next != null){
                heap.add(smallestNode.next);
            }
        }

        // return output list
        return dummyNode.next;
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
