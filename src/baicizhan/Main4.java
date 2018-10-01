package baicizhan;

import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }
        int k = sc.nextInt();


        //........................
        System.out.println(judge(a,k));
    }

    public static boolean judge(int [] a, int k){
        if(a==null || a.length <= 0)
            return false;

        return dfs(a,0,k);
    }

    public static boolean dfs(int [] a, int start, int k){
        if(start == a.length)
            return false;

        if(k == a[start])
            return true;

        for(int i = start; i < a.length; i++){
            if(dfs(a,i + 1, k - a[i]))
                return true;
        }

        return false;
    }
}
