package Code;


import java.util.Arrays;
import java.util.List;




public class Solution {

    public static void maxHeapify(List<Integer> items,int k)
    {
        int largest = k;
        int l = 2*k + 1;
        int r = 2*k + 2;

        if(l < items.size() && items.get(l) > items.get(largest))
            largest = l;

        if(r < items.size() && items.get(r) > items.get(largest))
            largest = r;


        if(largest!=k)
        {
            //swap
            Integer temp = items.get(largest);
            items.set(largest,items.get(k));
            items.set(k,temp);

            maxHeapify(items, largest);
        }
    }

    public static void main(String args[]){
        List<Integer> list = Arrays.asList(12,11, 13, 5, 6, 7);
        for (int i= list.size()/2;i>=0;i--)
            maxHeapify(list,i);


        list.forEach(k->System.out.print(k + " "));

    }

}
