import java.util.List;

public class Problem_7_1 {

    // MERGE TWO SORTED LISTS

    // Write a program that takes two lists, assumed to be sorted, and returns their merge.
    //The only field your program can change in a node is its next field.

    public static void main(String[] args) {

        ListNode<Integer> head1 = new ListNode<>(2,null);
        ListNode<Integer> head2 = new ListNode<>(5,null);
        addToHead(head1,7);
        addToHead(head1,9);
        addToHead(head2,8);
        addToHead(head2,10);

        ListNode<Integer> mergedListHead = mergeLists(head1,head2);

        printList(head1);
        printList(head2);
        printList(mergedListHead);

    }

    // Time  0(n+m) n,m are length of two lists
    public static ListNode<Integer> mergeLists(ListNode<Integer> head1,ListNode<Integer> head2)
    {
        ListNode<Integer> trav1 = head1;
        ListNode<Integer> trav2 = head2;

        ListNode<Integer> newHead = null;

        // to decide mergeList Head
        if(trav1.data<trav2.data)
        {
            newHead = new ListNode<>(trav1);
            trav1 = trav1.next;
        }
        else
        {
            newHead = new ListNode<>(trav2);
            trav2 = trav2.next;
        }

        // set trav3 for merge List
        ListNode<Integer> trav3 = newHead;

        while(trav1!=null && trav2!=null)
        {
            if(trav1.data<trav2.data)
            {
                ListNode<Integer> temp = new ListNode<>(trav1);
                trav3.next = temp;
                trav3 = temp;

                trav1 = trav1.next;
            }
            else
            {
                ListNode<Integer> temp = new ListNode<>(trav2);
                trav3.next = temp;
                trav3 = temp;

                trav2 = trav2.next;
            }
        }

        // To add remaining element in List1 or List2
        while(trav1!=null)
        {
            ListNode<Integer> temp = new ListNode<>(trav1);
            trav3.next = temp;
            trav3 = temp;

            trav1 = trav1.next;
        }

        while(trav2!=null)
        {
            ListNode<Integer> temp = new ListNode<>(trav2);
            trav3.next = temp;
            trav3 = temp;

            trav2 = trav2.next;
        }

        return newHead;

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


