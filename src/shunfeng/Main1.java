package shunfeng;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] a = new int [n];
        int [] b = new int [n];
        for(int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        for(int i = 0; i < n; i++)
            b[i] = sc.nextInt();

        //.........................
        int count = 0;
        Map<Integer,Integer> m1 = new HashMap<>();
        Map<Integer,Integer> m2 = new HashMap<>();
        for(int i = 0; i < n; i++){
            m1.put(a[i],i);
        }
        for(int i = 0; i < n; i++){
            m2.put(b[i],i);
        }

        for(int i = 0; i < n-1; i++){
            for(int j = i+1; j < n; j++){
                if(m1.get(a[i]) > m1.get(a[j])){
                    if(m2.get(a[i]) < m2.get(a[j]))
                        count++;
                }
                else if(m1.get(a[i]) < m1.get(a[j])){
                    if(m2.get(a[i]) > m2.get(a[j]))
                        count++;
                }
            }
        }

        System.out.println(count);
    }
}
