import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        for(int i=97; i<=122; i++) {
            int answer = str.indexOf(String.valueOf((char)i));
            System.out.print(answer + " ");
        }//end of for--
    }
}


