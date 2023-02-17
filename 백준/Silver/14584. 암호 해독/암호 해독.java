import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int n = sc.nextInt();
        String[] arr = new String[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.next();
        }


        for(int i=0; i<26; i++) {
            boolean flag = false;
            String tmp = "";
            for(int j=0; j<str.length(); j++) { //한칸씩 미루고
                tmp += (char)( (str.charAt(j)-'a'+i)%26 + 'a');
            }
//            System.out.println(tmp);
            for(int k=0; k<n; k++) {    //비교하기
                if(tmp.contains(arr[k])){
                    System.out.println(tmp);
                    flag = true;
                    break;
                }
            }
            if(flag) break;
        }
    }
}
