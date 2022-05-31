public class Problem_7_5 {

    // TEST FOR OVERLAPPING LISTS — LISTS MAY HAVE CYCLES

    // Same as Problem 7.4 but it could possible that lists have loop

    public static void main(String[] args) {

        // l1 is second list [11,12,13,14]
        ListNode<Integer> L1 = Problem_7_4.createList(11,14);

        // l2 is loop list [1,2,3,4,5,6,7] then 7 point to 5
        ListNode<Integer> L2 = Problem_7_3.createLoopList();

        // now point l1 to l0 for overlapping
        createOverlap(L1,L2);

        System.out.println("After checking : "+checkOverlap(L1,L2));

    }

    // Time 0(n)
    public static ListNode<Integer> checkOverlap(ListNode<Integer> L1,ListNode<Integer> L2)
    {
        // Get start of loop of both lists
        ListNode<Integer> startOfLoopL1 = Problem_7_3.checkCycle(L1);
        ListNode<Integer> startOfLoopL2 = Problem_7_3.checkCycle(L2);



        // If both lists don't have loop then user Problem 7.4
        if(startOfLoopL1==null && startOfLoopL2==null)
        {
            return Problem_7_4.checkOverlap(L1,L2);
        }

        // If one list is loop and other do not then its not possible that both have overlapp
        if((startOfLoopL1!=null && startOfLoopL2==null) || (startOfLoopL1==null && startOfLoopL2!=null))
        {
            return null;
        }

        // now check whether startLoopL1 include in startLoop2 if yes it means both list have same loop therefore we could
        // say both have overlapp but if it's not then both have different loop and both are not overlapped

        ListNode<Integer> temp = startOfLoopL1;
        do{
            temp = temp.next;
        }while(temp!=startOfLoopL1 || temp!=startOfLoopL2);

        if(temp!=startOfLoopL2)
        {
            // it means both loops are different and loop2 start point do not include in loop1 so both are not overlapped
            return null;
        }

        // now both lists overlapped and now check whether they overlapped before loop
        int distanceOfLoopAndStartL1 = distance(L1,startOfLoopL1);
        int distanceOfLoopAndStartL2 = distance(L2,startOfLoopL2);

        if(distanceOfLoopAndStartL1>distanceOfLoopAndStartL2)
        {
            L1 = advanceListByK(distanceOfLoopAndStartL1-distanceOfLoopAndStartL2,L1);
        }
        else
        {
            L2 = advanceListByK(distanceOfLoopAndStartL2-distanceOfLoopAndStartL1,L2);
        }

        // now we iterate L1 and L2 simultaneously and if L1 reach at startLoop1 or L2 reach startLoop2 before L1==L2 then it
        // means both overlapped in loop so we could return any startLoop node but if its not then return L1 or L2
        while (L1!=L2 && L1!=startOfLoopL1 && L2!=startOfLoopL2)
        {
            L1 = L1.next;
            L2 = L2.next;
        }

        return L1==L2 ? L1 : startOfLoopL1;




    }

    public static ListNode<Integer> advanceListByK(int distance,ListNode<Integer> head)
    {
        if(distance-- > 0)
        {
            head = head.next;
        }

        return head;
    }

    public static int distance(ListNode<Integer> n1,ListNode<Integer> n2)
    {
        int d=0;

        while(n1!=n2)
        {
            n1 = n1.next;
            d++;
        }

        return d;
    }



    public static void createOverlap(ListNode<Integer> L1,ListNode<Integer> L2)
    {
        // point end of L1 in L2
        ListNode<Integer> trav1 = L1;
        while(trav1.next!=null)
        {
            trav1 = trav1.next;
        }

        // L1 end point to 3
        trav1.next = L2.next.next;


    }
}
