import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Solution queue = new Solution(); //수정 필요

        queue.size(); // 0
        for(int i = 1; i < 10; i++) {
            queue.add(i);
        }
        queue.poll(); // 1
        queue.poll(); // 2
        queue.size(); // 7
        queue.add(10);
        queue.size(); // 8
        queue.poll(); // 3
        queue.poll(); // 4
        queue.size(); // 6
    }
}
class Solution {
    private ArrayList<Integer> listQueue = new ArrayList<Integer>();

    public void add(Integer data) {
        listQueue.add(data);
    }

    public Integer poll() {
        if(listQueue.size()==0) {
            return null;
        }else {
            return listQueue.remove(0);
        }
    }

    public int size() {
        return listQueue.size();
    }

    public Integer peek() {
        if(listQueue.size()==0) {
            return null;
        }else {
            return listQueue.get(0);
        }
    }

    public String show() {
        return listQueue.toString();
    }

    public void clear() {
        listQueue.clear();
    }
}