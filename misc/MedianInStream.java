package Code;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

    private static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());


    private static void InItHeap(Queue queue)
    {
        Integer x = (Integer)queue.poll();
        Integer y = (Integer)queue.poll();

        if(x>y){
            minHeap.add(x);
            maxHeap.add(y);
        }
        else {
            minHeap.add(y);
            maxHeap.add(x);
        }

    }

    public static void printMedian()
    {
        int median = minHeap.size() > maxHeap.size() ? minHeap.peek() : maxHeap.peek();
        System.out.println(" = "+median);
    }



    public static void main(String args[])
    {
        Queue<Integer> queue = new LinkedList<>();
        InItQueue(queue);
        if(queue.size() > 2)
            InItHeap(queue);

        while (!queue.isEmpty()){

            int current = queue.poll();
            if(current< maxHeap.peek())
                maxHeap.add(current);
            else
                minHeap.add(current);


            int minHeapSize = minHeap.size();
            int maxHeapSize = maxHeap.size();
            if(Math.abs(maxHeapSize-minHeapSize) >1 )
            {
                if(maxHeapSize> minHeapSize)
                minHeap.add(maxHeap.poll());
                else
                maxHeap.add(minHeap.poll());
            }

            maxHeap.forEach(i->System.out.print(i+" "));
            minHeap.forEach(i->System.out.print(i+" "));
            printMedian();

        }



    }

    private static void InItQueue(Queue<Integer> queue) {
        queue.add(240);
        queue.add(23);
        queue.add(67);
        queue.add(1);
        queue.add(367);
        queue.add(45);
        queue.add(98);
    }
}

