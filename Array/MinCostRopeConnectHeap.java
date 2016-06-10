package Code;


import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {

   public static Integer getMinCostRopeConnect(List arr)
   {
       PriorityQueue<Integer> minHeap = new PriorityQueue<>();
       minHeap.addAll(arr);
       Integer cost =0;

       while (minHeap.size()>1){
           int element = minHeap.poll()+minHeap.poll();
           cost += element;
           minHeap.add(element);
       }

       return cost;
   }





    public static void main(String args[]){
        List<Integer> list = Arrays.asList(4,3,2,6);
        System.out.println(getMinCostRopeConnect(list));

    }




}
