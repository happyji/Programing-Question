package Code;


/*
    Input :
    A1[] = {2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8}
    A2[] = {2, 1, 8, 3}

    Output:
    A1[] = {2, 2, 1, 1, 8, 8, 3, 5, 6, 7, 9}

    2 -2   del
    1 -2   del
    8 -2   del
    5 -1
    7 -1
    9 -1
    3 -1  del
    6 -1

    5 -1
    7 -1
    9 -1
    6 -1

    2 2 1 1 8 8 3 5 6 7 9
*/
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class Solution {

    public static void main(String args[]){

        int a1[] = {2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8};
        int a2[] = {2, 1, 8, 3};
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0; i< a1.length;i++)
        {
            if(map.containsKey(a1[i]))          // get count of every element
            {
                int value = map.get(a1[i]);
                map.replace(a1[i],++value);
            }
            else {
                map.put(a1[i],1);
            }
        }

        int value =0;
        int k=0;
        for(int i=0;i< a2.length;i++)
        {
            if(map.containsKey(a2[i]))       // put all data from hash map to array
            {
                value = map.get(a2[i]);

                for(int j=0;j< value;j++)
                {
                    a1[k] = a2[i];
                    k++;
                }
                map.remove(a2[i]); // keep removing element
            }

        }

        TreeMap<Integer,Integer> sortedMap = new TreeMap(); // remainging elements are sorted
        sortedMap.putAll(map);

        Iterator itrsorted = sortedMap.entrySet().iterator();

        while (itrsorted.hasNext())
        {

            Map.Entry entry = (Map.Entry)itrsorted.next();
            int key = (int)entry.getKey();
            int entryvalue = (int)entry.getValue(); // put remainning element into the array
            for(int i=0;i< entryvalue;i++)
            {
               a1[k]= key;
                k++;
            }
        }

        for(int i=0; i<a1.length;i++){
            System.out.print(a1[i]+" ");
        }

    }




}
