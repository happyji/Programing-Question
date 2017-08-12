package Code;
import java.util.*;



public class LIS {

    public static int LIS(int arr[])
    {
        int LIS[] =  new int[arr.length];
        Arrays.fill(LIS,1);
        int max = 1;

        for(int i=1; i< arr.length;i++)
        {
            for(int j=0;j< i;j++)
            {
                if(arr[j]< arr[i])
                {
                   arr[i] = Math.max(arr[i],1+arr[j]);
                   if(arr[i] > max)
                       max = arr[i];
                }
            }

        }

        return max;
    }

    public static void main(String args[]){
        int arr[] = {1,2,1,2,3,3,1};
        System.out.println(LIS(arr));


    }




}
