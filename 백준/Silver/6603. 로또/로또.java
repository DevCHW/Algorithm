import java.util.*;
public class Main {
    private static int k;
    private static int[] s;
    private static boolean[] visited;
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true){

            k = sc.nextInt();

            if(k==0) break;

            s = new int[k];
            visited = new boolean[k];
            for(int i =0; i<k; i++){
                s[i] = sc.nextInt();
            }

            solution();
            sb.append("\n");
        }
        System.out.print(sb);
    }

    private static void solution(){
        dfs(0,0, "");
    }

    private static void dfs(int startNum, int depth, String tmp){
//        System.out.println("현재 depth = " + depth + ", tmp = " + tmp);
        if(depth == 6){
            sb.append(tmp).append("\n");
        } else {
            for(int i=startNum; i<k; i++) {
                if(!visited[i]) {
                    // depth = 5
                    // tmp = 1 2 3 4 5 
                    visited[i] =true;
                    dfs(i+1,depth+1, tmp + s[i]+ " ");
                    visited[i] = false;
                }
            }
        }
    }
}