package array;


/*
Given a string, find the first non-repeating character in it.


*/



public class FirstDuplicateIndex {

    public static int getFirstDuplicateIndex(char [] str)
    {
        int i=0;
        int key=0;
        boolean [] lookup = new boolean[256];
        while (i< str.length)
        {
            key = (int)str[i];
            if(lookup[key]==true) return i;
            else lookup[key] = true;

            i++;
        }

        return -1;
    }



    public static void main(String args[]){
       //String str = "facebook";
        //String str = "apple";
        //String str = "rajeshkumar";
        String str = "qwerty";
       char [] strArr = str.toCharArray();
       System.out.println(getFirstDuplicateIndex(strArr));



    }




}
