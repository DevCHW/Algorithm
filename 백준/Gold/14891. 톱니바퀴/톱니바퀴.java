import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] wheel = new char[4][8];    //4개의 톱니바퀴,8개의 방향

        String[] tmpArr = new String[4];
        for(int i=0; i<4; i++) {
            tmpArr[i] = sc.next();
        }

        for(int i=0; i<4; i++) {
            String str = tmpArr[i];
            for(int j=0; j<8; j++) {
                wheel[i][j] = str.charAt(j);
            }
        }
        int k = sc.nextInt();
        int[][] arr = new int[k][2];
        for(int i=0; i<k; i++) {
            for(int j=0; j<2; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(solution(wheel, k, arr));
    }

    private static int solution(char[][] wheel, int k, int[][] arr) {
        int answer = 0;
        for(int i=0; i<k ;i++) {
            int idx = arr[i][0]-1;    //회전시킬 톱니바퀴 인덱스
            int dir = arr[i][1];    //시계방향 1 반시계방향 -1

            char left = wheel[idx][6];
            char right = wheel[idx][2];

            if(dir == 1) {  //시작 idx 톱니바퀴가 시계방향 회전이라면
                rotate(wheel, 1, idx);
                int count = 0;
                char lt;
                char rt = right;

                //idx기준 오른쪽 회전시키기(현재 톱니바퀴의 lt와 이전 톱니바퀴의 rt비교)
                for(int j=idx+1; j<4; j++) {
                    //짝수일 시 시계방향
                    //홀수일 시 반시계방향
                    count++;
                    lt = wheel[j][6];
                    int direction = count%2==0?1:-1;
                    if(lt != rt) {  //현재바퀴의 왼쪽과 이전바퀴의 오른쪽이 같지 않다면
                        rt = wheel[j][2];
                        rotate(wheel, direction, j);
                    } else {
                        break;
                    }
                }

                count = 0;
                lt = left;
                //idx기준 왼쪽 회전시키기(현재 톱니바퀴의 rt와 이전 톱니바퀴의 lt비교)
                for(int j=idx-1; j>=0; j--) {
                    //짝수일 시 시계방향
                    //홀수일 시 반시계방향
                    count++;
                    rt = wheel[j][2];
                    int direction = count%2==0?1:-1;
                    if(rt != lt) {  //현재바퀴의 오른쪽과 이전바퀴의 왼쪽이 같지 않다면
                        lt = wheel[j][6];
                        rotate(wheel, direction, j);
                    } else {
                        break;
                    }
                }
            } else {    // idx 톱니바퀴가 반시계방향 회전이라면
                rotate(wheel, -1, idx);
                int count = 0;
                char lt;
                char rt = right;

                //idx기준 오른쪽 회전시키기(현재 톱니바퀴의 lt와 이전 톱니바퀴의 rt비교)
                for(int j=idx+1; j<4; j++) {
                    //짝수일 시 반시계방향
                    //홀수일 시 시계방향
                    count++;
                    lt = wheel[j][6];
                    int direction = count%2==0?-1:1;
                    if(lt != rt) {  //현재바퀴의 왼쪽과 이전바퀴의 오른쪽이 같지 않다면
                        rt = wheel[j][2];
                        rotate(wheel, direction, j);
                    } else {
                        break;
                    }
                }

                count = 0;
                lt = left;
                //idx기준 왼쪽 회전시키기(현재 톱니바퀴의 rt와 이전 톱니바퀴의 lt비교)
                for(int j=idx-1; j>=0; j--) {
                    //짝수일 시 반시계방향
                    //홀수일 시 시계방향
                    count++;
                    rt = wheel[j][2];
                    int direction = count%2==0?-1:1;
                    if(rt != lt) {  //현재바퀴의 오른쪽과 이전바퀴의 왼쪽이 같지 않다면
                        lt = wheel[j][6];
                        rotate(wheel, direction, j);
                    } else {
                        break;
                    }
                }
            }
        }
        answer = calculator(wheel);
        return answer;
    }

    private static void rotate(char[][] wheel, int dir, int idx) {
        if(dir == 1) {
            char tmp = wheel[idx][7];
            for(int i=7; i>=1; i--) {
                wheel[idx][i] = wheel[idx][i-1];
            }
            wheel[idx][0] = tmp;
        } else {
            char tmp = wheel[idx][0];
            for(int i=0; i<7; i++) {
                wheel[idx][i] = wheel[idx][i+1];
            }
            wheel[idx][7] = tmp;
        }
    }

    private static int calculator(char[][] wheel) {
        //n극은 0, s극은 1
        int score = 0;
        score += wheel[0][0] == '0'?0:1;
        score += wheel[1][0] == '0'?0:2;
        score += wheel[2][0] == '0'?0:4;
        score += wheel[3][0] == '0'?0:8;
        return score;
    }
}
