import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Solution k = new Solution();
        int output2 = k.movingStuff(new int[]{70, 50, 80, 50}, 100);
        System.out.println(output2); // 3

        int output = k.movingStuff(new int[]{60, 80, 120, 90, 130}, 140);
        System.out.println(output); // 4
    }


}

class Solution {
    public int movingStuff(int[] stuff, int limit) {
        // TODO:
        int stuffWeight = 0 ;
        Arrays.sort(stuff);
        int left = 0;
        int right = stuff.length-1;
        while(left<right)
        {
            if(stuff[left]+stuff[right]<=limit)
            {
                left++;
                right--;
                stuffWeight++;
            }
            else{
                right--;
            }
        }

        return stuff.length-stuffWeight;

    }
}