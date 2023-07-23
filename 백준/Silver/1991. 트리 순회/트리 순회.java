import java.util.*;

public class Main {

    static class Node {
        String data;
        Node lt, rt;

        Node(String value) {
            this.data = value;
            lt = rt = null;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   //이진트리의 노드의 개수 n

        Node root = new Node("A");
        for(int i=0; i<n; i++) {
            String rootValue = sc.next();
            String leftValue = sc.next();
            String rightValue = sc.next();
            save(root, rootValue, leftValue, rightValue);
        }

        // 전위순회
        previousSearch(root);
        System.out.println();

        // 중위순회
        middleSearch(root);
        System.out.println();
        
        // 후위순회
        nextSearch(root);
    }

    // 전위순회
    private static void previousSearch(Node root) {
        if (root == null) return;
        else {
            System.out.print(root.data);
            previousSearch(root.lt);
            previousSearch(root.rt);
        }
    }
    
    // 중위순회
    private static void middleSearch(Node root) {
        if (root == null) return;
        else {
            middleSearch(root.lt);
            System.out.print(root.data);
            middleSearch(root.rt);
        }
    }

    // 후위순회
    private static void nextSearch(Node root) {
        if (root == null) return;
        else {
            nextSearch(root.lt);
            nextSearch(root.rt);
            System.out.print(root.data);
        }
    }

    private static void save(Node tmp, String root, String left, String right) {
        if(root.equals(tmp.data)) {
            tmp.lt = left.equals(".") ? null : new Node(left);
            tmp.rt = right.equals(".") ? null : new Node(right);
        } else {
            if (tmp.lt != null) save(tmp.lt, root, left, right);
            if (tmp.rt != null) save(tmp.rt, root, left, right);
        }
    }
}