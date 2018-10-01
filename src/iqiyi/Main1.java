package iqiyi;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        int [] a = new int[line.length()];
        for(int i = 0; i < line.length(); i++)
            a[i] = Integer.parseInt(line.substring(i,i+1));

        //.......................
        int res = 0;
        int sum1 = 0, sum2 = 0;
        for(int i = 0; i < 3; i++){
            sum1 += a[i];
            sum2 += a[i+3];
        }
        int sub = 0;
        int shift = 0;
        if(sum1 > sum2){
            sub = sum1-sum2;
            //记录小的一边
            shift = 3;
        }
        else{
            sub = sum2-sum1;
        }

        if(sub == 0)
            res = 0;
        else{
            int k1 = 9-a[shift];
            int k2 = 9-a[1+shift];
            int k3 = 9-a[2+shift];
            if(k1 < k2){
                int t = k1;
                k1 = k2;
                k2 = t;
            }
            if(k2 < k3){
                int t = k2;
                k2 = k3;
                k3 = t;
            }
            if(k1 < k2){
                int t = k1;
                k1 = k2;
                k2 = t;
            }

            if(k1 >= sub)
                res = 1;
            else if(k1 + k2 >= sub)
                res = 2;
            else
                res = 3;
        }

        //........................
        System.out.println(res);
    }
}
