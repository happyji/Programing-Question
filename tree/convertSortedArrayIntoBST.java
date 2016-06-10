package Code;

class Node{
    int data;
    Node left;
    Node right;

    Node(int x){
        data = x;
        left = null;
        right = null;
    }
}

public class Solution {

    public static Node root;

    public static Node convertSortedArrayIntoBST(int arr[],int low,int high)
    {
        Node p = null;

        if (low<= high)
        {
            int m= (low+high)/2;
            p = new Node(arr[m]);
            p.left  = convertSortedArrayIntoBST(arr, low, m-1);
            p.right = convertSortedArrayIntoBST(arr, m+1, high);
        }

        return p;

    }

    public static void InOrder(Node p)
    {
        if(p== null) return;

        InOrder(p.left);
        System.out.print(p.data+" ");
        InOrder(p.right);
    }


    public static void main(String args[]){
        int arr[] = {1,2,3,4,5,6,7,8};
        root = convertSortedArrayIntoBST(arr,0,arr.length-1);
        InOrder(root);
    }

}
