import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Solution k = new Solution();
        boolean result = k.getDirections(new int[][]
                        {
                                {0, 1, 0, 0},
                                {0, 0, 1, 0},
                                {0, 0, 0, 1},
                                {0, 1, 0, 0}
                        },
                0,
                2
        );
        System.out.println(result); // true
// 정점 0에서 2로 가는 길이 존재하는지 확인합니다.
// 0 --> 1 로 가는 간선이 존재하고, 1 --> 2 로 가는 간선이 존재하기 때문에 true를 반환합니다.

        boolean result2 = k.getDirections(new int[][]
                        {
                                {0, 1, 0, 0, 0},
                                {0, 0, 0, 1, 0},
                                {0, 1, 0, 0, 0},
                                {0, 1, 1, 0, 0},
                                {1, 1, 1, 1, 0}
                        },
                1,
                4
        );
        System.out.println(result2); // false

// 정점 1에서 4로 가는 길이 존재하는지 확인합니다.
// 1 --> 3,
// 3 --> 1 (정점 1을 다녀왔으니 다시 돌아가지 않습니다),
// 3 --> 2,
// 2 --> 1 (정점 1을 다녀왔으니 다시 돌아가지 않습니다)
// ...으로, 4에 도달할 수 없습니다.
    }
}

class Solution {
    public boolean getDirections(int[][] matrix, int from, int to) {
//        ArrayList<Integer> answer = new ArrayList<>();
//        int i = 0 ;
//        answer.add(from);
//        while(i< matrix.length)
//        {
//            if(matrix[from][i]==1&&!answer.contains(i))
//            {
//                answer.add(i);
//                from=i;
//                i=0;
//            }
//            i++;
//        }
//        for(int data : answer) {
//            System.out.print(data);
//        }
//        if(answer.contains(to))
//            return true;
//        return false;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(from);
        boolean[] visited = new boolean[matrix.length];
        for (boolean k :visited) {
            System.out.print(k);
        }

        visited[from] = true;
        while (queue.size() > 0) {
            int now = queue.poll();
            if (now == to)
                return true;
            for (int next = 0; next < matrix[now].length; next++) {
                if (matrix[now][next] == 1 && !visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                }

            }
        }
        return false;
//            //연결 리스트를 사용하여 큐를 선언합니다.
//            Queue<Integer> queue = new LinkedList<>();
//            //첫 시작점으로 from을 할당합니다.
//            queue.add(from);
//
//            // 방문했다는 것을 표시하기 위해 1차원 배열을 생성합니다. 초기값은 false로 생성됩니다.
//            boolean[] isVisited = new boolean[matrix.length];
//            // 첫 정점 방문 여부를 표시합니다.
//            isVisited[from] = true;
//
//            // queue(방문할 곳)의 사이즈가 0이 될 때까지 반복합니다.
//            while (queue.size() > 0) {
//
//                // queue에서 정점을 하나 빼서 now에 할당합니다.
//                int now = queue.poll();
//
//                // 목적지인지 검사하고, 목적지라면 true를 반환합니다.
//                if (now == to) return true;
//
//                // 해당 정점의 간선들을 확인합니다.
//                for (int next = 0; next < matrix[now].length; next++) {
//                    // 만약, 간선이 있고 방문하지 않았다면
//                    if (matrix[now][next] == 1 && !isVisited[next]) {
//                        // queue에 next를 넣습니다. (다음 정점으로 가기 위해)
//                        queue.add(next);
//                        // 해당 정점을 방문했다는 것을 표시합니다.
//                        isVisited[next] = true;
//                    }
//                }
//            }
//            // 길이 없다면 false를 반환합니다.
//            return false;

    }
}
