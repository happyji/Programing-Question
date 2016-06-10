package Code;

/*
        {1,2,3,4,3,2}
        {5,6,7,8,9,10,11,12,13,14,12,10,8,4,2}

 */


public class Solution {

    public static int getTopElementIncDec(int arr[])
    {
        int low=0;
        int high = arr.length-1;

        while (low<high)
        {
            int mid = (low+high)/2;

            if(arr[mid-1]<arr[mid] && arr[mid]>arr[mid+1]) // when both left and right child are smaller than the mid .. return mid
            {
                return mid;
            }
            else if(arr[mid-1] < arr[mid] && arr[mid] < arr[mid+1]) //check if it is increasing port 
            {
                low = mid +1;
            }
            else{
                high = mid-1;
            }


        }


        return -1;

    }



    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,5,2};
        int indx = getTopElementIncDec(arr);
        if(indx ==-1) System.out.println("not found");
        else  System.out.println(arr[indx]);

    }
}
