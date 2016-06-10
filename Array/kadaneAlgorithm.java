package Code;

//kadane algorithm
public class Solution {

    public static int maxSum(int[] arr) {
        if(arr.length == 1)
            return arr[0];

        int result=arr[0];
        int sum= arr[0];

        for(int i=1;i< arr.length;i++)
        {
            sum = Math.max(arr[i],sum+arr[i]);

            if(sum > result)
                result  = sum;

        }
        return result;
    }

    public static int maxProduct(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        int maxproduct = 1;
        int minProduct = 1;
        int result = 0;
        for (int i = 0; i < nums.length; i++) 
        {
            if (nums[i] >= 0) 
            {
                maxproduct = Math.max(maxproduct * nums[i], nums[i]);
                minProduct = Math.min(minProduct * nums[i], nums[i]);
            }
            else
            {
                int temp = maxproduct;
                maxproduct = Math.max(minProduct * nums[i], nums[i]);
                minProduct = Math.min(temp * nums[i], nums[i]);

            }
            if (maxproduct > result) {
                result = maxproduct;
            }
        }
        return result;
    }


    public static void main(String args[]){
        int arr[] =  {-2, 1, -3, 4, -1, 2,1};
        System.out.println(maxProduct(arr));
        System.out.println(maxSum(arr));

    }

}
