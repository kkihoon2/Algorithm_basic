import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution k = new Solution();
        long output = k.ocean(50, new int[]{10, 20, 50});
        System.out.println(output); // 4

        output = k.ocean(100, new int[]{10, 20, 50});
        System.out.println(output); // 10

        output = k.ocean(30, new int[]{5, 6, 7});
        System.out.println(output); // 4
    }
}

class Solution {
    public long ocean(int target, int[] type) {
        // TODO:훔치고 싶은 target 금액과 금고에 있는 돈의 종류 type 을 입력받아, 조지가 target 을 훔칠 수 있는 방법의 수를 리턴하세요.
        //https://withhamit.tistory.com/333
        long[] coin = new long[target + 1];
        coin[0] = 1;
        for (int i =0;i < type.length;i++){
            for (int j = 0; j <= target; j++)
                if (type[i] <= j)
                    coin[j] += coin[j-type[i]];//정형화된 패턴

        }
        return coin[target];
    }

}