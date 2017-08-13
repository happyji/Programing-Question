package Code;

/*
    min(lmax[i],rmax[i])- arr[i]

 */



public class BuildingWaterTrap {


    public static void buildingWaterTrap(int arr[])
    {
        int lmax[] = new int[arr.length];
        int rmax[] = new int[arr.length];

        int max=-1;
        for(int i=0;i<arr.length;i++)
        {
            lmax[i] = max;
            if(arr[i]>max) max= arr[i];
        }

        max=-1;
        for(int i=arr.length-1;i>=0;i--)
        {
            rmax[i] = max;
            if(arr[i]>max) max= arr[i];
        }

        int totalTrap=0;
        for(int i=1;i< arr.length;i++)
        {
            int trap = Math.min(lmax[i],rmax[i])-arr[i];
            if(trap>0)  totalTrap+= trap;
        }

        System.out.println(totalTrap);
    }



    public static void main(String args[]){
        //int arr[]={1,4,3,2,3};
        int arr[] = {0,1,0,2,1,0,1,3,2,1,2,1};
        buildingWaterTrap(arr);
    }




}
