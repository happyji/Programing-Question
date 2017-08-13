package tree;

import tree.common.Node;

class InorderSuccessorInBST
{

    public static Node search(Node p, int key)
    {
        Node current = p;

        while(current!= null)
        {

            if(key==current.data)
            {
                return current;
            }
            else if(key < current.data)
            {
                current = current.left;
            }
            else
            {
                current = current.right;
            }
        }
        return null;

    }

    public static Node getDeepestNodeAsLeftChild(Node current,Node root)
    {
        Node p = root;
        Node succ = null;

        while(p != current)
        {
            if(current.data < p.data)
            {
                succ = p;
                p = p.left;
            }
            else
            {
                p = p.right;
            }
        }
        return succ;
    }


    public static Node getSmallest(Node p)
    {
        Node current = p;
        while(current.left !=null)
        {
            current = current.left;
        }
        return current;
    }


    public static Node getInOrderSuccessor(Node root,int key)
    {
        // O(h)
        Node current = search(root,key);

        if(current == null) return null;

        /*
            part 1 : right chid exist
            return the smallest valued node
            part 2 :

            1.access to parent pointer
            2.dnt have access to parent pointer

        */

        if(true)//current.isRightChildPresent())
        {
            return getSmallest(current.right);
        }
        else
        {
            return getDeepestNodeAsLeftChild(current,root);
        }


    }

    public static void main(String args[])
    {
        Node root = new Node(50);

        root.left = new Node(25);
        root.left.left = new Node(12);
        root.left.right = new Node(30);
        root.left.left.left = new Node(7);
        root.left.left.right = new Node(20);

        root.right = new Node(70);
        root.right.left = new Node(60);
        root.right.right = new Node(80);
        root.right.left.left = new Node(55);
        root.right.left.right = new Node(65);
        Node successor = getInOrderSuccessor(root,25);
        System.out.println(successor.data);

    }

}


