import java.util.Arrays;
import java.util.Scanner;

public class _10867_중복빼고정렬하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[100000];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr,0,n);
        int pre = arr[0];
        System.out.print(arr[0] + " ");
        for(int i = 1; i < n; i++){
            if(arr[i] != pre){
                System.out.print(arr[i] + " ");
                pre = arr[i];
            }
        }
    }
}