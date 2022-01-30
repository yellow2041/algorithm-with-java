import java.util.Arrays;
import java.util.Scanner;

public class _1427_소트인사이드 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[10];
        int len = 0;
        while(n>0){
            arr[len] = n % 10;
            n /= 10;
            len++;
        }
        Arrays.sort(arr,0,len);
        for(int i = len - 1; i >= 0; i--){
            System.out.print(arr[i]);
        }
    }
}
