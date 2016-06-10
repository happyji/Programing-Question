package Code;

/*
   Given a singly linked list,
   write a function to put all the even numbers at the front and odd numbers at the end of ll while maintaining the order of numbers.
   In place solution was expected.
 */

class Node{
    int data;
    Node next;

    Node(int d){
        this.data = d;
        next = null;
    }
}




public class Solution {

    public static Node head;

    public static boolean isODD(int data)
    {
        return data%2 != 0;
    }

    public static void oddEvenSortList()
    {
        Node p = head;
        head = null;
        // 1->2->3->4->5
        Node oddStart = null;
        Node oddEnd = null;

        Node evenEnd = null;

        while (p!=null)
        {
            if(isODD(p.data))
            {
                if(oddStart == null)
                oddStart = p;
                else
                oddEnd.next = p;

                oddEnd = p;
            }
            else
            {
                if(head == null)
                    head = p;
                else
                    evenEnd.next = p;

                evenEnd =p;
            }
            p= p.next;
        }

        evenEnd.next = oddStart;

    }

    public static void printList()
    {
        Node p = head;
        while (p!=null){
            System.out.print(p.data+" ");
            p=p.next;
        }


    }


    public static void main(String args[]){
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        oddEvenSortList();
        printList();


    }




}
