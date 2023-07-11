import java.util.*;

public class Main {
    static class Question {
        String number;
        int strike;
        int ball;

        Question(String number, int strike, int ball) {
            this.number = number;
            this.strike = strike;
            this.ball = ball;
        }
    }

    /**
     * 입,출력
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Question> questions = new ArrayList<>();
        for(int i=0; i<n; i++) {
            String number = sc.next();
            int strike = sc.nextInt();
            int ball = sc.nextInt();
            questions.add(new Question(number, strike, ball));
        }

        print(solution(n, questions));
    }

    /**
     * 풀이 로직
     */
    private static int solution(int n, List<Question> questions) {
        int answer = 0;
        for(int i=1; i<=9; i++) {
            for(int j=1; j<=9; j++) {
                if(i == j) continue;
                for(int k=1; k<=9; k++) {
                    if(i == k || j == k) continue;
                    String str = String.valueOf(i) + j + k;

                    boolean flag = true;

                    for(Question question : questions) {
                        int strike = 0;
                        int ball = 0;
                        if (str.charAt(0) == question.number.charAt(0)) {
                            strike++;
                        } else if(question.number.contains(String.valueOf(str.charAt(0)))) {
                            ball++;
                        }

                        if (str.charAt(1) == question.number.charAt(1)) {
                            strike++;
                        } else if(question.number.contains(String.valueOf(str.charAt(1)))) {
                            ball++;
                        }

                        if (str.charAt(2) == question.number.charAt(2)) {
                            strike++;
                        } else if(question.number.contains(String.valueOf(str.charAt(2)))) {
                            ball++;
                        }

                        if(question.strike != strike || question.ball != ball) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) answer++;
                }
            }
        }

        return answer;
    }


    /**
     * print() 구현
     */
    private static void print(String str) {
        System.out.println(str);
    }

    /**
     * print() 구현
     */
    private static void print(int number) {
        System.out.println(number);
    }
}
