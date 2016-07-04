import java.util.*;

public class Solution {

    public static int getMinForSecond(int arr1[],int arr2[])
    {
        int i = arr1.length-1;
        int j = arr2.length-1;
        int count = arr2.length;
        int max = 0;

        while (count>0)
        {
            if(arr1[i] > arr2[j])
            {
                max = arr1[i];
                i--;
            }
            else
            {
                max = arr2[j];
                j--;
            }
            count--;

        }

        return max;

    }

    public static void swap(int arr1[],int arr2[],int x,int y)
    {
        int temp = arr1[x];
        arr1[x] = arr2[y];
        arr2[y] = temp;

    }

    public static void putElementinRespectiveArr(int arr1[],int arr2[],int key)
    {
        int i=0;
        int j=0;

        while (true)
        {
            while (i< arr1.length && arr1[i] < key)
            {
                i++;
            }
            while ( j < arr2.length && arr2[j]> key)
            {
                j++;
            }

            if (i< arr1.length &&j < arr2.length )
            swap(arr1,arr2,i,j);
            else
            break;

            i++;
            j++;
        }

    }

    public static void print(int arr[])
    {
        System.out.println();
        for(int i=0;i< arr.length;i++)
        {
            System.out.print(arr[i]+" ");
        }
    }

    public static void main(String args[]){

        int arr1[] = {51};
        int arr2[] = {21};

        int max1 = getMinForSecond(arr1,arr2);
        putElementinRespectiveArr(arr1,arr2,max1);
        Arrays.sort(arr1);
        Arrays.sort(arr2);


        print(arr1);
        print(arr2);

    }




}
