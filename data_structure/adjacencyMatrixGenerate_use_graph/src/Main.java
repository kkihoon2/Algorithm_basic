public class Main {
    public static void main(String[] args) {
        Solution k = new Solution();
        int[][] output1 = k.createMatrix(new int[][]{
                {0, 3, 0},
                {0, 2, 0},
                {1, 3, 0},
                {2, 1, 0},
        });

        System.out.println(output1);
/**
 * [
 *  [0, 0, 1, 1],
 *  [0, 0, 0, 1],
 *  [0, 1, 0, 0],
 *  [0, 0, 0, 0]
 * ]
 */

        int[][] output2 = k.createMatrix(new int[][]{
                {0, 2, 0},
                {2, 4, 1},
                {1, 3, 1},
                {2, 1, 0},
        });

        System.out.println(output2);
/**
 * [
 *  [0, 0, 1, 0, 0],
 *  [0, 0, 0, 1, 0],
 *  [0, 1, 0, 0, 1],
 *  [0, 1, 0, 0, 0],
 *  [0, 0, 1, 0, 0],
 * ]
 */
    }
}

class Solution {
    public int[][] createMatrix(int[][] edges) {
        //0번째: 간선의 시작 정점 (0 이상의 정수)
        //1번째: 간선의 도착 정점 (0 이상의 정수)
        //2번째: 방향성 (1 == 일시 무향, 0 == 일시 방향)
        int arrLen = 0 ;
        for (int i = 0; i < edges.length ; i++) {
            for (int j = 0; j<edges[i].length ; j++)
                if(edges[i][j]>arrLen)
                    arrLen=edges[i][j];
        }
        int[][] answer = new int[arrLen+1][arrLen+1];

        for (int i = 0; i < edges.length ; i++) {
            for (int j = 0; j<edges[i].length ; j++) {
                if(j==2&&edges[i][j]==0)
                {
                    answer[edges[i][0]][edges[i][1]]=1;
                }else if(j==2&&edges[i][j]==1)
                {
                    answer[edges[i][0]][edges[i][1]]=1;
                    answer[edges[i][1]][edges[i][0]]=1;
                }
            }
        }

        return answer;

        //레퍼런스 코드 from to 로 나눠서 관리한다.
//        for(int i=0;i<edges.length;i++){
//            int from=edges[i][0];
//            int to=edges[i][1];
//            int direction=edges[i][2];
//            //일시 방향일 경우
//            if(direction==0)graph[from][to]=1;
//                //일시 무향일 경우
//            else if(direction==1){
//                graph[from][to]=1;
//                graph[to][from]=1;
//            }
//        }
    }
}
