import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        sc.nextLine();
        for(int i=1; i<=t; i++){
            System.out.println("Case #"+i+": " + (sc.nextInt() + sc.nextInt()));
            sc.nextLine();
        }//end of for--
    }
}


