package list;

import java.util.Stack;


public class AlterListFirstLast {



    public static ListNode getAlterList(ListNode root)
    {
        if(root == null) return null;

        ListNode last= null;
        Stack<ListNode> stack = new Stack<>();
        ListNode p = root;
        ListNode q = root;

        while (true)
        {
            if(q == null)
                break;

            if(q.next == null)
                break;

            stack.push(p);
            q=q.next.next;
            p = p.next;
        }

        if(q != null)
        {
            last = p;
            p = p.next;
            last.next = null;
        }

        while (!stack.isEmpty())
        {
            ListNode a = stack.pop();
            ListNode b = p;
            a.next = b;

            p = p.next;
            b.next = last;

            last = a;
        }

        return last;

    }

    public static void printList(ListNode root)
    {
        ListNode p = root;
        System.out.println();
        while (p!= null)
        {
            System.out.print(p.data + " ");
            p=p.next;
        }

    }


    public static void main(String args[])
    {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);
        root.next.next.next.next.next = new ListNode(6);
        root.next.next.next.next.next.next = new ListNode(7);

        printList(root);
        root = getAlterList(root);
        printList(root);

    }
}

