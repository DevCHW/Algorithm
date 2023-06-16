class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int gcdA = arrayA[0];
        int gcdB = arrayB[0];
        int len = arrayA.length;
        
        //각 배열의 최대공약수 구하기.
        for(int i=1; i<len; i++) {
            gcdA = gcd(gcdA, arrayA[i]);
            gcdB = gcd(gcdB, arrayB[i]);
        }
        
        boolean flagA = gcdB == 1 ? false:true;
        boolean flagB = gcdA == 1 ? false:true;
        for(int i=0; i<len; i++) {
            if(arrayA[i] % gcdB == 0) flagA = false;
            if(arrayB[i] % gcdA == 0) flagB = false;
        }
        
//         System.out.println("gcdA = " + gcdA);
//         System.out.println("gcdB = " + gcdB);
        
//         System.out.println("flagA = " + flagA);
//         System.out.println("flagB = " + flagB);
        
        if(!flagA && flagB) {
            return gcdA;
        } else if (flagA && !flagB) {
            return gcdB;
        } else if (flagA && flagB) {
            return Math.max(gcdA, gcdB);
        } else {
            return 0;
        }
    }
    
    private int gcd(int a, int b) {
        if (a < b) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        
        while(b > 0) {
            int tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }
}