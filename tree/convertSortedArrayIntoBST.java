package tree;


public class convertSortedArrayIntoBST {

    public static tree.common.Node root;

    public static tree.common.Node convertSortedArrayIntoBST(int arr[], int low, int high)
    {
        tree.common.Node p = null;

        if (low<= high)
        {
            int m= (low+high)/2;
            p = new tree.common.Node(arr[m]);
            p.left  = convertSortedArrayIntoBST(arr, low, m-1);
            p.right = convertSortedArrayIntoBST(arr, m+1, high);
        }

        return p;

    }

    public static void InOrder(tree.common.Node p)
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
