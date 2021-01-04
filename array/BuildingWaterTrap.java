package array;

/*
    min(lmax[i],rmax[i])- arr[i]

 */



public class BuildingWaterTrap {

    public static int trap(int[] height) {
        int n = height.length;

        int max = Integer.MIN_VALUE;
        int[] leftmax = new int[n];
        for(int i=0;i< n;i++){
            max = Math.max(height[i],max);
            leftmax[i] = max;
        }


        max = Integer.MIN_VALUE;
        int[] rightmax = new int[n];
        for(int i=n-1;i>=0;i--){
            max = Math.max(height[i],max);
            rightmax[i] = max;
        }

        int sum = 0;
        int result = 0;
        for (int i=1;i< height.length;i++){
            int x = Math.min(leftmax[i],rightmax[i]) - height[i];
            if(x>0){
                sum += x;
            }
            if(sum> result){
                result = sum;
            }
        }

        System.out.println(result);
        return result;

    }



    public static void main(String args[]){
        //int arr[]={1,4,3,2,3};
        int arr[] = {0,1,0,2,1,0,1,3,2,1,2,1};
        trap(arr);
    }




}
