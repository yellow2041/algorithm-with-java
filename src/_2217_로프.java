import java.util.Arrays;
import java.util.Scanner;

public class _2217_로프 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int rope[] = new int[100000];

        for(int i = 0; i < n; i++){
            rope[i] = sc.nextInt();
        }

        Arrays.sort(rope, 0, n);
        int ans= 0;
        for(int i = 0; i < n; i++){
            if(rope[i]*(n - i) > ans) ans = rope[i]*(n - i);
        }

        System.out.println(ans);
    }
}
