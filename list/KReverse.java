package list;




public class KReverse {

    public static ListNode head;

    // 1->2->3->4->5->6->7->8->9->10->11->12->13->14->15
    // 1
    // 1->2
    //1-> 2->3-> 4

    public static ListNode kReverse(ListNode h, int k)
    {
        ListNode p = h;
        ListNode q = null;
        ListNode r = null;

        int count = 0;
        // Try reversing the list , just keep count of reverse node
        while (p!= null && count < k)
        {
            r = p.next;
            p.next = q;
            q = p;
            p = r;
            count++;
        }

        // r which is the next node exist then repeat
        // Note :  h (which is incoming) will catch upcoming reversed node
        if(r!= null)
            h.next = kReverse(r,k);

        return q;
    }

    public static void buildList(int len)
    {
        ListNode preListNode = null;
        for(int i=1; i<= len ; i++)
        {
            ListNode n = new ListNode(i);
            if(head == null)
                head = n;
            else
                preListNode.next = n;


            preListNode = n;
        }
    }

    public static void printList(){
        ListNode p = head;

        while (p!= null)   {
            System.out.print(p.data+" ");
            p=p.next;
        }

    }

    public static void main(String args[]){
        System.out.println();
        buildList(11);
        printList();
        System.out.println();
        head = kReverse(head,3);
        printList();
    }




}
