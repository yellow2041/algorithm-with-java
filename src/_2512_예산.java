import java.util.Arrays;
import java.util.Scanner;

public class _2512_예산 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] budget = new int[10000];
        int sum = 0, ans = 0;
        for(int i = 0; i < n; i++){
            budget[i] = sc.nextInt();
            sum += budget[i];
        }
        Arrays.sort(budget, 0, n);
        int totalBudget = sc.nextInt();
        if(sum <= totalBudget) System.out.println(budget[n-1]);
        else{
            int left = 0;
            int right = budget[n-1];
            while(left <= right){
                int mid = (left + right) / 2;
                sum = 0;
                for(int i = 0; i < n; i++){
                    if(budget[i] < mid) sum += budget[i];
                    else sum += mid;
                }
                if(sum > totalBudget){
                    right = mid - 1;
                }
                else {
                    ans = mid;
                    left = mid + 1;
                }
            }
            System.out.println(ans);
        }
    }
}
