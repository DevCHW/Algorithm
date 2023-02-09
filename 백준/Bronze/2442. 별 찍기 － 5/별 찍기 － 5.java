import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=1; i<=n; i++) {
            for(int k=n; k>i; k--) {
                System.out.print(" ");
            }//end of for--
            for(int j=0; j<2*i-1; j++) {
                System.out.print("*");
            }//end of for--
            System.out.println();
        }//end of for--

        //2×N-1
    }
}


