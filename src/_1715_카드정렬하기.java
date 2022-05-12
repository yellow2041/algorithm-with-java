import java.util.PriorityQueue;
import java.util.Scanner;

public class _1715_카드정렬하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < n; i++){
            int card = sc.nextInt();
            pq.add(card);
        }
        int ans = 0;
        while(pq.size() > 1){
            int compare = pq.poll() + pq.poll();
            ans += compare;
            pq.add(compare);
        }
        System.out.println(ans);
    }
}
