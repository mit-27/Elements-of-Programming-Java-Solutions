public class Problem_7_12 {

    // IMPLEMENT LIST PIVOTING

    // Implement a function which takes as input a singly linked list and an integer k and
    //performs a pivot of the list with respect to k. The relative ordering of nodes that
    //appear before k, and after k, must remain unchanged; the same must hold for nodes
    //holding keys equal to k.

    public static void main(String[] args) {
        ListNode<Integer> L = createList();
        L = listPivot(L,2);
        Problem_7_2.printList(L);
    }

    // Time 0(n)
    public static ListNode<Integer> listPivot(ListNode<Integer> head,int k)
    {
        if(head==null)
        {
            return null;
        }
        // we use 3 head and trav for beforePivot,Pivot and after pivot list tracing
        ListNode<Integer> beforePivotHead = null;
        ListNode<Integer> beforePivotTrav = null;

        ListNode<Integer> pivotHead = null;
        ListNode<Integer> pivotTrav = null;

        ListNode<Integer> afterPivotHead = null;
        ListNode<Integer> afterPivotTrav = null;

        ListNode<Integer> trav = head;
        while(trav!=null)
        {
            if(trav.data<k)
            {
                if(beforePivotHead!=null)
                {
                    beforePivotTrav.next = trav;
                    beforePivotTrav = trav;
                }
                else
                {
                    beforePivotHead = trav;
                    beforePivotTrav = trav;
                }
            }

            if(trav.data==k)
            {
                if(pivotHead!=null)
                {
                    pivotTrav.next = trav;
                    pivotTrav = trav;
                }
                else
                {
                    pivotHead = trav;
                    pivotTrav = trav;
                }

            }

            if(trav.data>k)
            {
                if(afterPivotHead!=null)
                {
                    afterPivotTrav.next = trav;
                    afterPivotTrav = trav;
                }
                else
                {
                    afterPivotHead = trav;
                    afterPivotTrav = trav;
                }

            }

            trav = trav.next;
        }
//        beforePivotTrav.next = null;
//        pivotTrav.next = null;
//        afterPivotTrav.next = null;
        // connect all three list


        if(beforePivotHead!=null)
        {
            if(pivotHead==null && afterPivotHead!=null)
            {
                beforePivotTrav.next = afterPivotHead;
                afterPivotTrav.next = null;
            }

            if(pivotHead!=null && afterPivotHead==null)
            {
                beforePivotTrav.next = pivotHead;
                pivotTrav.next = null;
            }

            if(pivotHead==null && afterPivotHead==null)
            {
                beforePivotTrav.next = null;
            }

            if(pivotHead!=null && afterPivotHead!=null)
            {
                beforePivotTrav.next = pivotHead;
                pivotTrav.next = afterPivotHead;
                afterPivotTrav.next = null;
            }

            return beforePivotHead;
        }

        if(pivotHead!=null)
        {
            if(afterPivotHead== null)
            {
                pivotTrav.next = null;
            }

            if(afterPivotHead!=null)
            {
                pivotTrav.next = afterPivotHead;
                afterPivotTrav.next = null;
            }
            return pivotHead;
        }

        if(afterPivotHead==null)
        {
            return null;
        }

        afterPivotTrav.next = null;

        return afterPivotHead;

    }

    public static ListNode<Integer> createList()
    {
        ListNode<Integer> head = new ListNode<>(1,null);
        ListNode<Integer> node2 = new ListNode<>(2,null);
        ListNode<Integer> node3 = new ListNode<>(3,null);
        ListNode<Integer> node4 = new ListNode<>(2,null);
        ListNode<Integer> node5 = new ListNode<>(1,null);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        return head;

    }
}
