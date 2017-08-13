package dynamicprogramming;

public class EggDrop {




    public static int eggDrop(int egg, int floor)
    {
        if (floor == 1 || floor == 0)
            return floor;

        if (egg == 1)
            return floor;

        int min = Integer.MAX_VALUE, x, res;

        for (x = 1; x <= floor; x++)
        {
            res = Math.max(eggDrop(egg-1, x-1), eggDrop(egg, floor-x));
            if (res < min)
                min = res;
        }

        return min + 1;
    }


    public static void main(String[] args) {
        System.out.println(eggDrop(2,100));
    }

}
