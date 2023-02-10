package inflearn.문자찾기;
import java.util.*;
class Main {
    // 문제 해결 아이디어
    // 모든 문자를 toUpperCase()를 통해 대문자로 바꾼다.
    // 문자열의 길이만큼 반복문을 돌면서 입력받은 char와 같다면 answer를 1씩 증가시키고 반환.
    public int solution(String str, char t) {
        int answer = 0;
        str = str.toUpperCase();
        t = Character.toUpperCase(t);
//        for (int i = 0;i<str.length(); i++) {
//            if(str.charAt(i) == t) answer++;
//        }

        //향상된 for 문 이용하기
        for(char x : str.toCharArray()) {
            if(x == t) answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char c = sc.next().charAt(0);

        System.out.print(T.solution(str, c));
    }
}
