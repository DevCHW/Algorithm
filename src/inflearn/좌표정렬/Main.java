package inflearn.좌표정렬;


import java.util.*;

public class Main {
    public static class Point implements Comparable<Point>{
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
        @Override
        public int compareTo(Point o){
            if(this.x == o.x) return this.y-o.y;
            else return this.x-o.x;
        }
    }
    //    public static String solution() {
//        String answer = "";
//        return answer;
//    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Point> pointList = new ArrayList<>();
        for(int i=0; i<n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            pointList.add(new Point(x, y));
        }
        Collections.sort(pointList);
        for(Point o : pointList) System.out.println(o.x + " " + o.y);
    }
}

