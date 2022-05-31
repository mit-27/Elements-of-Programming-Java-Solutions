public class Problem_7_4 {

    // TEST FOR OVERLAPPING LISTS - LISTS ARE CYCLE-FREE

    // Write a program that takes two cycle-free singly linked lists, and determines if there
    //exists a node that is common to both lists.

    public static void main(String[] args) {

        ListNode<Integer> head1 = createList(1,4);
        ListNode<Integer> head2 = createList(5,10);

        // without overlap list check
        printList(head1);
        System.out.println("List1 and List2 is Overlaaping : "+checkOverlap(head1,head2));

        // with overlap
        createOverlapList(head1,head2,8);
        printList(head1);
        System.out.println("List1 and List2 is Overlaaping : "+checkOverlap(head1,head2));



    }

    // Time 0(n)
    public static ListNode<Integer> checkOverlap(ListNode<Integer> head1,ListNode<Integer> head2)
    {
        int list1Length = 0;
        int list2Length = 0;

        ListNode<Integer> trav = head1;

        while(trav!=null)
        {
            trav =trav.next;
            list1Length++;
        }

        trav = head2;

        while(trav!=null)
        {
            trav =trav.next;
            list2Length++;
        }

        // we have to get extra length list so we skip that and start to trav both lists node and check whether they point to same
        // node in iteration

        int list1Extra = 0;
        int list2Extra = 0;
        if(list1Length>list2Length)
        {
            list1Extra = list1Length - list2Length;
        }
        else
        {
            list2Extra = list2Length - list1Length;
        }

        // now skip extra nodes
        ListNode<Integer> trav1 = head1;
        ListNode<Integer> trav2 = head2;

        while(list1Extra-- > 0)
        {
            trav1 = trav1.next;
        }
        while(list2Extra-- > 0)
        {
            trav2 = trav2.next;
        }

        // now trav both node same time and check
        while(trav1!=null && trav2!=null)
        {
            if(trav1==trav2)
            {
                // yes have common node
                return trav1;
            }
            trav1 = trav1.next;
            trav2= trav2.next;
        }

        return null;





    }

    public static void createOverlapList(ListNode<Integer> head1,ListNode<Integer> head2,int PointData)
    {
        ListNode<Integer> trav = head1;
        while(trav.next!=null)
        {
            trav = trav.next;
        }

        ListNode<Integer> trav1 = head2;
        while(trav1!=null)
        {
            if(trav1.data==PointData)
            {
                trav.next = trav1;
                break;
            }

            trav1 = trav1.next;
        }
    }


    public static ListNode<Integer> createList(int start,int end)
    {
        ListNode<Integer> head = new ListNode<>(start++,null);

        for(int i=start;i<=end;i++)
        {
            addToHead(head,i);
        }
        return head;

    }

    public static void addToHead(ListNode<Integer> head,int data)
    {

        ListNode<Integer> trav = head;

        // traval at end of list to add node
        while(trav.next!=null)
        {
            trav = trav.next;
        }

        // add new node at end
        ListNode<Integer> newNode = new ListNode<>(data,null);
        trav.next = newNode;

    }

    public static void printList(ListNode<Integer> head)
    {
        StringBuilder sc = new StringBuilder();
        sc.append("[");
        ListNode<Integer> trav = head;
        while(trav!=null)
        {
            sc.append(trav.data);
            sc.append(",");
            trav = trav.next;
        }
        sc.append("]");

        System.out.println(sc.toString());

    }
}
