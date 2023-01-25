import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Solution k = new Solution();
        int[] boxes = new int[]{5, 1, 4, 6};
        int output = k.paveBox(boxes);
        System.out.println(output); // 3

        int[] boxes2 = new int[]{1, 5, 7, 9};
        int output2 = k.paveBox(boxes2);
        System.out.println(output2); // 1
    }
}

class Solution {
    public int paveBox(int[] boxes) {
        // TODO:
        Queue<Integer> queue = new LinkedList<>();
        int max = 0;
        if (boxes.length == 1)
            return 1;
        for (int i = 0; i < boxes.length; i++) {
            if (queue.isEmpty()) {
                queue.add(boxes[i]);
            } else if (queue.peek() < boxes[i]) { //큐가 현재 값보다 작을때
                if (max < queue.size())
                    max = queue.size();
                queue.clear();
                queue.add(boxes[i]);

            } else if (queue.peek() >= boxes[i]) {  //큐가 현재 값보다 클때
                queue.add(boxes[i]);
            }
        }
        if(queue.size()>max)
            return queue.size();


        return max;
    }
}