package jd;

import java.util.ArrayList;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 0; i < T; i++){
            //...................start of group i
            int N = sc.nextInt();
            int M = sc.nextInt();
            int [][] mat = new int[N+1][N+1];
            for(int j = 0; j < M; j++){
                int a = sc.nextInt();
                int b = sc.nextInt();
                mat[a][b] = 1;
                mat[b][a] = 1;
            }

            if(judge(N,M,mat))
                System.out.println("Yes");
            else
                System.out.println("No");
            //...................end of group i
        }
    }

    public static boolean judge(int n, int m, int [][] mat){
       return true;

    }
}
