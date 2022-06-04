import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Problem_8_5 {

    // COMPUTE BUILDINGS WITH A SUNSET VIEW

    // You are given with a series of buildings that have windows facing west. The buildings
    //are in a straight line, and any building which is to the east of a building of equal or
    //greater height cannot view the sunset.
    //Design an algorithm that processes buildings in east-to-west order and returns the
    //set of buildings which view the sunset. Each building is specified by its height.
    // Retun by Index

    // Ex : [6,3,4] --> Ans: [2,0]
    // W                E
    // 6            |
    // 5            |
    // 4    |       |
    // 3    |   |   |
    // 2    |   |   |
    // 1    |   |   |
    //      4   3   6

    // Now here 3 would not be answer as 4 is blocking sunset view

    public static void main(String[] args) {
        try{
            int[] buildings = new int[]{6,3,4,7};
            System.out.println(Arrays.toString(getSunsetBuildings(buildings)));
        }catch (Exception e)
        {

        }

    }


    // Time 0(n)
    public static int[] getSunsetBuildings(int[] buildings)
    {
        if(buildings.length==0)
        {
            return new int[]{};
        }
        Deque<Integer> stack = new LinkedList<>();
        int ansSize = 0;
        for (int i = 0; i < buildings.length; i++) {

            if(stack.isEmpty())
            {
                stack.addFirst(i);
                ansSize++;
            }
            else
            {
                // if building height is greater then prev one then it means prev building would not get sunset
                while(!stack.isEmpty() && buildings[i]>buildings[stack.peek()])
                {
                    stack.removeFirst();
                    ansSize--;
                }

                // now then add current building as we removed all possible not getting sunset view buildings
                stack.addFirst(i);
                ansSize++;


            }
        }

        int[] sunsetBuilding = new int[ansSize];
        for (int i = 0; i < sunsetBuilding.length; i++) {
            sunsetBuilding[i] = stack.removeFirst();
        }

        return sunsetBuilding;
    }
}
