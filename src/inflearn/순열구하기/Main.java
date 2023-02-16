package inflearn.순열구하기;


import java.util.*;

public class Main {
    private static int n;
    private static int r;
    private static int[] pm;
    private static int[] arr;
    private static int[] visited;
    public static void permutation(int level) {
        if(level == r) {
            for(int x : pm) System.out.print(x +  " ");
            System.out.println();
        } else {
            for(int i=0; i<n; i++) {
                if(visited[i] == 0) {
                    visited[i] = 1;
                    pm[level] = arr[i];
                    permutation(level+1);
                    visited[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        r = sc.nextInt();
        pm = new int[r];
        visited = new int[n];
        arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        permutation(0);
    }
}

