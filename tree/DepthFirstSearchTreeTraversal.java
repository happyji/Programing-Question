package Code;

/*
       Tree operation :
       - count
       - height
       - preorder recursive + iterative
       - inorder  recursive + iterative
       - postorder recursive + iterative
      
 */


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


    public static void preOrder(Node p){
        if(p== null) return;
        System.out.print(p.data + " ");
        preOrder(p.left);
        preOrder(p.right);
    }

    public static void nonRecursivePrePreorder(){
        Stack<Node> stack = new Stack();
        Node p = root;
        System.out.println();

        while (p!=null){
            System.out.print(p.data + " ");
            stack.push(p);
            p=p.left;
        }


        while (!stack.isEmpty()){
            p = stack.pop();
            p=p.right;

            while (p!=null){
                System.out.print(p.data+" ");
                stack.push(p);
                p=p.left;
            }

        }
    }

    public static void inOrder(Node p){
        if(p== null) return;
        inOrder(p.left);
        System.out.print(p.data + " ");
        inOrder(p.right);
    }


    public static void nonRecursiveInOrder(){
        Stack<Node> stack = new Stack<>();
        Node p= root;
        System.out.println();

        while (p!= null){
            stack.push(p);
            p= p.left;
        }

        while (!stack.isEmpty()){
            p = stack.pop();
            System.out.print(p.data + " ");
            p= p.right;

            while (p!= null){
                stack.push(p);
                p= p.left;
            }

        }

    }


    public static void postOrder(Node p){
        if(p== null) return;
        postOrder(p.left);
        postOrder(p.right);
        System.out.print(p.data + " ");
    }

    public static void nonRecursivePostOrder(){
        Stack<Node> stack = new Stack<>();
        Stack<Boolean> visited = new Stack<>();
        Node p = root;
        Boolean isVisited;

        System.out.println();

        while (p!= null){
            stack.push(p);
            visited.push(false);
            p=p.left;
        }

        while (!stack.isEmpty()){

            p = stack.pop();
            isVisited =visited.pop();

            if(isVisited){
                System.out.print(p.data+" ");
                p= null;
            }
            else {
                stack.push(p);
                visited.push(true);
                p= p.right;
            }


            while (p!= null){
                stack.push(p);
                visited.push(false);
                p=p.left;
            }

        }

    }



    public static int count(Node p){
        if(p== null) return 0;
        int lcount =count(p.left);
        int rcount = count(p.right);
        return lcount+rcount+1;
    }


    public static int height(Node p){
        if(p== null) return -1;
        int lhgt =height(p.left);
        int rhgt = height(p.right);
        return Math.max(lhgt,rhgt)+1;
    }

     public static int getHeight(){
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        Node p = root;
        int index =0;
        int height = 0;

        while (p!= null){
            stack.push(p);
            p= p.left;
            index++;

            if(index>height) height= index;
        }

        while (!stack.isEmpty())
        {
            p = stack.pop();
            index--;
            p= p.right;


            while (p!= null){
                stack.push(p);
                p= p.left;

                index++;

                if(index>height) height= index;
            }


        }


        return height-1;
    }



    public static Node root;

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

        /*System.out.println("Count :"+count(root));
        inOrder(root);
        nonRecursiveInOrder();

        System.out.println();
        preOrder(root);
        nonRecursivePrePreorder();

        System.out.println();
        postOrder(root);
        nonRecursivePostOrder();*/

        System.out.println(height(root));







    }




}
