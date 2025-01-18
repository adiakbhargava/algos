package linkedlists;

public class FlattenMultiLevelLinkedList {
    private static class MultiLevelListNode{
        int val;
        MultiLevelListNode next;
        MultiLevelListNode child;

        MultiLevelListNode(){}
        MultiLevelListNode(int val){this.val = val;}
        MultiLevelListNode(int val, MultiLevelListNode next, MultiLevelListNode child){
            this.val = val;
            this.next = next;
            this.child = child;
        }
    }
    public static void main(String[] args) {
        MultiLevelListNode head = new MultiLevelListNode(1);
        head.next = new MultiLevelListNode(2);
        head.next.child = new MultiLevelListNode(6);
        head.next.child.next = new MultiLevelListNode(7);
        head.next.child.next.child = new MultiLevelListNode(10);
        head.next.next = new MultiLevelListNode(3);
        head.next.next.next = new MultiLevelListNode(4);
        head.next.next.next.child = new MultiLevelListNode(8);
        head.next.next.next.child.next = new MultiLevelListNode(9);
        head.next.next.next.child.child = new MultiLevelListNode(11);
        head = (new FlattenMultiLevelLinkedList()).flattenList(head);
        printLinkedList(head);

    }

    private MultiLevelListNode flattenList(MultiLevelListNode head){
        MultiLevelListNode tail = head;
        while(tail.next != null){
            tail = tail.next;
        }
        MultiLevelListNode curr = head;

        while(curr != null){
            if(curr.child != null){
                tail.next = curr.child;
                while(tail.next != null){
                    tail = tail.next;
                }
                curr.child = null;
            }
            curr = curr.next;
        }

        return head;
    }

    private static void printLinkedList(MultiLevelListNode head){
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
