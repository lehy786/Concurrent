package mogujie;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt(), y = sc.nextInt();
        int  [][] dp = new int[x+1][y+1];
        dp[0][0] = 0;
        for(int i = 1; i <= x; i++)
            dp[i][0] = 1;
        for(int i = 1; i <= y; i++)
            dp[0][i] = 1;
        for(int i = 1; i <= x; i++){
            for(int j = 1; j <= y; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        System.out.println(dp[x][y]);
    }
}
