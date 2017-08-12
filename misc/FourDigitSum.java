package Code;




public class FourDigitSum {


    public static int fourDigitSum(String digit)
    {
        int sum= 0;
        int mf = 1000;
        String strArr[] = digit.split(" ");

        while (mf!= 0)
        {
            for(int i=0; i< strArr.length;i++)
            {
                if(!(strArr[i]=="0" && mf==1000))
                sum += (Integer.parseInt(strArr[i])*mf);
            }
            mf /= 10;

        }


         return sum;
    }




    public static void main(String args[]){

        String str = new String("4021");
        System.out.println(fourDigitSum(str));

    }




}
