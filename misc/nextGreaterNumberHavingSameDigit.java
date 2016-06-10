package Code;
   //Given a no, find next no greater than n and having same digits.I was supposed to write a working code for this on paper.

/*
    45376   =  45673

    1111    =   -1

    4325    =   4352

    5432    =

 */



import java.util.Arrays;

public class Solution {

    public static void swap(char[] arr,int x,int y)
    {
        char temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }


    public static void main(String args[]){
       //int number = 45376;
        //int number = 1111;
        //int number = 4325;
        int number = 7654;


        int result = -1;

        System.out.println(number);

       char [] strNum = Integer.toString(number).toCharArray();

       int i= strNum.length-1;
       while (i>0)
       {
           if(strNum[i-1]<strNum[i])
               break;

           i--;
       }

       if(i> 0)
       {
           swap(strNum,i-1,strNum.length-1);

           Arrays.sort(strNum,i,strNum.length-1);

           result = Integer.parseInt(new String(strNum));
       }



       System.out.println(result);

    }




}
