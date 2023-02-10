package inflearn.대소문자변환;
import java.util.*;
class Main {

    public String solution(String str) {
        String answer = "";
        for(char x : str.toCharArray()) {
//            if(Character.isLowerCase(x)) answer += Character.toUpperCase(x);
//            else answer += Character.toLowerCase(x);

                //아스키 코드로 풀기
                if(x > 97 && x < 122) answer += (char)(x-32);
                else answer += (char)(x+32);
        }//end of for--

        return answer;
    }
    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.print(T.solution(str));
    }
}
