package array;


/*

Given an array and an integer k, find the maximum for each and every contiguous subarray of size k.

Examples:

Input :
arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6}
k = 3
Output :
3 3 4 5 5 5 6



Input :
arr[] = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13}
k = 4
Output :
10 10 10 15 15 90 90


*/

import java.util.Collections;
import java.util.PriorityQueue;





public class MaxWindowK {

    public static void printMinWindow(int[] arr,int k){
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        if(k>arr.length) return;

        for(int i=0;i< k;i++)
            heap.add(arr[i]);

        int i=k;

        while (true)
        {
            System.out.print(heap.peek() + " ");

            if(i>=arr.length) break;

            heap.remove(arr[i-k]);
            heap.add(arr[i]);
            i++;
        }

    }



    public static void main(String args[]){
       // int arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6};
        int arr[] = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13};

        printMinWindow(arr,4);
    }




}
