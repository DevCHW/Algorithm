import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //별 갯수
        int star = 0;
        int space = 2*n;
        //증가하는동안 찍기
        for(int i=1; i<=n-1; i++) {
            star += 2;
            space -= 2;
            //별찍기
            for(int j=0; j<star/2; j++) {
                System.out.print("*");
            }//end of for--

            //띄어쓰기 찍기
            for(int k=0; k<space; k++) {
                System.out.print(" ");
            }

            //별찍기
            for(int j=0; j<star/2; j++) {
                System.out.print("*");
            }//end of for--
            System.out.println();
        }

        //2n만큼 한줄 찍기
        for(int i=0; i<2*n; i++) {
            System.out.print("*");
        }
        System.out.println();

//        System.out.println("space = " + space);
//        System.out.println("star = " + star);
        //감소하는동안 찍기
        for(int i=1; i<=n-1; i++) {
            //별찍기
            for(int j=0; j<star/2; j++) {
                System.out.print("*");
            }//end of for--

            //띄어쓰기 찍기
            for(int k=0; k<space; k++) {
                System.out.print(" ");
            }

            //별찍기
            for(int j=0; j<star/2; j++) {
                System.out.print("*");
            }//end of for--
            System.out.println();
            star -= 2;
            space += 2;
        }




    }
}


