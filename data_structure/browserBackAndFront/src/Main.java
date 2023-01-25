import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Solution k = new Solution();
        String[] actions = new String[]{"B", "C", "-1", "D", "A", "-1", "1", "-1", "-1"};
        String start = "A";
        ArrayList<Stack> output = k.browserStack(actions, start);

        System.out.println(output); // [["A"], ["B"], ["A", "D"]]

        String[] actions2 = new String[]{"B", "-1", "B", "A", "C", "-1", "-1", "D", "-1", "1", "E", "-1", "-1", "1"};
        String start2 = "A";
        ArrayList<Stack> output2 = k.browserStack(actions2, start2);

        System.out.println(output2); // [["A", "B"], ["D"], ["E"]]
    }
}

class Solution {
    public ArrayList<Stack> browserStack(String[] actions, String start) {

        // TODO:개발자가 되고 싶은 김코딩은 자료구조를 공부하고 있습니다. 인터넷 브라우저를 통해 스택에 대해 검색을 하면서 다양한 페이지에 접속하게 되었는데 "뒤로 가기", "앞으로 가기"를 반복하면서 여러 페이지를 참고하고 있었습니다.
        //
        //그런데 새로운 페이지를 접속하게 되면 "앞으로 가기" 버튼이 비활성화돼서 다시 보고 싶던 페이지로 갈 수 없었습니다. 이러기를 반복하다가 김코딩은 스택 자료구조를 떠올리게 되었습니다.
        //
        //브라우저에서 "뒤로 가기", "앞으로 가기" 기능이 어떻게 구현되는지 궁금해진 김코딩은 몇 가지 조건을 아래와 같이 작성하였지만, 막상 코드를 작성하지 못하고 있습니다.
        //새로운 페이지로 접속할 경우 prev 스택에 원래 있던 페이지를 넣고 next 스택을 비웁니다.
        //
        //뒤로 가기 버튼을 누를 경우 원래 있던 페이지를 next 스택에 넣고 prev 스택의 top에 있는 페이지로 이동한 뒤 prev 스택의 값을 pop 합니다.
        //
        //앞으로 가기 버튼을 누를 경우 원래 있던 페이지를 prev 스택에 넣고 next 스택의 top에 있는 페이지로 이동한 뒤 next 스택의 값을 pop 합니다.
        //
        //브라우저에서 뒤로 가기, 앞으로 가기 버튼이 비활성화일 경우(클릭이 되지 않을 경우)에는 스택에 push 하지 않습니다.
        //
        //인터넷 브라우저에서 행동한 순서가 들어있는 배열 actions와 시작 페이지 start가 주어질 때 마지막에 접속해 있는 페이지와 방문했던 페이지들이 담긴 스택을 반환하는 솔루션을 만들어 김코딩의 궁금증을 풀어주세요.
        Stack<String> prevStack = new Stack<>();
        Stack<String> nextStack = new Stack<>();
        Stack<String> current = new Stack<>();
        ArrayList<Stack> result = new ArrayList<>();
        current.push(start);
        for (int i = 0; i < actions.length; i++) {
            if ((prevStack.empty() && (actions[i] == "-1")) || (nextStack.empty() && (actions[i] == "1"))) {
                continue;
            }
            if (actions[i].equals("1")) //&& !nextStack.isEmpty())//앞으로가기
            {
                prevStack.push(current.peek());
                current.pop();
                current.push(nextStack.peek());
                nextStack.pop();

            } else if (actions[i].equals("-1")) //&& !prevStack.isEmpty())//뒤로가기
            {
                nextStack.push(current.peek());
                current.pop();
                current.push(prevStack.peek());
                prevStack.pop();

            } else //if(!actions.equals("-1")&&!actions.equals("1"))
            {
                prevStack.push(current.peek());
                current.pop();
                current.push(actions[i]);
                if (!nextStack.isEmpty())
                    nextStack.clear();

            }
        }

        result.add(prevStack);//행동한 순서가 들어있는 배열 actions
        result.add(current);//마지막에 접속해 있는 페이지
        result.add(nextStack);//방문했던 페이지들이 담긴 스택
        return result;
    }
}