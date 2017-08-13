package tree;

/*
       Tree operation :
       - count
       - height
       - preorder recursive + iterative
       - inorder  recursive + iterative
       - postorder recursive + iterative
      
 */


import java.util.Stack;



public class DepthFirstSearchTreeTraversal {


    public static void preOrder(tree.common.Node p){
        if(p== null) return;
        System.out.print(p.data + " ");
        preOrder(p.left);
        preOrder(p.right);
    }

    public static void nonRecursivePrePreorder(){
        Stack<tree.common.Node> stack = new Stack();
        tree.common.Node p = root;
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

    public static void inOrder(tree.common.Node p){
        if(p== null) return;
        inOrder(p.left);
        System.out.print(p.data + " ");
        inOrder(p.right);
    }


    public static void nonRecursiveInOrder(){
        Stack<tree.common.Node> stack = new Stack<>();
        tree.common.Node p= root;
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


    public static void postOrder(tree.common.Node p){
        if(p== null) return;
        postOrder(p.left);
        postOrder(p.right);
        System.out.print(p.data + " ");
    }

    public static void nonRecursivePostOrder(){
        Stack<tree.common.Node> stack = new Stack<>();
        Stack<Boolean> visited = new Stack<>();
        tree.common.Node p = root;
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



    public static int count(tree.common.Node p){
        if(p== null) return 0;
        int lcount =count(p.left);
        int rcount = count(p.right);
        return lcount+rcount+1;
    }


    public static int height(tree.common.Node p){
        if(p== null) return -1;
        int lhgt =height(p.left);
        int rhgt = height(p.right);
        return Math.max(lhgt,rhgt)+1;
    }

     public static int getHeight(){
        Stack<tree.common.Node> stack = new Stack<>();
        stack.push(root);
        tree.common.Node p = root;
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



    public static tree.common.Node root;

    public static void main(String args[]){
        root = new tree.common.Node(50);

        root.left = new tree.common.Node(25);
        root.left.left = new tree.common.Node(12);
        root.left.right = new tree.common.Node(30);
        root.left.left.left = new tree.common.Node(7);
        root.left.left.right = new tree.common.Node(20);

        root.right = new tree.common.Node(70);
        root.right.left = new tree.common.Node(60);
        root.right.right = new tree.common.Node(80);
        root.right.left.left = new tree.common.Node(55);
        root.right.left.right = new tree.common.Node(65);

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
