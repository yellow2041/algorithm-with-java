import java.util.Scanner;

public class _11720_하노이탑이동순서 {
    public static StringBuilder sb = new StringBuilder();
    public static int cnt = 0;

    public static void hanoi(int n, int p1, int p2, int p3){
        cnt++;
        if(n == 1){
            sb.append(p1 + " " + p3 + "\n");
            return;
        }
        hanoi(n-1, p1, p3, p2);
        sb.append(p1 + " " + p3 + "\n");
        hanoi(n-1,p2,p1,p3);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        hanoi(n,1,2,3);

        System.out.println(cnt);
        System.out.println(sb);
    }
}
