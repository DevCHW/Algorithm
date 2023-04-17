import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        String[] answer = {};
        List<String> userIdList = new ArrayList<>();
        List<String> commandList = new ArrayList<>();
        Map<String, String> map = new HashMap<>(); //아이디 : 닉네임
        
        for(int i=0; i<record.length; i++) {
            String[] arr = record[i].split(" ");    //공백을 기준으로 배열로 나누기
            
            String command = arr[0];    //명령어
            String userId = arr[1]; 
            
            if (command.equals("Enter")) {
                String nickname = arr[2];
                map.put(userId, nickname);
                commandList.add("님이 들어왔습니다.");
                userIdList.add(userId);
            }
            if (command.equals("Leave")) {
                commandList.add("님이 나갔습니다.");
                userIdList.add(userId);
            }
            if (command.equals("Change")) {
                String nickname = arr[2];
                map.put(userId, arr[2]);
            }
        }
        
        answer = new String[userIdList.size()];
        for(int i=0; i<answer.length; i++) {
            answer[i] = map.get(userIdList.get(i)) + commandList.get(i);
        }
        
        return answer;
    }
}