import java.util.Scanner;

public class Problem_7_9 {

    // IMPLEMENT CYCLIC RIGHT SHIFT FOR SINGLY LINKED LISTS

    // Write a program that takes as input a singly linked list and a nonnegative integer k,
    //and returns the list cyclically shifted to the right by k.

    public static void main(String[] args) {
        ListNode<Integer> L = Problem_7_4.createList(1,5);
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter shift K : ");
        int k = sc.nextInt();
        System.out.println("Before shift");
        Problem_7_4.printList(L);
        ListNode<Integer> afterShiftL = rightShift(L,k);
        System.out.println("After shift");
        Problem_7_4.printList(afterShiftL);
    }

    public static int getLengthOfList(ListNode<Integer> head)
    {
        if(head==null)
        {
            return 0;
        }

        int len=1;
        while(head.next!=null)
        {
            len++;
            head = head.next;
        }

        return len;
    }

    // Time 0(n)
    private static ListNode<Integer> rightShift(ListNode<Integer> head, int k) {

        int lengthofList = getLengthOfList(head);

        if((k % lengthofList)==0)
        {
            // no shift required as it will remain same after shift
            return head;
        }

        k = k % lengthofList;

        ListNode<Integer> prev = head;
        ListNode<Integer> left = head;
        ListNode<Integer> right = head;

        // if we reach element from last kth where left point to that then we could see after shift [left-right elements to head to left
        // would be answer

        int gap=0;
        // create gap k-1 between left and right
        while(gap < (k-1))
        {
            right = right.next;
            gap++;
        }

        // now simultaneously iterate left and right to point left to kth last
        while(right.next!=null)
        {
            left = left.next;
            right = right.next;
        }

        // now prev.next should be left but if k==(n-1) where n=length of L then prev remains at head
        if(k!=(lengthofList-1))
        {
            while(prev.next!=left)
            {
                prev = prev.next;
            }
        }

        // now merge (left,right) list to (oldHead,prev)
        prev.next = null;
        right.next = head;

        head = left;

        return head;

    }
}
