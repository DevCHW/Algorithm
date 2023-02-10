package inflearn.가장짧은문자거리;

import java.util.*;
// p를 Integer.MAX_VALUE로 놓고 풀었더니 다른 값이나왔다.
// 이는 int에서 가장 큰 값을 할당하고 ++;를 시켰기 때문에 오버플로우가 발생한건데.
// 자바에서는 오버플로우에서 익셉션처리를 하지않아 발견하기 힘들다고 한다.

class Main {
    public int[] solution(String s, char t) {
        int[] answer = new int[s.length()];
        int p = 101;

        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == t) p = 0;
            else p++;
            answer[i] = p;
        }//end of for--

        for(int i=s.length()-1; i>=0; i--) {
            if(s.charAt(i) == t) p = 0;
            else p++;
            if(answer[i] > p) answer[i] = p;
        }
        return answer;
    }
    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char t = sc.next().charAt(0);
        for(int a : T.solution(s, t)) {
            System.out.print(a + " ");
        }
    }
}


