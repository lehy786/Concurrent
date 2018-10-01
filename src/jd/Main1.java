package jd;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Product> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            Product product = new Product(a,b,c);
            list.add(product);
        }
        list.sort(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                if(o1.a > o2.a)
                    return 1;
                else if(o1.a < o2.a)
                    return -1;
                else{
                    if(o1.b > o2.b)
                        return 1;
                    else if(o1.b < o2.b)
                        return -1;
                    else{
                        if(o1.c > o2.c)
                            return 1;
                        else if(o1.c < o2.c)
                            return -1;
                        else
                            return 0;
                    }
                }
            }
        });

        //........................
//        for(Product p : list){
//            System.out.println(p.a + "," + p.b + "," + p.c);
//        }

        //......................
        int count = 0;
        for(int i = 0; i < list.size(); i++){
            int cur = list.size() - 1;
            while(cur >= i){
                if(list.get(cur).compareTo(list.get(i)) > 0){
                    count++;
                    break;
                }
                cur--;
            }
        }

        System.out.println(count);
    }
}

class Product implements Comparable<Product>{
    int a;
    int b;
    int c;
    public Product(int a, int b, int c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public int compareTo(Product o) {
        if(this.a > o.a && this.b > o.b && this.c > o.c)
            return 1;
        else
            return -1;
    }
}
