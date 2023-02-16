package inflearn.문자열압축;

import java.util.*;

public class Main2 {
    public String solution(String str) {
        String answer = "";
        str = str + " ";
        int cnt = 1;
        for(int i =0; i<str.length()-1; i++) {
            if(str.charAt(i) == str.charAt(i + 1)) cnt++;
            else {
                answer += str.charAt(i);
                if(cnt>1) answer += cnt;
                cnt=1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Main2 T = new Main2();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.print(T.solution(str));
    }

    /**
        강사님 풀이 방식
        문자열 뒤에 빈 문자열 하나 " "추가한다.
        그다음 toCharArray() 해서 배열을 순회할 때  i번째 문자와 i+1 비교하는 것을 끝까지 할 수 있음
        굳이 나처럼 마지막 문자에 대하여 반복문을 빠져나와서 할 필요가 없음
     */

}



