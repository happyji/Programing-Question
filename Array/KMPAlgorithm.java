package Code;



public class Solution {





    public static void computeLPS(String str,int [] lps){
        int i=1;
        int j=0;
        lps[0] = 0;

        while (i< str.length())
        {
            if(str.charAt(i)==str.charAt(j))
            {
                lps[i] = j+1;
                i++;
                j++;
            }
            else {

                if(j!=0)
                {
                    j = lps[j-1];
                }
                else {
                    lps[i] = 0;
                    i++;
                }

            }
        }

    }




    public static void main(String args[]){
         String str = "abab";
         int [] lps = new int[str.length()];
        computeLPS(str,lps);
         int idx = lps[str.length()-1];
         System.out.println(idx);


    }
}
