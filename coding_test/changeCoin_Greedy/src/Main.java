public class Main {
    public static void main(String[] args) {
        // 4000원을 받았을 때 500원짜리 동전 8개를 반환합니다.
        Solution k = new Solution();
        int output1 = k.partTimeJob(4000);
        System.out.println(output1); // --> 8

        // 4972원을 받았을 때 500원짜리 동전 9개, 100원짜리 동전 4개, 50원짜리 동전 1개, 10원짜리 동전 2개, 1원짜리 동전 2개, 총 18개를 반환합니다.
        int output2 = k.partTimeJob(4972);
        System.out.println(output2); // --> 18
    }
}

class Solution {
    public int partTimeJob(int k) {
        // TODO:편의점에서 아르바이트를 하고 있는 중에, 하필이면 피크 시간대에 손님에게 거스름돈으로 줄 동전이 부족하다는 것을 알게 되었습니다.
        //현재 가지고 있는 동전은 1원, 5원, 10원, 50원, 100원, 500원으로 오름차순으로 정렬되어 있고, 각 동전들은 서로 배수 관계에 있습니다.
        //동전 개수를 최소화하여 거스름돈 K를 만들어야 합니다. 이때, 필요한 동전 개수의 최솟값을 구하는 함수를 작성해 주세요.
        int[] coin = new int[]{500,100,50,10,5,1};
        int cnt = 0 ;
        for(int i = 0 ; i<coin.length;i++)
        {
            if(k/coin[i]>=1)
            {
                cnt = cnt + k/coin[i];
            }
            k=k%coin[i];
        }

//        int cnt = 0;
//
//
//        cnt = cnt + k / 500;
//        k = k % 500;
//        cnt = cnt + k / 100;
//        k = k % 100;
//        cnt = cnt + k / 50;
//        k = k % 50;
//        cnt = cnt + k / 10;
//        k = k % 10;
//        cnt = cnt + k / 5;
//        k = k % 5;
//        cnt = cnt + k;

        return cnt;

    }
}