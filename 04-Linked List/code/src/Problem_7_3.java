public class Problem_7_3 {

    // TEST FOR CYCLICITY

    // Write a program that takes the head of a singly linked list and returns null if there
    //does not exist a cycle, and the node at the start of the cycle, if a cycle is present. (You
    //do not know the length of the list in advance.)

    public static void main(String[] args) {

        ListNode<Integer> headWithLoop = createLoopList();
        ListNode<Integer> headWithoutLoop = createList();

        ListNode<Integer> ansWithLoop = checkCycle(headWithLoop);

        System.out.println("List with loop answer");

        if(ansWithLoop!=null)
        {
            System.out.println("Node is "+ansWithLoop);
        }

        System.out.println("List without Loop ");

        ListNode<Integer> ansWithoutLoop = checkCycle(headWithoutLoop);

        if(ansWithoutLoop==null)
        {
            System.out.println("No loop is present");
        }







    }

    public static int getCycleLength(ListNode<Integer> slow,ListNode<Integer> fast)
    {
        // now fast remain there we trav slow and increment length count and when again slow==fast would be break
        int len=0;
        ListNode<Integer> temp = slow;
        do{
            temp = temp.next;
            len++;
        }while(temp!=fast);

        return len;
    }

    // Time 0(n)
    public static ListNode<Integer> checkCycle(ListNode<Integer> head)
    {
        // we will use floyd's tortoise and hare algo
        // Use two pointer where slow will step 1 at a time and fast will step 2 at a time
        ListNode<Integer> slow = head;
        ListNode<Integer> fast = head;

        int cycleLength = 0;

        while(fast!=null && fast.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
            // if there is loop then at some point both will point to same node
            if(slow==fast)
            {
                // loop detected
                // get cycle length
                cycleLength = getCycleLength(slow,fast);
                break;
            }


        }

        if(cycleLength==0)
        {
            // no cycle detected
            return null;
        }

        // now to get start node of loop

        // if we trav second pointer at node where first which start from head and second will meet at start of loop node
        ListNode<Integer> first = head;
        ListNode<Integer> second = head;

        // set second node at position
        while(cycleLength-- > 0)
        {
            second = second.next;
        }

        while(first!=second)
        {
            first = first.next;
            second = second.next;
        }

        return first;




    }

    // creating list without loop
    public static ListNode<Integer> createList()
    {
        ListNode<Integer> head = new ListNode<>(1,null);
        addToHead(head,2);
        addToHead(head,3);
        addToHead(head,4);
        addToHead(head,5);
        addToHead(head,6);
        addToHead(head,7);

        return head;

    }

    // creating loop list for testing
    public static ListNode<Integer> createLoopList()
    {
        ListNode<Integer> head = new ListNode<>(1,null);

        ListNode<Integer> node2 = new ListNode<>(2,null);
        ListNode<Integer> node3 = new ListNode<>(3,null);
        ListNode<Integer> node4 = new ListNode<>(4,null);
        ListNode<Integer> node5 = new ListNode<>(5,null);
        ListNode<Integer> node6 = new ListNode<>(6,null);
        ListNode<Integer> node7 = new ListNode<>(7,null);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        // created loop
        node7.next = node5;

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
}
