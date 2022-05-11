import java.util.Arrays;
import java.util.Scanner;

public class _2110_공유기설치 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(),c = sc.nextInt();
        int[] wifi = new int[200000];

        for(int i = 0; i < n; i++){
            wifi[i] = sc.nextInt();
        }

        Arrays.sort(wifi,0,n);

        int left = 1, right = wifi[n-1] - wifi[0];
        int ans = 0;
        while(left <= right){
            int mid = (left + right) / 2;
            int cnt = 1;
            int preWifi = wifi[0];

            for(int i = 1; i < n; i++){
                if(wifi[i] - preWifi >= mid){
                    cnt++;
                    preWifi = wifi[i];
                }
            }

            if(cnt >= c){
                ans = mid;
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        System.out.println(ans);
    }
}
