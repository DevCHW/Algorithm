import java.util.*;
class Solution {
    
    public String solution(String new_id) {
        
        // 1단계
        new_id = new_id.toLowerCase();

        //2단계
        StringBuilder sb = new StringBuilder();
        for(char x : new_id.toCharArray()) {
            if(x == '.' ||
              x == '-' ||
              x == '_' ||
              ('a' <= x && x<= 'z') ||
              ('0' <= x && x<= '9')) {
                sb.append(String.valueOf(x));
            }
        }
        new_id = sb.toString();

        //3단계
        int count = 0;
        String tmp = "";
        for(char x : new_id.toCharArray()) {
            if(x == '.') count++;
            else {
                if(count > 0) {
                    count = 0;
                    tmp += '.';
                    tmp += x;
                } else {
                    tmp += x;
                }
            }
        }
        new_id = tmp;
        
        //4단계 
        //'.'이 처음이나 끝에 위치하면 제거
        if(new_id.length() > 1) {
            if(new_id.charAt(0) == '.') {
                new_id = new_id.substring(1);
            }
            if(new_id.charAt(new_id.length()-1) == '.') {
                new_id = new_id.substring(0,new_id.length()-1);
            }
        }
        if(new_id.equals(".")) new_id = "";
        
        //5단계
        //빈 문자열이라면 new_id에 "a" 대입
        if(new_id.trim().isEmpty()) {
            new_id = "a";
        } 
        
        //6단계
        //길이가 16자이상이면, 첫글자부터 15개 글자까지 new_id에 대입
        //제거 후에 마침표가 끝에 위치한다면 끝에 위치한 마침표 제거
        if(new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);
            if(new_id.charAt(new_id.length()-1) == '.') {
                new_id = new_id.substring(0, new_id.length()-1);
            }
        }
        
        //7단계
        //길이가 2자 이하라면, 마지막 문자를 new_id의 길이가 3이될 때 까지 반복해서 더하기
        if(new_id.length() <= 2) {
            char x = new_id.charAt(new_id.length()-1);
            while(new_id.length() <= 2) {
                new_id += x;
            }
        }

        return new_id;
    }
}