class Solution {
    
    private boolean O_bingo = false;
    private boolean X_bingo = false;
    
    public int solution(String[] board) {
        int answer = 1;
        //선공이 O 후공이 X
        
        int O_count = 0;
        int X_count = 0;
        
        for(int i=0; i<3; i++) {
            String row = board[i];
            for(int j=0; j<3; j++) {
                char current = row.charAt(j);
                if(current == 'O') {
                    O_count++;
                    if(!O_bingo) {
                        if(i==1 || j==1) { //현재위치가 십자가 범위안에있으면 검사
                            O_bingo = isBingo(current, board, i, j);
                        }
                    }
                } else if(current == 'X') {
                    X_count++;
                    if(!X_bingo) {
                        if(i==1 || j==1) { //현재위치가 십자가 범위안에있으면 검사
                            X_bingo = isBingo(current, board, i, j);
                        }    
                    }
                }
            }
        }
        
        if(X_count > O_count) return 0;     //X가 O보다 많으면 위반
        
        if(O_count > X_count && O_count - X_count > 1) return 0; //O가 X보다 두개 이상 많으면 위반
        
        if(X_bingo) { //X가 bingo 완성시에
            if(O_count > X_count && O_count - X_count == 1) return 0; //O가 X보다 1개 많으면 위반
        }
        
        if(O_bingo) {
            if(X_count == O_count) return 0;
        }
        
        return answer;
    }

    
    private boolean isBingo(char current, String[] board, int x, int y) {
        // 현재 좌표를 기준으로 (위,아래),(왼쪽,오른쪽), (오른쪽위 왼쪽아래), (오른쪽아래, 왼쪽 위) 검사
        int[] dx = {-1, 1, 0, 0, -1, 1, 1, -1};
        int[] dy = {0, 0, -1, 1, 1, -1, 1, -1};
        
        for(int i=0; i<8; i+=2) {    //4개의 방향 검사
            int count = 0;
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx >= 0 && nx < 3 && ny >= 0 && ny < 3) {
                if(board[nx].charAt(ny) == current) {
                    count++;
                }
            }
            
            nx = x+dx[i+1];
            ny = y+dy[i+1];
            if(nx >= 0 && nx < 3 && ny >= 0 && ny < 3) {
                if(board[nx].charAt(ny) == current) {
                    count++;
                }
            }
            if(count == 2) return true;
        }//end of for--
        
        return false;
    }
}