public class Problem_7_13 {

    // ADD LIST-BASED INTEGERS

    // Write a program which takes two singly linked lists of digits, and returns the list
    //corresponding to the sum of the integers they represent. The least significant digit
    //comes first.

    public static void main(String[] args) {
        ListNode<Integer> L1 = Problem_7_4.createList(7,9);
        ListNode<Integer> L2 = Problem_7_4.createList(1,3);

        ListNode<Integer> ansL = addTwoNumbers(L1,L2);

        Problem_7_2.printList(ansL);

    }

    private static ListNode<Integer> addTwoNumbers(ListNode<Integer> l1, ListNode<Integer> l2) {

        int carry=0;
        ListNode<Integer> dummyHead = new ListNode<>(0,null);
        ListNode<Integer> iter = dummyHead;

        while(l1!=null || l2!=null)
        {
            int sum = carry;

            if(l1!=null)
            {
                sum += l1.data;
                l1 = l1.next;
            }

            if(l2!=null)
            {
                sum += l2.data;
                l2 = l2.next;
            }

            iter.next = new ListNode<>(sum%10,null);
            iter = iter.next;
            carry = sum / 10;
        }

        // if carry has > 0 value then add carry in new node
        iter.next = new ListNode<>(carry,null);

        return dummyHead.next;
    }
}
