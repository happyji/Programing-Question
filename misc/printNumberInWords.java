package misc;

public class printNumberInWords {

    public  static String[] onesName = {"","one","two","three","four","five","six","seven","eight","nine"};
    public static  String[] teensName = {"ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};
    public static String[] tenName =   {"","Ten","twenty","thirty","fourty","fifty","sixty","seventy","eighty","ninety"};


    private static String geTwoDigitValue(int number)
    {
        String result;

        if(number < 10)
            result = onesName[number];
        else if(number > 10 && number < 20)
            result = teensName[number-10];
        else
            result = tenName[number/10] + " "+ onesName[number%10];


        return result;
    }



    public static void printNumberIntoWords(int x)
    {
        System.out.println();

        int number = x;

        while(number != 0)
        {
            if(number > 99999)
            {
                System.out.print(geTwoDigitValue(number / 100000)+" Lakh ");
                number = number % 100000;
            }
            else if(number > 999)
            {
                System.out.print(geTwoDigitValue(number / 1000)+" Thousand ");
                number = number % 1000;
            }
            else if(number> 99)
            {
                System.out.print(geTwoDigitValue(number / 100)+" Hundred ");
                number = number % 100;
            }
            else
            {
                System.out.print(geTwoDigitValue(number)+" only");
                number =0;
            }
        }
    }

    public static void main(String args[])
    {

        printNumberIntoWords(999999);
        printNumberIntoWords(191919);
        printNumberIntoWords(1919);
        printNumberIntoWords(20);
        printNumberIntoWords(961);




    }
}

