import java.util.*;
class Solution {
    
    class Position {
        int x;
        int y;
        
        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public int[] solution(String[][] places) {
        
        int[] answer = new int[5];
        
        for(int i=0; i<5; i++) {
            String[] room = places[i];   //대기실
            boolean flag = true;    //거리두기 지키고 있는 값
            
            for(int j=0; j<5 && flag; j++) {
                for(int k=0; k<5 && flag; k++) {
                    if (room[j].charAt(k) == 'P') {  //현재 상태가 'P'(응시자) 라면 거리두기 검사 시작
                        if(!bfs(j, k, room)) { //검사에 통과하지 못했다면
                            flag = false;
                        }
                    }
                }
            }//거리두기 검사 끝
            
            answer[i] = flag ? 1 : 0;
        }
        return answer;
    }
    
    private boolean bfs(int x, int y, String[] room) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        Queue<Position> queue = new LinkedList<>();
        queue.offer(new Position(x, y));
        
        while(!queue.isEmpty()) {
            Position p = queue.poll();
            //1. 상하좌우 확인
            for(int i=0; i<4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                
                if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5 || (nx == x && ny == y)) continue;
                
                int distance = Math.abs(nx-x) + Math.abs(ny-y); //맨해튼거리
                    
                if(room[nx].charAt(ny) == 'P' && distance <= 2) {
                    return false; //1칸 갔을 때 응시자 확인되면 바로 return
                }
                else if(room[nx].charAt(ny) == 'O' && distance < 2) {    //빈테이블이라면 한칸 더 가서 검사.
                    queue.offer(new Position(nx, ny));
                }
            }
        }
        
        return true;
    }
}