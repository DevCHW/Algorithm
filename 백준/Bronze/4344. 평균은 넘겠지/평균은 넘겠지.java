import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0; i<n; i++) {
            int count = sc.nextInt();
            int sum = 0;
            int[] students = new int[count];
            for(int j=0; j<count; j++) {
                int score = sc.nextInt();
                sum += score;
                students[j] = score;
            }
            int avg = sum/count;
            double avgUpCount = 0;
            for(int x : students) if(avg < x) avgUpCount++;

            String rate = (double)Math.round( avgUpCount*1000*100 / count) / 1000+"";
            int dotIdx = rate.indexOf(".");
            if(rate.substring(dotIdx+1).length() == 3) rate = rate+"%";
            else if(rate.substring(dotIdx+1).length() == 2) rate = rate+"0%";
            else if(rate.substring(dotIdx+1).length() == 1) rate = rate+"00%";

            System.out.println(rate);
        }

    }


}


