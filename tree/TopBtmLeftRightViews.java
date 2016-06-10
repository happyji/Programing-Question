package Code;




import java.util.*;


class Node{
    int data;
    Node left;
    Node right;

    Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}


public class Solution {

    public static Node root;


    public static void printTopView()
    {
        Queue<Node> queue = new LinkedList<>();
        Queue<Integer> queueHD = new LinkedList<>();
        TreeMap<Integer,Node> map = new TreeMap<>();

        queue.offer(root);
        queueHD.offer(0);

        System.out.println();

        while (!queue.isEmpty())
        {
            Node p = queue.poll();
            int hd = queueHD.poll();

            if(!map.containsKey(hd))
                map.put(hd,p);

            if (p.left!= null)
            {
                queue.offer(p.left);
                queueHD.offer(hd-1);
            }

            if (p.right!= null)
            {
                queue.offer(p.right);
                queueHD.offer(hd+1);
            }

        }


        Set<Integer> keys = map.keySet();

        for (Integer key : keys)
            System.out.print(map.get(key).data + " ");
    }


    public static void printBtmView()
    {
        Queue<Node> queue = new LinkedList<>();
        Queue<Integer> queueHD = new LinkedList<>();
        TreeMap<Integer,Node> map = new TreeMap<>();

        queue.offer(root);
        queueHD.offer(0);

        System.out.println();
        while (!queue.isEmpty())
        {
            Node p = queue.poll();
            int hd = queueHD.poll();

            if(!map.containsKey(hd))
                map.put(hd,p);
            else
                map.replace(hd,p);

            if (p.left!= null)
            {
                queue.offer(p.left);
                queueHD.offer(hd-1);
            }

            if (p.right!= null)
            {
                queue.offer(p.right);
                queueHD.offer(hd+1);
            }

        }


        Set<Integer> keys = map.keySet();

        for (Integer key : keys)
            System.out.print(map.get(key).data+" ");
    }

    public static void printLeftView()
    {
        Queue<Node> queue = new LinkedList<>();
        Node delimiter = new Node(Integer.MIN_VALUE);
        Node q= null;
        queue.offer(root);
        queue.offer(delimiter);

        System.out.println();
        while (!queue.isEmpty())
        {

            Node p = queue.poll();

            if(p.data== Integer.MIN_VALUE)
            {
                System.out.print(q.data + " ");
                if(!queue.isEmpty())
                queue.offer(p);
            }

            if (p.right!= null)
            {
                queue.offer(p.right);
            }

            if (p.left!= null)
            {
                queue.offer(p.left);
            }


            q = p;
        }


    }

    public static void printRightView()
    {
        Queue<Node> queue = new LinkedList<>();
        Node delimiter = new Node(Integer.MIN_VALUE);
        Node q= null;
        queue.offer(root);
        queue.offer(delimiter);

        System.out.println();
        while (!queue.isEmpty())
        {

            Node p = queue.poll();

            if(p.data== Integer.MIN_VALUE)
            {
                System.out.print(q.data+" ");
                if(!queue.isEmpty())
                    queue.offer(p);
            }

            if (p.left!= null)
            {
                queue.offer(p.left);
            }

            if (p.right!= null)
            {
                queue.offer(p.right);
            }




            q = p;
        }


    }



    public static void main(String args[]){
        root = new Node(50);

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


        printTopView();

        printBtmView();

        printLeftView();

        printRightView();



    }




}
