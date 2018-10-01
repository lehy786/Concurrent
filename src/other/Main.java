package other;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        line = line.substring(1,line.length()-1);
        String [] s = line.split(",");
        int [] a = new int[s.length];
        for(int i = 0; i < s.length; i++)
            a[i] = Integer.parseInt(s[i]);

        //...
        //[1,2,3,-3,5]
        System.out.println(dropOut(a));
    }

    private static boolean dropOut(int[] a){
        int n = a.length;
        int i = 0;
        boolean [] cover = new boolean[n];
        while(i < n && i >= 0){
            if((a[i] > 0 || a[i] < 0) && !cover[i]) {
                cover[i] = true;
                i += a[i];
            }
            else
                return false;
        }
        return true;
    }
}
