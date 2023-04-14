import java.util.*;
class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        
        int number = 0;
        String tmp = "";
        
        // 첫번째 차례부터 m(사람 수)*t(구할 숫자의 개수)번 차례까지 반복
        for(int i=1; i<=m*t; i++) { 
            if("".equals(tmp)) {
                tmp = Integer.toString(number,n);
            }
            
            if(p%m == i%m) {    //튜브의 차례라면
                String tube = String.valueOf(tmp.charAt(0));
                sb.append(tube);
            }
            
            //tmp 맨 앞글자 빼고 뒤의 글자로 넣기
            if(tmp.length() > 1) {
                tmp = tmp.substring(1);
            } else {
                tmp = "";
                number++;
            }
        }
        answer = sb.toString().toUpperCase();
        return answer;
    }
}