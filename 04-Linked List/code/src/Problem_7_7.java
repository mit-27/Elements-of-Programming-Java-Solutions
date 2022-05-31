public class Problem_7_7 {

    // REMOVE THE /CTH LAST ELEMENT FROM A LIST

    // Given a singly linked list and an integer k, write a program to remove the /cth last
    //element from the list. Your algorithm cannot use more than a few words of storage,
    //regardless of the length of the list. In particular, you cannot assume that it is possible
    //to record the length of the list.

    public static void main(String[] args) {
        ListNode<Integer> L = Problem_7_4.createList(1,9);
        System.out.println("Before delete");
        Problem_7_2.printList(L);



        System.out.println("After Deletion");
        ListNode<Integer> newHead = deleteKthNode(L,9);
        Problem_7_2.printList(newHead);






    }

    public static ListNode<Integer> deleteKthNode(ListNode<Integer> head,int k)
    {
        // find list length
        int len=0;
        ListNode<Integer> trav = head;
        while(trav!=null)
        {
            len++;
            trav = trav.next;
        }

        // check k is valid or not
        if(k>len || k<0)
        {
            return null;
        }

        int fromStartPosition = len - k;
        int coverDistance = 0;

        trav = head;
        while(coverDistance<(fromStartPosition-1))
        {
            trav = trav.next;
            coverDistance++;
        }

        if(coverDistance==0)
        {
            // it means deleted node is head
            head = head.next;
            trav.next = null;

            return head;
        }

        // now delete node as we react deletedNode's predecessor
        trav.next = trav.next.next;

        return head;



    }

    // Time 0(min(n-k,k))
    public static ListNode<Integer> deleteKthNodeTwoPointerMethod(ListNode<Integer> head,int k)
    {
        // Left and right pointers we use
        // now we first create gap between two pointers K+1 so when right becomes null it means left would be at k+1 position

        // For K+1 gap we create one dummy Head for Left pointer
        // without dummy head if you create gap k+1 between left and right then when k=n you are not able to remove head
        ListNode<Integer> dummyHead = new ListNode<>(0,head);
        ListNode<Integer> right = dummyHead.next; // means head

        // now we only need to shift right to k steps
        while(k-- > 0 && right!=null)
        {
            right = right.next;
        }

        if(k>0)
        {
            // it means k is invalid
            return null;
        }

        ListNode<Integer> left = dummyHead;

        // now shift both pointers till right becomes null
        while(right!=null)
        {
            left = left.next;
            right = right.next;
        }

        // now left would be k+1 node
        left.next = left.next.next;

        return dummyHead.next;

    }
}
