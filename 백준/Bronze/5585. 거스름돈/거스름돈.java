import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(solution(n));
    }

    private static int solution(int n) {
        int answer = 0;

        int target = 1000 - n;
        if (target >= 500) {
            answer += target/500;
            target %= 500;
        }

        if (target >= 100) {
            answer += target/100;
            target %= 100;
        }

        if (target >= 50) {
            answer += target/50;
            target %= 50;
        }

        if (target >= 10) {
            answer += target/10;
            target %= 10;
        }

        if (target >= 5) {
            answer += target/5;
            target %= 5;
        }

        if (target >= 1) {
            answer += target;
        }

        return answer;
    }

}