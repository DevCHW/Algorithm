package inflearn.특정문자뒤집기;

import java.util.*;

class Main {
    //문자열 뒤집기 = StringBuilder()에 있는 reverse() 메소드 이용하기 또는 lt,rt 이용하여 뒤집기
    public String solution(String str) {
        String answer = "";
        char[] arr = str.toCharArray();
        int lt = 0, rt = str.length()-1;
        while(lt < rt) {
            if(!Character.isAlphabetic(arr[lt])) lt++;
            else if(!Character.isAlphabetic(arr[rt])) rt--;
            else{
                char tmp = arr[lt];
                arr[lt] = arr[rt];
                arr[rt] = tmp;
                lt++;
                rt--;
            }
        }//end of while
        answer = String.valueOf(arr);
        return answer;
    }
    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.print(T.solution(str));
    }
}



