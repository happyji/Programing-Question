package Code;


public class Solution {

    public static void permutate(String prefix,String str)
    {
        int n = str.length();
        if(n==0) System.out.println(prefix);
        else
        {
            for(int i=0;i< n;i++)
            {
                permutate(prefix+str.charAt(i),
                            str.substring(0,i)+str.substring(i+1,n));
            }
            
        }
        
        
    }
    
    
    public static void main (String[] args) throws java.lang.Exception
    {
        String str = "abc";
        permutate("",str);
        
    }
}
