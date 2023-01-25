public class Main {
    public static void main(String[] args) {
        Solution k = new Solution();
        int[][] board1 = new int[][]{
                {0, 0, 0, 1},
                {1, 1, 1, 0},
                {1, 1, 0, 0},
                {0, 0, 0, 0}
        };
        int output1 = k.boardGame(board1, "RRDLLD");
        System.out.println(output1); // 4


        int[][] board2 = new int[][]{
                {0, 0, 1},
                {1, 1, 1},
                {1, 0, 0}
        };
        int output2 = k.boardGame(board2, "UUUDD");
        System.out.println(output2); // null

        int[][] board3 = new int[][]{
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0}
        };
        int output3 = k.boardGame(board3, "DDRRRUDUDUD");
        System.out.println(output3); // 0
    }

    static class Solution {
        public Integer boardGame(int[][] board, String operation) {
            // TODO:N * N의 크기를 가진 보드판 위에서 게임을 하려고 합니다. 게임의 룰은 다음과 같습니다.
            //
            //1.좌표 왼쪽 상단(0, 0)에 말을 놓는다.
            //2.말은 상, 하, 좌, 우로 이동할 수 있고, 플레이어가 조작할 수 있다.
            //3.조작의 기회는 딱 한 번 주어진다.
            //4.조작할 때 U, D, L, R은 각각 상, 하, 좌, 우를 의미하며 한 줄에 띄어쓰기 없이 써야 한다.
            //5.예시: UDDLLRRDRR, RRRRR
            //6.한 번 움직일 때마다 한 칸씩 움직이게 되며, 그 칸 안의 요소인 숫자를 획득할 수 있다.
            //7.방문한 곳을 또 방문해도 숫자를 획득할 수 있다.
            //8.보드 밖을 나간 말은 OUT 처리가 된다.
            //9.칸 안의 숫자는 0 또는 1이다.
            //10.단, 좌표 왼쪽 상단(0, 0)은 항상 0이다.
            //11.획득한 숫자를 합산하여 숫자가 제일 큰 사람이 이기게 된다.
            //12.보드판이 담긴 board와 조작하려고 하는 문자열 operation이 주어질 때, 말이 해당 칸을 지나가면서 획득한 숫자의 합을 구하는 함수를 작성하세요.
            char[] op = operation.toCharArray();
            int score = 0;

            int nowX = 0;
            int nowY = 0;
            int i = 0;
            while (op.length> i) {
                if (op[i] == 'U') {
                    --nowX;
                } else if (op[i] == 'D') {
                    ++nowX;
                } else if (op[i] == 'L') {
                    --nowY;
                } else if (op[i] == 'R') {
                    ++nowY;
                }
                if (nowX < 0 || nowY < 0) {
                    return null;
                }
                if (board[nowX][nowY] == 1) {
                    score++;
                }

                i++;
            }
            return score;
        }

    }
}
