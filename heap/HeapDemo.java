package heap;




import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

class Heap<T extends Comparable<T>>
{
    private ArrayList<T>  items;

    Heap()
    {
        items = new ArrayList<T>();
    }

    private void shiftUp()
    {
        int k= items.size()-1;

        while (k>0)
        {
            int p = (k-1)/2;
            T item = items.get(k);
            T parent = items.get(p);

            if(item.compareTo(parent)>0)
            {
                items.set(k,parent);
                items.set(p,item);
            }
            else
                break;

        }

    }

    private void siftDown() {
        int k = 0;
        int l = 2*k+1;
        while (l < items.size())
        {
            int max=l,
            r=l+1;
            if (r < items.size())
            { // there is a right child
                if (items.get(r).compareTo(items.get(l)) > 0) {
                    max++;
                }
            }
            if (items.get(k).compareTo(items.get(max)) < 0) {
                // switch
                T temp = items.get(k);
                items.set(k, items.get(max));
                items.set(max, temp);
                k = max;
                l = 2*k+1;
            }
            else
            {
                break;
            }
        }
    }

    public int size() {
        return items.size();
    }

    public boolean isEmpty() {
        return items.isEmpty();

    }

    public String toString() {
        return items.toString();
    }


    public void insert(T item) {
        items.add(item);
        shiftUp();
    }


    public T delete()
            throws NoSuchElementException {
        if (items.size() == 0) {
            throw new NoSuchElementException();
        }
        if (items.size() == 1) {
            return items.remove(0);
        }
        T hold = items.get(0);
        items.set(0, items.remove(items.size()-1));
        siftDown();
        return hold;
    }
}




public class HeapDemo {

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
        Heap<Integer> heap = new Heap<>();
        heap.insert(4);
        heap.insert(14);
        heap.insert(34);
        heap.insert(42);
        heap.insert(6);
        heap.insert(18);
        heap.insert(5);

        while (!heap.isEmpty())
            System.out.print(heap.delete() + " ");
            System.out.println();

        List<Integer> list = Arrays.asList(12,11, 13, 5, 6, 7);
        for (int i= list.size()/2;i>=0;i--)
            maxHeapify(list,i);


        list.forEach(k->System.out.print(k + " "));

    }

}
