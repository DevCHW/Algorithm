import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int i = 0;
        while(true) {
            try {
                System.out.print(str.charAt(i));
            } catch(Exception e) {
                break;
            }
            if(i == 9) {
                i = 0;
                str = str.substring(10);
                System.out.println();
                continue;
            }
            i++;
        }//end of while--
    }
}


