package list;

/*
   Given a singly linked list,
   write a function to put all the even numbers at the front and
   odd numbers at the end of ll while maintaining the order of numbers.
   In place solution was expected.
 */


public class OddEvenSortList {

    public static ListNode head;

    public static boolean isODD(int data)
    {
        return data%2 != 0;
    }

    public static void oddEvenSortList()
    {
        ListNode p = head;
        head = null;
        // 1->2->3->4->5
        ListNode oddStart = null;
        ListNode oddEnd = null;

        ListNode evenEnd = null;

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
        ListNode p = head;
        while (p!=null){
            System.out.print(p.data+" ");
            p=p.next;
        }


    }


    public static void main(String args[]){
        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        oddEvenSortList();
        printList();


    }




}
