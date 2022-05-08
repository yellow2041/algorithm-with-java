import java.util.Scanner;

public class _2661_좋은수열 {
    private static String seq = "";
    private static int n;
    private static boolean check = false;
    private static void backtracking(int dept){
        for(int i = 1; i <= 3; i++){
            seq += Integer.toString(i);
            int seqLen = seq.length();
            int j, k;
            for(j = seqLen-1, k = 1 ; j - k >= 0; j--,k++){
                if(seq.substring(j,seqLen).equals(seq.substring(j - k,j))) break;
            }
            if(j - k < 0) {
                if (seqLen == n) check = true;
                else {
                    backtracking(dept + 1);
                }
            }
            if(check) return;
            else seq = seq.substring(0, seqLen-1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        backtracking(0);
        System.out.println(seq);
    }
}
