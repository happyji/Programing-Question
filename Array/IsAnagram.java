package Code;



public class Solution {

    public static boolean isAnagram(String str1,String str2){
        int [] lookup = new int[256];

         //step 1 : non- equal string will never make a anagrams
        if(str1.length() != str2.length()) return false; 

        /*  step 2
            parse one array 
            - maintaining letter count
            - making track is asci value lookup
        */
        int letterCount=0;
        int index=0;
        for(int i=0;i< str1.length();i++)
        {
            index = (int)str1.charAt(i);
            lookup[index]++;
            letterCount++;
        }


        /*
            step 3: 
            parse another array 
            - decreasing letter count
            - decreasing asci lookup count
            - note if lookup is inconsistent .. not a anagram
        */
        for(int i=0;i< str2.length();i++)
        {
            index = (int)str2.charAt(i);
            if(lookup[index] >0)
            {
                lookup[index]--;
                letterCount--;
            }
            else
            return false;

        }

        // step 4: letter count should be reset to be zero to become a anagram
        return (letterCount==0);
    }


    public static void main(String args[]){
        String str1 = "prashant";
        String str2 = "staanhpr";

        str1 = "aaaaaa";
        str2 = "bbbbbb";

        str1 = "aaaaaa";
        str2 = "aaaaaa";

        str1 = "naveen";
        str2 = "";

        str1 = "LOL";
        str2 = "LLo";

        System.out.println(isAnagram(str1,str2));
    }




}
