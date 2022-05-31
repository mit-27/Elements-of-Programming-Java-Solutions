public class Problem_7_8 {

    // REMOVE DUPLICATES FROM A SORTED LIST

    // Write a program that takes as input a singly linked list of integers in sorted order, and
    //removes duplicates from it. The list should be sorted.

    public static void main(String[] args) {

        ListNode<Integer> L = createSortedDuplicateList();
        removeDuplicates(L);
        Problem_7_2.printList(L);

    }

    // Time 0(n)
    public static void removeDuplicates(ListNode<Integer> head)
    {
        if(head.next==null)
        {
            return;
        }

        // we could remove using two trav pointer
        ListNode<Integer> trav1 = head;
        ListNode<Integer> trav2 = head.next;

        // below cases will miss if length is 2
        if(trav2.next==null)
        {
            if(trav1.data== trav2.data)
            {
                trav1.next = trav2.next;
            }
            return;
        }

        // now we do it until trav2 reach at end of list
        while(trav2!=null)
        {
            if(trav1.data==trav2.data)
            {
                // remove trav2 node and increment trav2 and change trav1.next
                ListNode<Integer> temp = trav2;
                trav2 = trav2.next;
                trav1.next = trav2;
                temp.next = null;
            }
            else
            {
                // both are not same so increment both
                trav1 = trav1.next;
                trav2 = trav2.next;
            }
        }


    }

    public static ListNode<Integer> createSortedDuplicateList()
    {
        ListNode<Integer> head = new ListNode<>(2,null);
        ListNode<Integer> node2 = new ListNode<>(2,null);
        ListNode<Integer> node3 = new ListNode<>(3,null);
        ListNode<Integer> node4 = new ListNode<>(5,null);
        ListNode<Integer> node5 = new ListNode<>(7,null);
        ListNode<Integer> node6 = new ListNode<>(11,null);
        ListNode<Integer> node7 = new ListNode<>(12,null);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        return head;

    }
}
