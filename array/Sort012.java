package array;



public class Sort012 {

    public static void swap(int arr[],int x,int y){
        int temp = arr[x];
        arr[x]= arr[y];
        arr[y] = temp;
    }


    public static void sortColors(int[] nums) {
        int i=0;
        int j=0;
        int k = nums.length -1;

        while(i <= k && j <= k){

            //step1 : decrement k till it's value is 2
            while(k>=0 && nums[k] == 2){
                k--;
            }
            //step2:  swap k with i
            swapc(nums,k,i);

            //step1 : swap i if it's value is 0
            if(i< nums.length && nums[i] == 0){
                swapc(nums,i,j);
                j++;
            }

            i++;

        }


    }

    public static void swapc(int[] nums,int x,int y){
        if(x<0 || y<0 || x<y){
            return;
        }
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;

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
        //sort012(arr);
        //printArray(arr);
        sortColors(arr);
        printArray(arr);

    }

}
