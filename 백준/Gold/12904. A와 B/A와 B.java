import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.next();
        String T = sc.next();

        System.out.println(solution(S, T));
    }

    private static int solution(String S, String T) {

        //T => S로 변환
        while(S.length() != T.length()) {
            if(T.charAt(T.length()-1) == 'A') {
                T = T.substring(0,T.length()-1);
            } else {
                T = T.substring(0,T.length()-1);
                T = new StringBuilder(T).reverse().toString();
            }
            if(S.equals(T)) return 1;
        }//end of while--

        if(S.equals(T)) return 1;
        else return 0;
    }
}
