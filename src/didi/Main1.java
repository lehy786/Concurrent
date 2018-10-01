package didi;

import java.util.Scanner;

public class Main1 {
    static int num = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int np = sc.nextInt();
        int nq = sc.nextInt();
        int nr = sc.nextInt();

        count(np+nq+nr,1,np-1, nq, nr,1);
        count(np+nq+nr,1,np, nq-1, nr,2);
        count(np+nq+nr,1,np, nq, nr-1,3);

        System.out.println(num);
    }

    //out表示这次index位置不能放q，p，r中表示out的球
    public static void count(int length, int index, int np, int nq, int nr, int out){
        if(np < 0 || nq < 0 || nr < 0)
            return;
        if(index >= length) {
            num++;
            return;
        }
        if(out == 1){
            count(length,index+1,np,nq-1,nr,2);
            count(length,index+1,np,nq,nr-1,3);
        }
        else if(out == 2){
            count(length,index+1,np-1,nq,nr,1);
            count(length,index+1,np,nq,nr-1,3);
        }
        else if(out == 3){
            count(length,index+1,np-1,nq,nr,1);
            count(length,index+1,np,nq-1,nr,2);
        }
    }
}
