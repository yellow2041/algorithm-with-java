import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class _1926_연료채우기 {
    static class Pair implements Comparable<Pair> {
        public int x;
        public int y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public int compareTo(Pair p) {
            if (this.x < p.x) return -1;
            return 1;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Pair[] oil = new Pair[10001];
        for(int i = 0 ; i < n; i++){
            String[] input = br.readLine().split(" ");
            oil[i] = new Pair(Integer.parseInt(input[0]),Integer.parseInt(input[1]));
        }
        Arrays.sort(oil,0,n);
        String[] input = br.readLine().split(" ");
        int l = Integer.parseInt(input[0]), p = Integer.parseInt(input[1]);
        int ans = 0, preDist = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        oil[n] = new Pair(l,0);

        for(int i = 0; i <= n ; i++){
            if(preDist > l) break;
            if(oil[i].x - preDist > p){
                if(pq.isEmpty()){
                    ans = -1;
                    break;
                }
                while(oil[i].x - preDist > p) {
                    if(pq.isEmpty()){
                        System.out.println(-1);
                        return;
                    }
                    p += pq.poll();
                    ans++;
                }
            }
            pq.add(oil[i].y);
            p -= (oil[i].x - preDist);
            preDist = oil[i].x;
        }
        System.out.println(ans);
    }
}
