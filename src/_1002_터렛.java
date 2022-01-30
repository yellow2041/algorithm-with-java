import java.util.Scanner;

public class _1002_터렛 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 0; i < t; i++){
            int x1 = sc.nextInt(), y1 = sc.nextInt(), x2 = sc.nextInt(), y2 = sc.nextInt(), r1= sc.nextInt(), r2 = sc.nextInt();
            int xr = -10000, yr = -10000;
            int ans = 0;
            for(int j = xr; j <= 10000; j++){
                for(int k = yr; k <= 10000; k++){
                    if((x1-j)*(x1-j) + (y1-k)*(y1-k) == r1*r1 && (x2-j)*(x2-j) + (y2-k)*(y2-k) == r2*r2){
                        ans++;
                        System.out.println(j + " / " + k);
                    }
//                    if((x1-x2)*(x1+x2-2*j)+(y1-y2)*(y1+y2-2*k) == r1*r1 - r2*r2){
//                        ans++;
//
//                    }
                }
            }
            System.out.println(ans);
        }
    }
}
