import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] arr = new String[n];
        for(int i = 0; i<n; i++) {
            arr[i] = sc.next();
        }//end of for--
        for(int i = 0; i<n; i++) {
            String str = arr[i];
            int sum = str.charAt(0) == 'O'?1:0;
            int cnt = str.charAt(0) == 'O'?1:0;
            for(int j = 1; j<str.length(); j++){
                if(str.charAt(j) == 'O') {
                    sum += cnt+1;
                    cnt++;
                }else {
                    cnt = 0;
                }
            }
            System.out.println(sum);
        }

        System.out.println();

    }
}
