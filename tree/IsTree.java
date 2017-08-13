package tree;

import java.util.Stack;
import tree.common.Node;



public class IsTree {

    public static Node root;
    public static Node root1;
    public static Node lastNode = new tree.common.Node(Integer.MIN_VALUE);

    public static boolean isIdentical(tree.common.Node p, tree.common.Node q){


        if(p==null && q == null) return true;

        if(p!=null && q!= null)
        return (p.data == q.data &&
            isIdentical(p.left,q.left) &&
            isIdentical(p.right,q.right));

        return false;

    }

    public static boolean isMirror(tree.common.Node p, tree.common.Node q){
        if(p== null&& q==null)
            return true;

        if(p!=null && q!= null)
            return (p.data == q.data &&
                    isMirror(p.left,q.right) &&
                    isMirror(p.right,q.left));


        return false;
    }

    public static boolean isBST(tree.common.Node root){
        tree.common.Node p = root;
        Stack<tree.common.Node> stack = new Stack<>();


        while (p!= null){
            stack.push(p);
            p=p.left;
        }

        while (!stack.isEmpty()){
            p = stack.pop();

            if(lastNode.data > p.data) return false;

            lastNode = p;
            p= p.right;

            while (p!= null){
                stack.push(p);
                p=p.left;
            }
        }


        return true;
    }


    public static boolean isRecursiveBST(tree.common.Node p, int low, int high){

        if(p== null) return true;

        if(p.data>low && p.data< high
                && isRecursiveBST(p.left, low, p.data)
                && isRecursiveBST(p.right, p.data, high)) {
            return true;
        }

        return false;
    }

    public static int getHeight(tree.common.Node p){
        if(p== null) return -1;

        int lheight = getHeight(p.left);
        int rheight = getHeight(p.right);

        return Math.max(lheight,rheight)+1;

    }


    public static boolean isBalancedBst(tree.common.Node p){

        if(p== null) return true;

        int heightLeft = getHeight(p.left);
        int heightRight = getHeight(p.right);

        if(Math.abs(heightRight-heightLeft)<2 &&
                isBalancedBst(p.left) &&
                isBalancedBst(p.right)){
            return  true;
        }


        return false;
    }

    public static boolean isSubTree(tree.common.Node p, tree.common.Node s){



        if(isIdentical(p,s)) return true;

        return (isSubTree(p.left,s) || isSubTree(p.right,s));


    }


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
        root.right.left.right = new tree.common.Node(85);


        root1 = new tree.common.Node(50);

        root1.left = new tree.common.Node(25);
        root1.left.left = new tree.common.Node(12);
        root1.left.right = new tree.common.Node(30);
        root1.left.left.left = new tree.common.Node(7);
        root1.left.left.right = new tree.common.Node(20);

        root1.right = new tree.common.Node(70);
        root1.right.left = new tree.common.Node(60);
        root1.right.right = new tree.common.Node(80);
        root1.right.left.left = new tree.common.Node(55);
        root1.right.left.right = new tree.common.Node(65);

        /*
        System.out.println(isIdentical(root,root1));


         //mirror test
        root1 = new Node(50);

        root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(3);


        root.right = new Node(2);
        root.right.right = new Node(3);

        root1 = new Node(1);
        root1.left = new Node(2);
        root1.left.left = new Node(3);


        root1.right = new Node(2);
        root1.right.right = new Node(3);

        System.out.println(isMirror(root,root1));

        root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(3);
        root.left.left.left = new Node(4);


        root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(3);
        root.left.left.left = new Node(4);*/

        //System.out.println(isBST(root1));
        //System.out.println(isRecursiveBST(root1,Integer.MIN_VALUE,Integer.MAX_VALUE));

        System.out.println(isBalancedBst(root));






    }




}
