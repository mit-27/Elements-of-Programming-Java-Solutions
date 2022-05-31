public class Problem_7_11 {

    // TEST WHETHER A SINGLY LINKED LIST IS PALINDROMIC

    // Write a program that tests whether a singly linked list is palindromic.

    public static void main(String[] args) {

        ListNode<Integer> L = Problem_7_4.createList(1,4);
        System.out.println(checkPalindrome(L));

        L = createPalindromeList();
        System.out.println(checkPalindrome(L));
    }

    public static ListNode<Integer> createPalindromeList()
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

    private static ListNode<Integer> reverseList(ListNode<Integer> L)
    {
        if(L==null)
        {
            return null;
        }
        // 1 2 3 4
        ListNode<Integer> prevNode = null;
        ListNode<Integer> currentNode = L;
        ListNode<Integer> nextNode = null;

        while(currentNode!=null)
        {
            nextNode = currentNode.next;
            currentNode.next = prevNode;
            prevNode = currentNode;
            currentNode = nextNode;

        }

        L = prevNode;

        return L;
    }

    // Time = 0(n)
    private static boolean checkPalindrome(ListNode<Integer> L)
    {
        int lengthOfList = Problem_7_9.getLengthOfList(L);

        if(lengthOfList==1)
        {
            return true;
        }

        // 1 2 3 4
        int halfLen = lengthOfList/2;

        int distance=0;
        // trav to reach halfed length of List so that we could reverse that half
        ListNode<Integer> trav = L;
        while(distance<halfLen)
        {
            trav = trav.next;
            distance++;
        }

        ListNode<Integer> reversedHalfTrav = reverseList(trav);

        trav = L;

        // now compare boft half
        distance = 0;

        while(distance<halfLen)
        {
            if(trav.data!=reversedHalfTrav.data)
            {
                // both are not same so no palindrome
                return false;
            }
            trav = trav.next;
            reversedHalfTrav = reversedHalfTrav.next;
            distance++;
        }

        return true;

    }
}
