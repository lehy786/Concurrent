package kuaishou;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<LW> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            LW lw = new LW(sc.nextInt(), sc.nextInt());
            list.add(lw);
        }

        int [] dp = new int[list.size()];
        dp[0] = 1;
        for(int i = 1; i < list.size(); i++){
            int max=0, j=0;
            while(j<i)
            {
                if(list.get(i).w >= list.get(j).w && list.get(i).l >= list.get(j).l){
                    if(dp[j] > max)
                        max = dp[j];
                }
                j++;
            }
            dp[i] = max + 1;
        }

        int res = 0;
        for(int i = 0; i < n; i++)
            if(res < dp[i])
                res = dp[i];
        System.out.println(res);
    }
}

class LW{
    int w = 1;
    int l = 1;
    public LW(int w, int l){
        this.w = w;
        this.l = l;
    }
}
