import java.util.Scanner;

public class _2529_부등호 {
    private static char[] inequlity = new char[9];
    private static int k;
    private static boolean[] visited = new boolean[10];
    private static int[] answerMin = new int[10];
    private static int[] answerMax = new int[10];


    private static void printIntArr(int[] arr){
        for(int i = 0; i <= k; i++) System.out.print(arr[i]);
    }

    private static boolean backtrackingMin(int idx){
        if(idx == k + 1) return true;
        for(int i = 0; i < 10; i++) {
            boolean isEnd = false;
            if(idx == 0) {
                answerMin[idx] = i;
                visited[i] = true;
                isEnd = backtrackingMin(idx+1);
                visited[i] = false;
            }
            else if (!visited[i]) {
                if((inequlity[idx - 1] == '<' && i > answerMin[idx - 1]) || (inequlity[idx - 1] == '>' && i < answerMin[idx - 1])) {
                    answerMin[idx] = i;
                    visited[i] = true;
                    isEnd = backtrackingMin(idx+1);
                    visited[i] = false;
                }
            }
            if(isEnd) return true;
        }
        return false;
    }
    private static boolean backtrackingMax(int idx){
        if(idx == k + 1) return true;
        for(int i = 9; i >= 0; i--) {
            boolean isEnd = false;
            if(idx == 0) {
                answerMax[idx] = i;
                visited[i] = true;
                isEnd = backtrackingMax(idx+1);
                visited[i] = false;
            }
            else if (!visited[i]) {
                if((inequlity[idx - 1] == '<' && i > answerMax[idx - 1]) || (inequlity[idx - 1] == '>' && i < answerMax[idx - 1])) {
                    answerMax[idx] = i;
                    visited[i] = true;
                    isEnd = backtrackingMax(idx+1);
                    visited[i] = false;
                }
            }
            if(isEnd) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();

        for(int i = 0; i < k; i++){
            String tmpInequlity = sc.next();
            inequlity[i] = tmpInequlity.charAt(0);
        }
        backtrackingMax(0);
        printIntArr(answerMax);
        System.out.println();
        backtrackingMin(0);
        printIntArr(answerMin);

    }
}
