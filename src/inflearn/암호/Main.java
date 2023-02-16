package inflearn.암호;

import java.util.*;

public class Main {
    public String solution(int n, String str) {
        String answer = "";

        for(int i=0; i<n; i++) {
            String tmp = str.substring(0,7).replace("#", "1").replace("*", "0");
            str = str.substring(7);
            char ch = (char)Integer.parseInt(tmp, 2);
            answer += ch;
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        System.out.println(T.solution(n, str));
    }

    /**
     문자열 입력받기
     replace로 # * 각각 01로 변환해주기
     Integer.parseInt의 뒤 인자에 숫자를 넣어주면 뒤 숫자의 진수를 10진수로 변환시켜쥼
     그걸다수
     */

}



