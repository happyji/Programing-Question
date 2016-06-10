package Code;

/*
    -level order traversal     (recursive, iterative)
    - reverse level order traversal  (recursive, iterative)
    -spiral order traversal    (recursive, iterative)
 */


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


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

    public static void levelOrderTraversal(){
        Node p = root;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        Node delimit = new Node(Integer.MAX_VALUE);
        queue.offer(delimit);

        System.out.println("Printing level order : ");
        while (!queue.isEmpty()){

            p = queue.poll();
            if(p.data==Integer.MAX_VALUE){
                System.out.println();
                if(!queue.isEmpty())
                queue.offer(p);
            }
            else {
                System.out.print(p.data + " ");
                if(p.left!= null) queue.offer(p.left);
                if(p.right!= null) queue.offer(p.right);

            }

        }
    }

    public static void reverseLevelOrderTraversal(){
        Node p = root;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        Node delimit = new Node(Integer.MAX_VALUE);
        queue.offer(delimit);

        System.out.println("Printing level order : ");
        while (!queue.isEmpty()){

            p = queue.poll();
            if(p.data==Integer.MAX_VALUE){
                System.out.println();
                if(!queue.isEmpty())
                    queue.offer(p);
            }
            else {
                System.out.print(p.data + " ");
                if(p.left!= null) queue.offer(p.left);
                if(p.right!= null) queue.offer(p.right);

            }

        }
    }

    public static int getHeight(Node p){
        if(p==null) return -1;
        int lHeight = getHeight(p.left);
        int rHeight = getHeight(p.right);
        return Math.max(lHeight,rHeight)+1;
    }

    static  public void printAtGivenLevel(Node p, int level){
        if(p== null) return;
        
        if(level == 0){
            System.out.print(p.data + " ");
            return;
        }
        else
        {
            printAtGivenLevel(p.left,level-1);
            printAtGivenLevel(p.right,level-1);
        }

    }


    public static void recursiveLevelOrderTraversal(){
        System.out.println("recursive level order traversal : ");
        int height = getHeight(root);
        for(int i=0;i<= height;i++){
            printAtGivenLevel(root,i);
            System.out.println();
        }

    }

    public static void reverseRecursiveLevelOrderTraversal(){
        System.out.println("recursive level order traversal : ");
        int height = getHeight(root);
        for(int i=height;i>=0;i--){
            printAtGivenLevel(i,root);
            System.out.println();
        }

    }


    public static void spiralOrder(){
        Node p = root;
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        stack1.push(p);


        System.out.println("Printing spiral order : ");
        while (!stack1.isEmpty() || !stack2.isEmpty())
        {
            while (!stack1.isEmpty()){
                p = stack1.pop();
                System.out.print(p.data+" ");
                if(p.right!= null) stack2.push(p.right);
                if(p.left!= null) stack2.push(p.left);
            }
            System.out.println();

            while (!stack2.isEmpty()){
                p = stack2.pop();
                System.out.print(p.data+" ");
                if(p.right!= null) stack1.push(p.left);
                if(p.left!= null) stack1.push(p.right);
            }
            System.out.println();
        }


    }

    public static void printAlternateLevel(int level,Node p,boolean flag){
        if(p == null|| level<0) return;
        if(level==0 )System.out.print(p.data + " ");

        if(flag){
            printAlternateLevel(level-1,p.right,flag);
            printAlternateLevel(level-1,p.left,flag);
        }
        else
        {
            printAlternateLevel(level-1,p.left,flag);
            printAlternateLevel(level-1,p.right,flag);
        }

    }

    public static void recursiveSpiralOrder(){
        System.out.println("recursive spiral order traversal : ");
        int height = getHeight(root);
        for(int i=0;i<= height;i++){
            printAlternateLevel(i,root,false);
            System.out.println();
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

        levelOrderTraversal();
        recursiveLevelOrderTraversal();



        reverseLevelOrderTraversal();
        reverseRecursiveLevelOrderTraversal();

        spiralOrder();
        recursiveSpiralOrder();



    }




}
