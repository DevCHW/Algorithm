package inflearn.회문문자열;

import java.util.*;
// 회문문자열 두번째 풀이. StringBuilder에 있는 reverse() 활용
class Main2 {
    public String solution(String str) {
        str = str.toUpperCase();
        String rev = new StringBuilder(str).reverse().toString();
        return str.equals(rev)?"YES":"NO";
    }
    public static void main(String[] args) {
        Main2 T = new Main2();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(T.solution(str));
    }
}


