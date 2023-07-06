import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] weightArr = new int[n];
        int[] heightArr = new int[n];
        for(int i=0; i<n; i++) {
            weightArr[i] = sc.nextInt();
            heightArr[i] = sc.nextInt();
        }

        for(int x : solution(n, heightArr, weightArr)) {
            System.out.print(x + " ");
        }
    }

    private static int[] solution(int n, int[] heightArr, int[] weightArr) {
        int[] answer = new int[n];
        for(int i=0; i<n; i++) {
            int rank = 1;
            int weight1 = weightArr[i];
            int height1 = heightArr[i];

            for(int j=0; j<n; j++) {
                int weight2 = weightArr[j];
                int height2 = heightArr[j];

                if (weight1 < weight2 && height1 < height2) {
                    rank++;
                }
            }
            answer[i] = rank;
        }
        return answer;
    }
}