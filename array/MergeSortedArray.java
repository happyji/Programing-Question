package array;

/*

 */


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class HeapNode
{
    int data;
    int[] reff;
    int index;


    HeapNode(int d, int[] r,int idx){
        this.data = d;
        this.reff =r;
        this.index = idx;
    }
}

public class MergeSortedArray {

    public static PriorityQueue<HeapNode> heap;

    public static Comparator<HeapNode> comparator = new Comparator<HeapNode>(){
        @Override
        public int compare(HeapNode c1, HeapNode c2) {
            return (int) (c1.data - c2.data);
        }
    };


    public static void main(String args[]){
        int a0[] = {1,2,5,9};
        int a1[] = {3,4};
        int a2[] = {5,10};
        int a3[] = {4};

        PriorityQueue<HeapNode> heap = initHeap(a0, a1, a2, a3);

        List<Integer> outputList = new ArrayList<>();
        HeapNode current;
        int[] currentArr;
        int nextIndx;

        while (!heap.isEmpty())
        {
           current = heap.poll();
           outputList.add(current.data);
           nextIndx = current.index+1;
           currentArr = current.reff;

           if(nextIndx < currentArr.length)
           {
               current.data = currentArr[nextIndx];
               current.index = nextIndx;
               current.reff = currentArr;
               heap.add(current);
           }
        }

        outputList.forEach((i)->System.out.print(i + " "));


    }

    private static PriorityQueue<HeapNode> initHeap(int[] a0, int[] a1, int[] a2, int[] a3) {
        PriorityQueue<HeapNode> heap = new PriorityQueue<>(comparator);
        heap.add(new HeapNode((int)a0[0],a0,0));
        heap.add(new HeapNode((int)a1[0],a1,0));
        heap.add(new HeapNode((int)a2[0],a2,0));
        heap.add(new HeapNode((int)a3[0],a3,0));
        return heap;
    }


}
