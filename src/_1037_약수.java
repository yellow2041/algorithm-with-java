import java.util.Arrays;
import java.util.Scanner;

public class _1037_약수 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] a = new int[50];

        for(int i = 0;i < n; i++){
            a[i] = sc.nextInt();
        }

        Arrays.sort(a, 0, n);

        System.out.println(a[0] * a[n - 1]);
    }
}
