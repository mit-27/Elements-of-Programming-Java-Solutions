public class Problem_7_10 {

    // IMPLEMENT EVEN-ODD MERGE

    // Consider a singly linked list whose nodes are numbered starting at 0. Define the even-
    //odd merge of the list to be the list consisting of the even-numbered nodes followed
    //by the odd-numbered nodes.

    // Write a program that computes the even-odd merge.

    public static void main(String[] args) {
        ListNode<Integer> L = Problem_7_4.createList(1,4);
        System.out.println("Before Even - Odd Merge");
        Problem_7_4.printList(L);

        System.out.println("After Even - Odd Merge");
        Problem_7_4.printList(evenOddMerge(L));


    }

    // Time 0(n) and space 0(1)
    private static ListNode<Integer> evenOddMerge(ListNode<Integer> l) {

        ListNode<Integer> trav = l;
        int currentIndex=0;

        // we use even odd head and trav to trace both separate and then attach even tail to odd head
        ListNode<Integer> evenHead = null;
        ListNode<Integer> evenTrav = null;
        ListNode<Integer> oddHead = null;
        ListNode<Integer> oddTrav = null;

        while(trav!=null)
        {
            if(currentIndex%2==0)
            {

                if(evenHead!=null)
                {
                    // If already initialized even head or trav then add currentnode
                    evenTrav.next = trav;
                    evenTrav = evenTrav.next;
                }
                else
                {
                    // for first time so initialize evenHead and evenTrav
                    evenHead = trav;
                    evenTrav = trav;
                }
            }
            else
            {
                if(oddHead!=null)
                {
                    // If already initialized even head or trav then add currentnode
                    oddTrav.next = trav;
                    oddTrav = oddTrav.next;
                }
                else
                {
                    // for first time so initialize evenHead and evenTrav
                    oddHead = trav;
                    oddTrav = trav;
                }

            }
            trav = trav.next;
            currentIndex++;
        }

        // last element of even and odd should be null for merge
        evenTrav.next = null;
        oddTrav.next = null;

        // now merge and return new head
        evenTrav.next = oddHead;

        return evenHead;
    }
}
