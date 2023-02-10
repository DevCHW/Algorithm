package inflearn.중복문자제거;
import java.util.*;
//중복문자제거 아이디어 2
// indexOf를 활용한다.
// 문자열을 char배열로 만들어서, 반복문을 돌릴 때 i번째가 원래 위치인데,
// 원래 위치와 처음 발견된 위치가 같다면 String answer에 누적을 해주고,
// 그게 아니라면 아무일도 하지 않는다.
// 쌓인 문자열 answer를 출력한다.
class Main2 {
    public String solution(String str) {
        String answer = "";
        for(int i = 0; i< str.length(); i++) {
            if(str.indexOf(str.charAt(i)) == i) answer += str.charAt(i);
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


