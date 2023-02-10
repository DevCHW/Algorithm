package inflearn.중복문자제거;
import java.util.*;

class Main {
    public String solution(String str) {
        String answer = str.substring(0,1);
        char[] arr = str.toCharArray();
        for(int i = 1; i < str.length(); i++){
            if(answer.indexOf(arr[i]) == -1) answer += arr[i];
        }
        return answer;
    }
    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(T.solution(str));
    }
}


