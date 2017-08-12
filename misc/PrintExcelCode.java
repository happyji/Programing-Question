package Code;


//Excel code
// 1  - A
// 10 - J
// 26 - Z    1 + 0
// 27 - AA   1 + 1
// 52 - AZ



public class PrintExcelCode {

    // this is git demo
    public static void printExcelCode(int number){

        char [] code = new char[50];
        int k=0;

        while (number!= 0)
        {
            int qt = number/26;
            int rem = number%26;

            if(rem==0){
                code[k] = 'Z';
                number = qt-1;
            }
            else{
                code[k] = (char)(rem+'@');
                number = qt;
            }

            k++;
        }
        code[k]='\0';

        System.out.println();
        for (int i= k-1;i>=0;i--)
            System.out.print(code[i]);

    }


    public static void main(String args[]){

        printExcelCode(26);
        printExcelCode(51);
        printExcelCode(52);
        printExcelCode(80);
        printExcelCode(676);
        printExcelCode(702);
        printExcelCode(705);
        printExcelCode(27);




    }




}
