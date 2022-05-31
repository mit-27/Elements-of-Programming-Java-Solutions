public class Problem_7_2 {
    // REVERSE A SINGLE SUBLIST

    // Write a program which takes a singly linked list L and two integers s and f
    /// as arguments, and reverses the order of the nodes from the sth node to th node,
    //inclusive. The numbering begins at 1, i.e., the head node is the first node. Do not
    //allocate additional nodes.

    public static void main(String[] args) {

        ListNode<Integer> head = new ListNode<>(1,null);
        addToHead(head,2);
        addToHead(head,3);
        addToHead(head,4);
        addToHead(head,5);
        addToHead(head,6);
        addToHead(head,7);

        System.out.println("Before reverse");
        printList(head);

        System.out.println("After reverse of 1 and 3 between list");
        printList(reverseSubList(head,2,3));

    }

    // Return new head if it required otherwise old head
    // Time 0(f)
    public static ListNode<Integer> reverseSubList(ListNode<Integer> head,int s,int f)
    {

        if(s==f)
        {
            return head;
        }

        ListNode<Integer> sNode = null;
        ListNode<Integer> fNode = null;
        ListNode<Integer> prevSNode = null;
        ListNode<Integer> nextFNode = null;
        int currentIndex=1;

        ListNode<Integer> trav = head;

        // trace s and fth node and also prev node of s and next node of f
        while(trav!=null)
        {
            if(currentIndex==(s-1))
            {
                prevSNode = trav;
            }
            if(currentIndex==s)
            {
                sNode = trav;
            }
            if(currentIndex==f)
            {
                fNode = trav;
            }
            if(currentIndex==(f+1))
            {
                nextFNode = trav;
            }

            trav = trav.next;
            currentIndex++;
        }

        // s node point to next of f node in reverse
        // before that save next of s node as we start from that to reverse list
        ListNode<Integer> currentNode = sNode.next;
        sNode.next = nextFNode;
        ListNode<Integer> prevNode = sNode;

        // in loop currentNode point to prevNode and then currentNode becomes prev and repeat step
        currentIndex = s;
        while(currentIndex!=f)
        {
            // to save next node of current to shift current and prevNode pointer
            ListNode<Integer> temp = currentNode.next;

            currentNode.next = prevNode;

            // now shift both currentNode and prevNode
            prevNode = currentNode;
            currentNode = temp;

            currentIndex++;
        }

        // after this prevNode point to last element of list which has to reverse
        // after reverse prevSNode.next point to that node

        if(prevSNode!=null)
        {
            prevSNode.next = prevNode;
            return head;
        }

        return prevNode;








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
