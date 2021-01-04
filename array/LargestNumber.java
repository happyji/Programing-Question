package array;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LargestNumber {

    public String largestNumber(int[] nums) {

        //51
        //632
        //631

        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());

        Collections.sort(list,(t1, t2)->{
            String num1 = String.valueOf(t1);
            String num2 = String.valueOf(t2);

            int i=0;
            while(i< num1.length() || i<num2.length()){
                if(getData(num1,i) == getData(num2,i)){
                    i++;
                }else{
                    return (getData(num2,i) - getData(num1,i));
                }
            }
            return 0;

        });

        return String.join(",",nums);

    }

    int getData(String arr,int index){
        if(index>=0 || index< arr.length()){
            return arr.charAt(index);
        }
        return -1;
    }
}
