import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {};
        // 몇번째 차례인지 기록할 count 변수 선언
        int count = 1;
        int idx = -1;
        
        // 말한 단어를 기록할 Map<단어,횟수> 변수 선언
        Map<String, Integer> map = new HashMap<>();
        
        // 맨 처음 단어 넣기
        map.put(words[0], map.getOrDefault(words[0], 0) + 1);
        
        // 끝말잇기 배열 탐색 O(N)
        // 맨 처음 단어는 넣었기 때문에 1부터 시작.
        for(int i=1; i<words.length; i++) {
            //이전 사람이 말한 단어의 끝글자
            char beforeLastWord = words[i-1].charAt(words[i-1].length()-1); 
            //현재 사람이 말한 단어
            String word = words[i]; 
            //현재 사람이 말한 단어의 첫글자
            char currentFirstWord = word.charAt(0);

            map.put(word, map.getOrDefault(word, 0) + 1);
            if(i % n == 0) count++;
            //탈락 검사하기
            //이미 말한 단어를 말하거나, 1글자를 말했거나, 앞사람의 맨뒷글자와 현재 맨앞글자가 다르다면 탈락.
            if(map.get(word) >= 2 || 
               word.length() == 1 ||
               beforeLastWord != currentFirstWord) {
                idx = (i%n)+1;
                break;
            }
        }
        
        // 정답 배열 선언
        answer = new int[2];
        
        // 탈락한 사람이 없다면 idx == -1 그대로 내려옴.
        if(idx == -1) {
            answer[0] = 0;
            answer[1] = 0;
        } else {
            answer[0] = idx;
            answer[1] = count;
        }

        return answer;
    }
}