import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        str = str.trim();
        String[] arr = str.split(" ");
        if(str.isEmpty()) System.out.print(0);
        else System.out.print(arr.length);
    }
}


