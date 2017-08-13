package list;

import java.util.Stack;


public class AlterListFirstLast {



    public static Node getAlterList(Node root)
    {
        if(root == null) return null;

        Node last= null;
        Stack<Node> stack = new Stack<>();
        Node p = root;
        Node q = root;

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
            Node a = stack.pop();
            Node b = p;
            a.next = b;

            p = p.next;
            b.next = last;

            last = a;
        }

        return last;

    }

    public static void printList(Node root)
    {
        Node p = root;
        System.out.println();
        while (p!= null)
        {
            System.out.print(p.data + " ");
            p=p.next;
        }

    }


    public static void main(String args[])
    {
        Node root = new Node(1);
        root.next = new Node(2);
        root.next.next = new Node(3);
        root.next.next.next = new Node(4);
        root.next.next.next.next = new Node(5);
        root.next.next.next.next.next = new Node(6);
        root.next.next.next.next.next.next = new Node(7);

        printList(root);
        root = getAlterList(root);
        printList(root);

    }
}

