package dongfangcaifu;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        int sum = 0;
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
            sum += a[i];
        }

        //..........................
        boolean res = true;
        if(sum % 2 != 0)
            res = false;
        else{
            int target = sum / 2;
            res = judge(target,a,0);
        }

        //................
        System.out.println(res);
    }

    static boolean judge(int target, int [] a, int p){
        if(p==a.length)
            return false;

        if(target == 0)
            return true;

        for(int i = p; i < a.length; i++){
            if(judge(target-a[i],a,i+1))
                return true;
        }

        return false;
    }
}
