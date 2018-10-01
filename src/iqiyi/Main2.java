package iqiyi;

import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int p = sc.nextInt();
        int a[] = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }

        //....................
        sc.nextLine();
        for(int i = 0; i <= m; i++){
            String[] s = sc.nextLine().split(" ");
            if(s[0].equals("A")){
                a[Integer.parseInt(s[1])-1]++;
            }
            else if(s[0].equals("B")){
                a[Integer.parseInt(s[1])-1]--;
            }
        }

        int count = 1;
        for(int i = 0; i < n; i++){
            if(a[i] > a[p-1])
                count++;
        }

        System.out.println(count);
    }
}
