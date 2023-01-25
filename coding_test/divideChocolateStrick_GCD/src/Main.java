import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int M = 4;
        int N = 8;
        Solution k = new Solution();
        ArrayList<Integer[]> output = k.divideChocolateStick(M, N);
        System.out.println(output);

    }
}
class Solution {
    public ArrayList<Integer[]> divideChocolateStick(int M, int N) {
        // TODO:
        ArrayList<Integer[]> answer = new ArrayList<>();
        int gcd = getGcd(M,N) ;

        for (int i = 1; i <= gcd; i++) {
            if(gcd%i==0)
            {
                Integer[] result = new Integer[]{
                        new Integer(i),new Integer(M/i),new Integer(N/i)
                };
                answer.add(result);
            }

        }
        return answer;

    }
    public int getGcd(int num1 , int num2)
    {
        int r = num1%num2;
        if(r==0)
            return num2;
        else
            return getGcd(num2,r);
    }
}