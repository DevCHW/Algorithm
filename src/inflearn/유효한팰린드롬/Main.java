package inflearn.유효한팰린드롬;

import java.util.*;

class Main {
    public String solution(String str) {
        str = str.replaceAll("[^A-z]","");
        String rev = new StringBuilder(str).reverse().toString();
        return rev.equalsIgnoreCase(str)?"YES":"NO";
    }
    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.print(T.solution(str));
    }
}


