public class Problem_7_6 {

    // DELETE A NODE FROM A SINGLY LINKED LIST

    // Write a program which deletes a node in a singly linked list. The input node is
    //guaranteed not to be the tail node.

    public static void main(String[] args) {

        ListNode<Integer> L = Problem_7_4.createList(1,9);

        System.out.println("Before Delete node ");
        Problem_7_2.printList(L);

        // would be 3
        ListNode<Integer> deleteNode = L.next.next;
        deletedNode(deleteNode);
        System.out.println("After Delete");
        Problem_7_2.printList(L);

    }

    // Time 0(1)
    public static void deletedNode(ListNode<Integer> node)
    {
        // copy next node data to deletedNode
        node.data = node.next.data;

        // point to its next to next node as we copy its next node data
        node.next = node.next.next;


    }
}
