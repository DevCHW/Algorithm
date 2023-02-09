import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int space = -2;
        int star = 2*n+1;
        // 별 갯수는 두개씩 줄어든다.
        // 2 * n - 1번째 줄까지 찍는다.

        for(int i=1; i<=2*n-1; i++) {
            if (i < n) {
                space += 2;
                star -= 2;
            }else if(i == n){
                space = 2*n-2;
                star = 1;
            }else {
                space -= 2;
                star += 2;
            }
            //공백찍기
            for (int k = 0; k < space/2; k++) {
                System.out.print(" ");
            }
            //별찍기
            for (int q = 0; q < star; q++) {
                System.out.print("*");
            }
            if(i != 2*n-1) {
                System.out.println();
            }
        }
    }
}


