package inflearn;
import java.util.*;

public class Main {
    public String solution(String str) {
        String answer = "";
        char[] arr = str.toCharArray();
        char tmp = arr[0];
        int count = 1;
        for(int i=1; i<str.length()-1; i++) {
            if(arr[i] == tmp) {
                count++;
            } else {
                answer += String.valueOf(tmp) + count;
                count = 1;
                tmp = arr[i];
            }
        }
        if(arr[str.length()-1] == tmp) {
            count++;
            answer += String.valueOf(tmp) + count;
        } else {
            answer += String.valueOf(tmp) + count;
            answer += String.valueOf(arr[str.length()-1]);
        }

        answer = answer.replaceAll("1", "");
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.print(T.solution(str));
    }

    /**
         // == 준비 == //
         1. 입력받은 String str
         2. str의 첫번째글자 char tmp
         3. 문자열을 쪼개 문자열로 만든 char[] arr
         4. 반복횟수를 셀 int count (1로 초기호)
         5. 답을 리턴할 Stirng answer

         // == 로직 == //
         1. 두번째 글자부터 시작해서 맨 마지막 글자의 앞까지 반복문을 돈다.
         2. 두번째 글자가 앞의 글자(tmp)랑 같다면 { count++ }
         앞의 글자(tmp)랑 같지않다면 { 1. answer에 tmp+count를 저장
         2. count를 1로 초기화
         3. tmp를 현재글자로 초기화}
         3. 반복문을 나와서 문자열의 마지막 값을 tmp와 비교하여 같다면 {count를 증가하여 answer에 누적}
         마지막 값을 tmp와 비교하여 같지않다면 {1.tmp + count를 answer에 누적 2.마지막 값을 answer에 누적}
         4. 만들어진 answer을 replcaeAll로 1을 ""로 바꿔준 뒤 다시 answer에 넣기
         5. answer 리턴
     */
}


