import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Solution stack = new Solution();

        stack.size(); // 0
        for(int i = 1; i < 10; i++) {
            stack.push(i);
        }
        stack.pop(); // 9
        stack.pop(); // 8
        stack.size(); // 7
        stack.push(8);
        stack.size(); // 8

    }
}
class Solution {
    private ArrayList<Integer> listStack = new ArrayList<Integer>();

    public void push(Integer data) {
        listStack.add(data);
    }

    public Integer pop() {
        if(listStack.size()==0) {
            return null;
        }else {
            return listStack.remove(listStack.size()-1);
        }
    }

    public int size() {
        return listStack.size();
    }

    public Integer peek() {
        if(listStack.size()==0) {
            return null;
        }else {
            return listStack.get(listStack.size()-1);
        }
    }

    public String show() {
        return listStack.toString();
    }
    public void clear() { listStack.clear(); }
}