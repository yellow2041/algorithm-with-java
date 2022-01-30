import java.util.Scanner;

public class _16767_배열복원하기 {
    public static void main(String[] args){
        int[][] arrA = new int[300][300];
        int[][] arrB = new int[600][600];
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt(), w = sc.nextInt(), x = sc.nextInt(), y = sc.nextInt();
        for(int i = 0; i < h + x; i++){
            for(int j = 0; j < w + y; j++){
                arrB[i][j] = sc.nextInt();
            }
        }
        for(int i = h + x - 1; i >= x; i--){
            for(int j = w + y - 1; j >= y; j--){
                arrA[i - x][j - y] = arrB[i][j];
            }
        }
        for(int i = 0; i < x; i++){
            for(int j = 0; j < w; j++){
                arrA[i][j] = arrB[i][j];
            }
        }
        for(int i = x; i < h; i++){
            for(int j = 0; j < y; j++){
                arrA[i][j] = arrB[i][j];
            }
        }
        for(int i = h - x - 1; i >= x; i--){
            for(int j = w - y - 1; j >= y; j--){
                arrA[i][j] -= arrA[i + x][j + y];
            }
        }
        for(int i = 0; i < h; i++){
            for(int j = 0; j < w; j++){
                System.out.print(arrA[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
