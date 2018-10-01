package kuaishou;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }

        //.....
        int i = 0, j = n-1;
        int max = 0;
        int left = a[i++], right = a[j--];
        while(i < j){
            if(left > right)
                right += a[j--];
            else if(left < right)
                left += a[i++];
            else{
                if(left > max)
                    max = left;
                left += a[i++];
                right += a[j--];
            }
        }

        if(left == right)
            if(left > max)
                max = left;

        System.out.println(max);
    }
}
