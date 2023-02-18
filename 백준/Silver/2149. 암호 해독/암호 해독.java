import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String secret = sc.nextLine();
        int len = str.length();
        int row = secret.length() / len +1;   //행
        int col = len;   //열
        char[] strArr = str.toCharArray();

        int[] idxArr = new int[len];
        for(int i=0; i<len; i++) {
            idxArr[i] = i;
        }

        for(int i=0; i<len; i++) {
            int idx = i;
            for(int j=i+1; j<len; j++) {
                if(strArr[j] < strArr[idx]) {
                    idx = j;
                }
            }
            char tmp1 = strArr[i];
            strArr[i] = strArr[idx];
            strArr[idx] = tmp1;
            int tmp2 = idxArr[i];
            idxArr[i] = idxArr[idx];
            idxArr[idx] = tmp2;
        }

        char[][] arr = new char[row][col];
        for(int i=0; i<col; i++) arr[0][i] = strArr[i];

        int count = 0;
        for(int i=0; i<col; i++) {
            for(int j=1; j<row; j++) {
                arr[j][i] = secret.charAt(count);
                count++;
            }
        }
        String check = new String(strArr);
        for(int i=1; i<row; i++) {
            String temp = check;
            for(char x : str.toCharArray()) {
                int idx = temp.indexOf(x);
                temp = temp.substring(0,idx) + "0" + temp.substring(idx+1);
                for(int j=0; j<col; j++) {
                    if(arr[0][j] == x && j ==idx) {
                        System.out.print(arr[i][j]);
                    }
                }
            }
        }
    }
}
