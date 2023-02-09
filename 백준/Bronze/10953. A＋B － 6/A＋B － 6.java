import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        for(int i=0; i<t; i++) {
            String str = sc.nextLine();
            String[] arr = str.split(",");
            System.out.println(Integer.parseInt(arr[0]) + Integer.parseInt(arr[1]));
        }//end of for--
    }
}


