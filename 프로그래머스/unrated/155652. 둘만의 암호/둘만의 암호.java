class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        for(char x : s.toCharArray()) {
            for(int i=0; i<index; i++) {
                x = checkSkip(x, skip);
            }
            sb.append(String.valueOf(x));
        }
        answer = sb.toString();
        return answer;
    }
    
    // skip에 포함되는지 검사
    private char checkSkip(char x, String skip) {
        // skip에 없을 때 까지 검사
        boolean flag = true;
        while(flag) {
            x = (char)(x+1);
            if(x > 'z') x = 'a';
            for(char t : skip.toCharArray()) {
                if(x == t) {
                    flag = true;
                    break;
                } else {
                    flag = false;
                }
            }
        }
        return x;
    }
    
}