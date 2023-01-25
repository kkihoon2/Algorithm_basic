import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution k = new Solution();
        ArrayList<String[]> output = k.rockPaperScissors(5);

        for (int i =0;i<output.size();i++)
        {
            for(int j = 0 ; j<output.get(i).length;j++)
            {
                System.out.print(output.get(i)[j]);
            }
        }
    }
}
//class Solution {
//    public ArrayList<String[]> rockPaperScissors(int rounds) {
//        // TODO:
//    }
//}


class Solution {
    public ArrayList<String[]> rockPaperScissors(int rounds) {
        // TODO:가위바위보 게임은 2인 이상의 사람이 동시에 '가위, 바위, 보'를 외치고 동시에 가위, 바위 또는 보 중에서 한 가지를 의미하는 손 모양을 내밀어 승부를 결정짓는 게임입니다.
        //  세 판의 가위바위보 게임을 할 경우, 한 사람은 세 번의 선택(예. 가위, 가위, 보)을 할 수 있습니다.
        //  입력받은 rounds만큼의 선택으로 가능한 모든 경우의 수를 구하는 함수를 작성합니다.
        String [] rpc = new String[]{"rock","scissors","paper"};
        int cnt = 0;
        ArrayList<String []> per = new ArrayList<>();

        permutation(rounds,new String[]{},per);

        return per;
    }
    static void permutation(int rounds,String[] result,ArrayList<String []> per)
    {
        if(rounds==0)
        {
            per.add(result);
            return;
        }
        String[] rps = new String[]{"rock","paper","scissors"};
        for(int i = 0 ; i < rps.length;i++)
        {
            //result[cnt]=rpc[i];
            String[] dest = Arrays.copyOf(result,result.length+1);
            dest[dest.length-1]=rps[i];
            permutation(rounds-1,dest,per);


        }

    }
}
//class Solution {
//    public ArrayList<String[]> rockPaperScissors(int rounds) {
//        // TODO:가위바위보 게임은 2인 이상의 사람이 동시에 '가위, 바위, 보'를 외치고 동시에 가위, 바위 또는 보 중에서 한 가지를 의미하는 손 모양을 내밀어 승부를 결정짓는 게임입니다.
//        //  세 판의 가위바위보 게임을 할 경우, 한 사람은 세 번의 선택(예. 가위, 가위, 보)을 할 수 있습니다.
//        //  입력받은 rounds만큼의 선택으로 가능한 모든 경우의 수를 구하는 함수를 작성합니다.
//        String [] rpc = new String[]{"rock","scissors","paper"};
//        int cnt = 0;
//        ArrayList<String []> per = new ArrayList<>();
//        String[]result = new String[rounds];
//        permutation(rpc,rounds,cnt,result,per);
//
//        return per;
//    }
//    static void permutation(String [] rpc,int rounds,int cnt,String[] result,ArrayList<String []> per)
//    {
//        for(int i = 0 ; i < rpc.length;i++)
//        {
//            if(cnt==rounds-1)
//            {
//                per.add(result);
//                break;
//            }
//            result[cnt]=rpc[i];
//            permutation(rpc,rounds,cnt++,result,per);
//
//
//        }
//
//    }
//}