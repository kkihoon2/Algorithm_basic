import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        int bufferSize = 2;
        int capacities = 10;
        int[] documents = new int[]{7, 4, 5, 6};
        Solution k = new Solution();
        int output = k.queuePrinter(bufferSize, capacities, documents);
        System.out.println(output); // 8
    }
}

class Solution {
    public int queuePrinter(int bufferSize, int capacities, int[] documents) {
        // TODO:
//        int cnt = 0;
//        Queue<Integer> printWork = new LinkedList<>();
//        Queue<Integer> waiting = new LinkedList<>();
//        for (int k : documents) {
//            waiting.add(k);
//        }
//        for (int i = 0; i < bufferSize; i++) {
//            printWork.add(0);
//        }
//        printWork.poll();
//        printWork.add(waiting.poll());
//        cnt++;
//        while (waiting.size() != 0 || (waiting.stream().reduce(0, Integer::sum) != 0))
//        {
//            if (waiting.size() != 0) {
//                int sum = printWork.stream().reduce(0, Integer::sum) + waiting.peek();
//                if (sum > capacities) {
//                    printWork.poll();
//                    sum = printWork.stream().reduce(0, Integer::sum) + waiting.peek();
//                    if (sum <= capacities) {
//                        printWork.add(waiting.poll());
//                        cnt++;
//                    } else {
//                        printWork.add(0);
//                        cnt++;
//                    }
//                } else {
//                    printWork.poll();
//                    printWork.add(waiting.poll());
//                    cnt++;
//                }
//            } else {
//                printWork.poll();
//                printWork.add(0);
//                cnt++;
//            }
//
//        }
//
//
//        return cnt;
        int time = 0;
        int currentCapacities = 0 ;
        Queue<Integer>buffer = new LinkedList<>();
        while


    }

}