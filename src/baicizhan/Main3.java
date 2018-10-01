package baicizhan;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        int range = (int)Math.sqrt(num);
        boolean res = true;
        for(int i = 2; i <= range; i++){
            int mod = num % i;
            if(mod == 0) {
                res = false;
                break;
            }
        }

        System.out.println(res);
    }
}
