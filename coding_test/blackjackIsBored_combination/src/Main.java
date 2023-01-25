import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Solution k = new Solution();
        int output = k.boringBlackjack(new int[]{1, 2, 3, 4});
        System.out.println(output); // 1

        int output1 = k.boringBlackjack(new int[]{2, 3, 4, 8, 13});
        System.out.println(output1); // 3
    }
}
class Solution {
    public int boringBlackjack(int[] cards) {
        // TODO:
        ArrayList<Integer> result = new ArrayList<>();
        int temp1 =0 ;
        int cnt = 0 ;
        for(int i =0;i<cards.length;i++){
            for(int j = i+1;j< cards.length;j++){
                for(int k = j+1;k< cards.length;k++) {
                    int temp = cards[i] + cards[j] + cards[k];
                    result.add(temp);
                }
            }
        }
        //List<Integer> newList = result.stream().distinct().collect(Collectors.toList());
        for (int i = 0 ; i< result.size();i++)
        {
            for(int j = 2 ; j<result.get(i);j++){
                if(result.get(i)%j==0)
                    temp1++;
            }
            if(temp1==0)
                cnt++;

            temp1 = 0;
        }
        return cnt;
    }
}
//class Solution {
//    public int boringBlackjack(int[] cards) {
//        // TODO:
//        ArrayList<Integer> result = new ArrayList<>();
//        int answer = 0 ;
//        int cnt = 0 ;
//        for(int i =0;i<cards.length;i++){
//            for(int j = i+1;j< cards.length;j++){
//                for(int k = j+1;k< cards.length;k++) {
//                    int temp = cards[i] + cards[j] + cards[k];
//                    result.add(temp);
//                }
//            }
//        }
//        List<Integer> newList = result.stream().distinct().collect(Collectors.toList());
//        for (int i = 0 ; i< newList.size();i++)
//        {
//            for(int j = 2 ; j<newList.get(i);j++){
//                if(newList.get(i)%j==0)
//                    break;
//            }
//            cnt++;
//        }
//        return cnt;
//    }
//}