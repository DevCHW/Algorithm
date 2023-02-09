import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String a = sc.next();
        int sum = 0;
        for(char x : a.toCharArray()){
            sum += x-48;
        }//end of for--
        System.out.println(sum);
    }
}
