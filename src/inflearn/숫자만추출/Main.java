package inflearn.숫자만추출;
import java.util.*;
//내가 푼 풀이!
class Main {
    public int solution(String str) {
        String answer = "";
        char[] chArr = str.toCharArray();
        for(char x : chArr) {
            if(Character.isDigit(x)) answer += x;
        }//end of for--
        return Integer.parseInt(answer);
    }
    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.print(T.solution(str));
    }
}


