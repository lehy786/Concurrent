package baicizhan;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            int m = sc.nextInt();
            ArrayList<Integer> arr = new ArrayList<>();
            for(int j = 0; j < m; j++)
                arr.add(sc.nextInt());
            list.add(arr);
        }

        //...................
        int length = list.size();
        int [] p = new int[n];
        ArrayList<Integer> res = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        while(length > 1){
            int min = Integer.MAX_VALUE;
            int index = 0;
            for(int i = 0; i < list.size(); i++){
                if(set.contains(i))
                    continue;
                int tmp = list.get(i).get(p[i]);
                if(tmp < min){
                    min = tmp;
                    index = i;
                }
            }

            res.add(min);
            p[index]++;

            if(p[index] >= list.get(index).size()){
                set.add(index);
                length--;
            }
        }

        //............
        if(!list.isEmpty()){
            for(int i = 0; i < list.size(); i++){
                if(set.contains(i))
                    continue;
                res.addAll(list.get(i));
                break;
            }
        }

        //............
        for(int i = 0; i < res.size(); i++) {
            if(i==0)
                System.out.print(res.get(i));
            else
                System.out.print(" " + res.get(i));
        }
    }
}

