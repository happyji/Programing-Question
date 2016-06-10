package Code;

import java.util.Stack;

public class Solution {

    
    public static Character [] hmap = {'a','a','b','c','d','e','f',
                                        'g','h','i','j','k','l',
                                         'm','n','o','p','q','r',
                                         's','t','u','v','w','x',
                                         'y','z'};

    public static void printPattern(String str, int number){

        if(number == 0){
            System.out.println(str);
            return;
        }

        printPattern(hmap[number%10]+str,number/10);
        if(number%100 >9 && number%100 <27)
        printPattern(hmap[number%100]+str,number/100);
    }


   

    public static void main(String args[]){
       
        System.out.println("print pattern for "+ 1231);
        printPattern("",1231);

        System.out.println("print pattern for "+ 724);
        printPattern("",724);

       
       
    }

}
