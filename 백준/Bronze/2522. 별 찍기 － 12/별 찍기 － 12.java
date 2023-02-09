import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int space = n;
        int star = 0;
        for(int i=1; i<=2*n-1; i++) {
            if(i < n) {
                space--;
                star++;
            } else if(i == n) {
                space = 0;
                star = n;
            } else {
                space++;
                star--;
            }
            for(int k=0; k<space; k++) {
                System.out.print(" ");
            }
            for(int q=0; q<star; q++) {
                System.out.print("*");
            }
            System.out.println();
        }//end of for--
    }
}


