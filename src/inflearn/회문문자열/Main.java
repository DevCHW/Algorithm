package inflearn.회문문자열;
import java.util.*;
// 회문문자열 첫번째 풀이 문자열 뒤집기 알고리즘 이용
class Main {
    public String solution(String str) {
        String answer = "YES";
        int lt = 0;
        int rt = str.length()-1;

        char[] arr = str.toUpperCase().toCharArray();
        while(lt < rt) {
            if(arr[lt] != arr[rt]) return "NO";
            lt++;
            rt--;
        }//end of while--
        return answer;
    }
    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.print(T.solution(str));
    }
}

