import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution k = new Solution();
        ArrayList<Integer[]> output1 = k.newChickenRecipe(new int[]{1, 10, 1100, 1111}, 2);
        ddd(output1);
/*
  [
    [1, 10], [1, 1100], [1, 1111],
    [10, 1], [10, 1100], [10, 1111],
    [1100, 1], [1100, 10], [1100, 1111],
    [1111, 1], [1111, 10], [1111, 1100]
  ];
*/

        ArrayList<Integer[]> output2 = k.newChickenRecipe(new int[]{10000, 10, 1}, 3);
        System.out.println(output2); // []
        ddd(output2);

        ArrayList<Integer[]> output3 = k.newChickenRecipe(new int[]{11, 1, 10, 1111111111, 10000}, 4);
        ddd(output3);
/*
  [
    [1, 10, 11, 1111111111],
    [1, 10, 1111111111, 11],
    [1, 11, 10, 1111111111],
    [1, 11, 1111111111, 10],
    [1, 1111111111, 10, 11],
    [1, 1111111111, 11, 10],
    [10, 1, 11, 1111111111],
    [10, 1, 1111111111, 11],
    [10, 11, 1, 1111111111],
    [10, 11, 1111111111, 1],
    [10, 1111111111, 1, 11],
    [10, 1111111111, 11, 1],
    [11, 1, 10, 1111111111],
    [11, 1, 1111111111, 10],
    [11, 10, 1, 1111111111],
    [11, 10, 1111111111, 1],
    [11, 1111111111, 1, 10],
    [11, 1111111111, 10, 1],
    [1111111111, 1, 10, 11],
    [1111111111, 1, 11, 10],
    [1111111111, 10, 1, 11],
    [1111111111, 10, 11, 1],
    [1111111111, 11, 1, 10],
    [1111111111, 11, 10, 1],
  ]
*/
    }

    private static void ddd(ArrayList<Integer[]> output2) {
        for (int i = 0; i < output2.size(); i++) {
            for(int j = 0 ; j<output2.get(i).length;j++){
                System.out.print(output2.get(i)[j]+" ");
            }
            System.out.println();
        }
    }
}
class Solution {
    public ArrayList<Integer[]> newChickenRecipe(int[] stuffArr, int choiceNum) {
        // TODO:
        ArrayList<Integer> list = new ArrayList<>();

        //stuffArr를 순회하며 사용 가능한 재료만 freshArr리스트에 추가합니다
        for(int i = 0; i < stuffArr.length; i++) {
            //stuffArr[i]를 String타입으로 변환한 이후
            String str = String.valueOf(stuffArr[i]);
            //해당 값을 char타입의 배열로 바꾼 이후, 0이 들어간 갯수만큼 element 배열에 추가합니다.
            int[] element = str.chars().filter(c -> c == '0').toArray();
            //element 배열의 숫자가 2 이하인 경우('0'이 2번 이하인 재료의 경우)
            if(element.length <= 2) {
                //freshArr에 해당 재료를 넣어줍니다.
                list.add(stuffArr[i]);
            }
        }
        Collections.sort(list);

        if(list.isEmpty()||list.size()<choiceNum)
            return null;

        boolean[] isVisited = new boolean[list.size()];

        ArrayList<Integer[]>answer = new ArrayList<>();

        dfs(isVisited,list,new Integer[]{},answer,choiceNum,0);
        return answer;
    }
    static void dfs(boolean[]isVisited,ArrayList<Integer>list,Integer [] res ,ArrayList<Integer[]>answer,int choiceNum,int depth)
    {
        if(depth==choiceNum)
        {
            answer.add(res);
            return;
        }
        for(int i = 0 ; i<list.size();i++)
        {
            if(!isVisited[i]){
                isVisited[i]=true;
                Integer[] k = Arrays.copyOf(res,res.length+1);
                k[k.length-1]=Integer.valueOf(list.get(i));
                dfs(isVisited,list,k,answer,choiceNum,depth+1);
                isVisited[i]=false;
            }
        }
    }
}

//public class Solution {
//    public ArrayList<Integer[]> newChickenRecipe(int[] stuffArr, int choiceNum) {
//
//        ArrayList<Integer> freshArr = new ArrayList<>();
//        for(int i = 0; i < stuffArr.length; i++) {
//            String str = String.valueOf(stuffArr[i]);
//            int[] element = str.chars().filter(c -> c == '0').toArray();
//            if(element.length <= 2) {
//                freshArr.add(stuffArr[i]);
//            }
//        }
//        Collections.sort(freshArr);
//
//        if (freshArr.size() == 0 || freshArr.size() < choiceNum) return null;
//        ArrayList<Integer[]> result = new ArrayList<>();
//        boolean[] visited = new boolean[freshArr.size()];.
//        return permutation(choiceNum, new Integer[]{}, result, freshArr, visited, 0);
//    }
//
//    public ArrayList<Integer[]> permutation(int choiceNum, Integer[] bucket, ArrayList<Integer[]> result, ArrayList<Integer> freshArr, boolean[] visited, int depth) {
//        if(depth == choiceNum) {
//            result.add(bucket);
//            return result;
//        }
//        for(int i = 0; i < freshArr.size(); i++) {
//            if(!visited[i]) {
//                visited[i] = true;
//                Integer[] concatArray = Arrays.copyOf(bucket, bucket.length + 1);
//                concatArray[concatArray.length - 1] = freshArr.get(i);
//                result = permutation(choiceNum, concatArray, result, freshArr, visited, depth + 1);
//                visited[i] = false;
//            }
//        }
//        return result;
//    }
//}

