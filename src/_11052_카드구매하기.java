import java.util.Scanner;

public class _11052_카드구매하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] dp = new int[1000];

        for(int i = 0; i < n; i++){
            dp[i] = sc.nextInt();
            for(int j = 0; j < (i % 2 == 0 ? i / 2 : i / 2 + 1); j++){
                int dpTmp = dp[j] + dp[i - j - 1];
                if(dp[i] < dpTmp) dp[i] = dpTmp;
            }
        }
        System.out.println(dp[n - 1]);
    }
}
