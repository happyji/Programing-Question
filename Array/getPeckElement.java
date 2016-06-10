package Code;

/*
        {1,2,3,4,3,2}
        {5,6,7,8,9,10,11,12,13,14,12,10,8,4,2}

 */


public class Solution {

    public static int findPeakElement(int arr[])
    {
        int low=0;
        int high = arr.length-1;
        int mid =0;

        if(arr.length ==1) return 0;
        if(arr.length ==2) return arr[0] > arr[1] ? 0 : 1;


        while (low<high){
            mid = (low+ high)/2;

            // if mid element is not smalller than any of it member then its peak
            if(mid == 0 && arr[mid+1]<arr[mid])   //first element then only right element is to caompared
            {
                return mid;
            }
            else if(mid == arr.length-1 && arr[mid-1]< arr[mid]){     //last element then only left element is to be compared
                return mid;
            }
            else if(arr[mid-1]<arr[mid] && arr[mid+1]<arr[mid]){      // peak element
                return mid;
            }
            
            // if right element is greater then there exist a peak element in right part
            else if(arr[mid+1]>arr[mid]){
                low = mid+1;
            }
            // if left element is greater then there exist a peak element in left part
            else {
                high = mid-1;
            }

        }


        return -1;

    }



    public static void main(String[] args) {
        //int arr[] = {1,2,3,4,5,6,5,2};   //    happy case
        //int arr[] = {1,2,3,4,5,6,7};   // increasing
        //int arr[] ={8,7,6,5,4,3,2,1};      //decreasing
        //int arr[] = {23,4,56,7,7,7,7,7,7,7,7,7,9};
        int arr[] = {4,11};

        int indx = findPeakElement(arr);
        if(indx ==-1) System.out.println("not found");
        else  System.out.println(arr[indx]);

    }
}
