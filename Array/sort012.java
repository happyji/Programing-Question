package Code;



public class Solution {

    public static void swap(int arr[],int x,int y){
        int temp = arr[x];
        arr[x]= arr[y];
        arr[y] = temp;
    }


    public static void sort012(int arr[])
    {
        int p0=0;
        int p1=0;
        int p2=arr.length-1;


        while (p1<p2)
        {
            if(arr[p1]==0)
            {
                swap(arr,p0,p1);
                p0++;
                p1++;

            }
            else if(arr[p1]==1)
            {
                p1++;
            }
            else
            {
                swap(arr,p2,p1);
                p2--;
            }
        }

    }

    public static void printArray(int[] arr){
        for(int i=0;i< arr.length;i++)
            System.out.print(arr[i]+" ");
    }

    public static void main(String args[]){
        int arr[] = {1,2,2,0,2,1,1,1,2,0,1,2,1,0};
        sort012(arr);
        printArray(arr);

    }

}
