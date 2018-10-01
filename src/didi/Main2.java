package didi;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String strArr[] = sc.nextLine().split(" ");
        String key = strArr[0];
        int [] prices = new int[strArr.length];
        Set<Character> set1 = new HashSet<>();
        Set<Character> set2 = new HashSet<>();
        StringBuilder sb1 = new StringBuilder("qwertasdfgzxcv");
        StringBuilder sb2 = new StringBuilder("yuiophjklbnm");
        for(int i = 0; i < sb1.length(); i++)
            set1.add(sb1.charAt(i));
        for(int i = 0; i < sb2.length(); i++)
            set2.add(sb2.charAt(i));

        for(int i = 1; i < strArr.length; i++){
            prices[i] = dynamicPlan(key,strArr[i],set1,set2);
        }
        for(int j = 0; j < 3; j++){
            int min = Integer.MAX_VALUE;
            int index = 0;
            for(int i = 1; i < prices.length;i++){
                if(prices[i] < min) {
                    min = prices[i];
                    index = i;
                }
            }
            prices[index] = Integer.MAX_VALUE;
            if(j==0)
                System.out.print(strArr[index]);
            else
                System.out.print(" " + strArr[index]);
        }
    }

    public static int dynamicPlan(String s1, String s2, Set<Character> set1,  Set<Character> set2){
        if(s1==null || s2==null)
            return Integer.MAX_VALUE;

        int n1 = s1.length(), n2 = s2.length();
        int [][] dp = new int [n1+1][n2+1];
        for(int i = 1; i <= n1; i++)
            dp[i][0] = 3 * i;
        for(int i = 1; i <= n2; i++)
            dp[0][i] = 3 * i;

        for(int i = 1; i <= n1; i++){
            for(int j = 1; j <= n2; j++){
                char c1 = s1.charAt(i-1), c2 = s2.charAt(j-1);
                if(c1 == c2){
                    dp[i][j] = dp[i-1][j-1];
                }
                else{
                    int k1 = dp[i-1][j] + 3;
                    int k2 = dp[i][j-1] + 3;
                    int k3 = 0;
                    if(set1.contains(c1) && set2.contains(c2))
                        k3 = 2 + dp[i-1][j-1];
                    else
                        k3 = 1 + dp[i-1][j-1];
                    dp[i][j] = Math.min(k1,Math.min(k2,k3));
                }
            }
        }
        return dp[n1][n2];
    }
}
