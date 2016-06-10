package Code;



class Node{
    int data;
    Node next;

    Node(int d){
        data = d;
        next = null;
    }
}

public class Solution {

    public static Node head;

    // 1->2->3->4->5->6->7->8->9->10->11->12->13->14->15
    // 1
    // 1->2
    //1-> 2->3-> 4

    public static Node kReverse(Node h,int k)
    {
        Node current = h;
        Node prev = null;
        Node next = null;

        int count = 0;
        while (current!= null && count < k)
        {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

        if(next!= null)
            h.next = kReverse(next,k);

        return prev;
    }

    public static void buildList(int len)
    {
        Node preNode = null;
        for(int i=1; i<= len ; i++)
        {
            Node n = new Node(i);
            if(head == null)
                head = n;
            else
                preNode.next = n;


            preNode = n;
        }
    }

    public static void printList(){
        Node p = head;

        while (p!= null)   {
            System.out.print(p.data+" ");
            p=p.next;
        }

    }

    public static void main(String args[]){
      /*  buildList(14);
        printList();
        System.out.println();
        head = kReverse(head,3);
        printList();*/

        /*System.out.println();
        buildList(1);
        printList();
        System.out.println();
        head = kReverse(head,3);
        printList();*/

        /*System.out.println();
        buildList(2);
        printList();
        System.out.println();
        head = kReverse(head,3);
        printList();*/

        /*System.out.println();
        buildList(12);
        printList();
        System.out.println();
        head = kReverse(head,2);
        printList();*/

        System.out.println();
        buildList(12);
        printList();
        System.out.println();
        head = kReverse(head,12);
        printList();




    }




}
