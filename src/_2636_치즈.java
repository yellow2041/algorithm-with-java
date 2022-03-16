import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class _2636_치즈 {
    static class Pair{
        int x;
        int y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int n,m;
    static int[][] arr = new int[100][100];
    static int[][] move = {{1,0},{0,1},{-1,0},{0,-1}};
    static void bfs(int num, int x, int y){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(x, y));
        arr[0][0] = 2;
        while(!q.isEmpty()){
            Pair p = q.poll();
            for(int i = 0; i < 4; i++) {
                int nx = p.x + move[i][0], ny = p.y + move[i][1];
                if (nx < n && ny < m && nx >= 0 && ny >= 0 && arr[nx][ny] == 0) {
                    arr[nx][ny] = num;
                    q.add(new Pair(nx,ny));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        int cnt = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                arr[i][j] = sc.nextInt();
                if(arr[i][j] == 1) cnt++;
            }
        }

        bfs(2, 0, 0);

        int time = 0;
        while(cnt > 0){
            time++;
            int out = 0;
            for(int i = 1; i < n - 1; i++){
                for(int j = 1; j < m - 1; j++){
                    if(arr[i][j] == 1) {
                        for (int k = 0; k < 4; k++) {
                            if (arr[i + move[k][0]][j + move[k][1]] == 2) {
                                arr[i][j] = 3;
                                out++;
                                for (int l = 0; l < 4; l++) {
                                    if (arr[i + move[l][0]][j + move[l][1]] == 0)  bfs(3, i + move[l][0], j + move[l][1]);
                                }
                                break;
                            }
                        }
                    }
                }
            }
            for(int i = 1; i < n - 1; i++) {
                for (int j = 1; j < m - 1; j++) {
                    if(arr[i][j] == 3) arr[i][j] = 2;
                }
            }
            if(cnt - out == 0) break;
            else cnt -= out;
        }
        System.out.println(time + "\n" + cnt);
    }
}
