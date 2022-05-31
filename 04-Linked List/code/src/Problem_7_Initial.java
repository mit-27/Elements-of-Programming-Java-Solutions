import java.util.Iterator;
import java.util.List;

public class Problem_7_Initial {

    public static void main(String[] args) {

        try{
            LinkedList<Integer> ls = new LinkedList<Integer>();
            ls.addNode(23);
            ls.addNode(2);
            ls.addNode(5);
            ls.removeAt(1);
            ls.addAt(1,21);
            System.out.println(ls);
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }

}

class ListNode<T>{
    public T data;
    public ListNode<T> next;

    public ListNode(T data,ListNode<T> nextNode)
    {
        this.data = data;
        this.next = nextNode;
    }

    public ListNode()
    {

    }

    public ListNode(ListNode<T> copyNode)
    {
        this.data = copyNode.data;
        this.next = copyNode.next;
    }

    public String toString(){
        return data.toString();
    }

}

class LinkedList<T> implements Iterable<T> {

    private int size=0;
    private ListNode<T> head=null;

    public LinkedList(){

    }

    public int getSize()
    {
        return size;
    }

    public void addNode(T data)
    {
        if(head==null)
        {
            head = new ListNode<>(data,null);
        }
        else
        {
            ListNode<T> newNode = new ListNode<>(data,null);
            ListNode<T> temp = head;

            while(temp.next!=null)
            {
                temp = temp.next;
            }

            temp.next = newNode;


        }
        size++;
    }

    public void removeAt(int index) throws Exception {
        if(index>=size || index<0)
        {
            throw new Exception("Index is out of bound!");
        }

        if(index==0)
        {
            ListNode<T> trav = head;
            head = head.next;
            trav.data=null;
            trav.next=null;

            return;
        }

        int initialIndex = 0;
        ListNode<T> trav = head;
        while(initialIndex<(index-1))
        {
            trav = trav.next;
            initialIndex++;
        }

        // Now, trav point to element which we want to remove
        ListNode<T> removedNode = trav.next;
        trav.next = trav.next.next;

        removedNode.data = null;
        removedNode.next = null;

        size--;
    }

    public void addAt(int index,T data) throws Exception {
        if(index>=size || index<0)
        {
            throw new Exception("Index is out of bound!");
        }

        ListNode<T> addedNode = new ListNode<>(data,null);
        ListNode<T> trav = head;

        if(index==0)
        {
            // add at head
            addedNode.next = head;
            head = addedNode;

            return;
        }

        int initialIndex = 0;

        while(initialIndex<(index-1))
        {
            trav = trav.next;
            initialIndex++;
        }

        // Now, trav point to element which we want to add

        addedNode.next = trav.next;
        trav.next = addedNode;
        size++;
    }

    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append("[");
        ListNode<T> trav = head;

        while(trav!=null)
        {
            s.append(trav.data+",");
            trav = trav.next;
        }

        s.append("]");

        return s.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public T next() {
                return null;
            }
        };
    }
}
