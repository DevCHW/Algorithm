import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String str = sc.nextLine();
                String[] arr = str.split(" ");
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        //최댓값을 구하는 for 문
        for(String x : arr) {
            int num = Integer.parseInt(x);
            if(num > max) max = num;
            if(num < min) min = num;
        }//end of for--
        System.out.println(min + " " + max);
    }
}


