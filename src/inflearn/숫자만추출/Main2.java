package inflearn.숫자만추출;

import java.util.Scanner;
// 아스키 코드를 이용한 다른 풀이
// char 타입인 x가 48 <= x && x <= 57 이라면 숫자임.
// 정수로 반환할 땐 48을 빼준 값을 해주면 됨
public class Main2 {
    public int solution(String str) {
        int answer = 0;
        for(char x : str.toCharArray()){
            if(x >= 48 && x <= 57) answer = answer * 10 + (x-48);
        }
        return answer;
    }
    public static void main(String[] args) {
        Main2 T = new Main2();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.print(T.solution(str));
    }
}
