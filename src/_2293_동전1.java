import java.util.Scanner;

public class _2293_동전1 {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        int[] coin = new int[100];
        int[] dp = new int[10001];
        dp[0] = 1;
        for(int i = 0; i < n; i++){
            coin[i] = sc.nextInt();
            for(int j = 1; j <= k ; j++){
                if(coin[i] <= j){
                    dp[j] += dp[j - coin[i]];   // j-coin[i]을 만들 수 있는 경우의 수에 coin[i]를 만들 수 있는 경우의 수를 더함
                }
            }
        }
        System.out.println(dp[k]);
    }
}
// test1
// test2 - 하위브랜치 변경
// test3
// test conflict