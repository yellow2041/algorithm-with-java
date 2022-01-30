import java.util.Scanner;

public class _3085_사탕게임 {
    private static char[][] arr = new char[50][50];
    private static int n;

    private static void swap(int i1, int j1, int i2, int j2){
        char temp = arr[i1][j1];
        arr[i1][j1] = arr[i2][j2];
        arr[i2][j2] = temp;
    }

    private static int getLen(int i, int j){
        int row = 0, col = 0, tmpI = i, tmpJ = j;
        while(tmpJ > 0 && arr[i][tmpJ - 1] == arr[i][j]) tmpJ--;
        while(tmpJ < n && arr[i][tmpJ++] == arr[i][j]) row++;
        while(tmpI > 0 && arr[tmpI - 1][j] == arr[i][j]) tmpI--;
        while(tmpI < n && arr[tmpI++][j] == arr[i][j]) col++;
        return row > col ? row : col;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sc.nextLine();
        for(int i = 0; i < n; i++){
            String str = sc.nextLine();
            for(int j = 0; j < n; j++){
                arr[i][j] = str.charAt(j);
            }
        }
        int max = 0;
        for(int i = 0; i < n ; i++){
            for(int j = 0; j < n; j++){
                if(j < n - 1 && arr[i][j] != arr[i][j + 1]){
                    swap(i,j,i,j+1);
                    int len1 = getLen(i,j), len2 = getLen(i,j+1);
                    if(max < len1) max = len1;
                    if(max < len2) max = len2;
                    swap(i,j,i,j+1);
                }
                if(i < n - 1 && arr[i][j] != arr[i + 1][j]){
                    swap(i,j,i+1,j);
                    int len1 = getLen(i,j), len2 = getLen(i+1,j);
                    if(max < len1) max = len1;
                    if(max < len2) max = len2;
                    swap(i,j,i+1,j);
                }
                int len = getLen(i,j);
                if(max < len) max = len;
            }
        }
        System.out.println(max);
    }
}
