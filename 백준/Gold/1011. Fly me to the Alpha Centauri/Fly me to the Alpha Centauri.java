import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            int gap = dest - start;
            System.out.println(find(gap));
        }
    }

    public static int find(int distance){
        if(distance<4) return distance;
        ArrayList<Integer> dist = new ArrayList<>();
        dist.add(1);

        int now = 1;
        int lastDist = 1;
        int tmp = lastDist; // 마지막 값

        // lastDist 늘어가는거
        while(tmp+lastDist < distance -now){
            lastDist++;
            dist.add(lastDist);
            now += lastDist;
            tmp += lastDist;
        }

        //줄어드는 거
        while(now<distance){
            if(tmp<=distance-now){
                now += lastDist;
                dist.add(lastDist);
            }
            if(tmp==1) return dist.size();
            else{
                tmp -= lastDist;
                lastDist--;
                now += lastDist;
                dist.add(lastDist);
            }
        }
        return dist.size();
    }
}
