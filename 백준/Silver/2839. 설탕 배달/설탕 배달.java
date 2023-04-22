import java.util.*;
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sugar = sc.nextInt();
        int bag = 0;

        while(sugar >= 0) {
            if(sugar % 5 ==0) {
                bag += sugar / 5;
                sugar = 0;
                break;
            }
            sugar -= 3;
            bag += 1;
        }

        if(sugar == 0) System.out.println(bag);
        else System.out.println(-1);
    }
}