package dongfangcaifu;

import java.util.ArrayList;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String [] s = line.split(",");
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < s.length; i++){
            list.add(Integer.parseInt(s[i]));
        }

        ArrayList<Integer> res = max(list);
        for(int i = 0; i < res.size(); i++){
            if(i == 0)
                System.out.print(res.get(i));
            else
                System.out.print(" " + res.get(i));
        }

    }

    public static ArrayList<Integer> max(ArrayList<Integer> list){
        ArrayList<Integer> res = new ArrayList<>();
        int b1 = 0, b2 = 0, s1 = 0, s2 = 0;
        int buy1 = Integer.MIN_VALUE, sell1 = 0, buy2 = Integer.MIN_VALUE, sell2 = 0;
        for(int i = 0; i < list.size(); i++){
//            buy1 = Math.max(buy1,-list.get(i));
            if(buy1 < -list.get(i)){
                buy1 = -list.get(i);
                b1 = i+1;
            }

//            sell1 = Math.max(sell1, buy1+list.get(i));
            if(sell1 < buy1+list.get(i)){
                sell1 = buy1+list.get(i);
                s1 = i+1;
            }

//            buy2 = Math.max(buy2,sell2-list.get(i));
            if(buy2 < sell2-list.get(i)){
                buy2 = sell2-list.get(i);
                b2 = i+1;
            }

//            sell2 = Math.max(sell2,buy2+list.get(i));
            if(sell2 < buy2+list.get(i)){
                sell2 = buy2+list.get(i);
                s2 = i+1;
            }
        }

        res.add(b1);
        res.add(s1);
        res.add(b2);
        res.add(s2);
        return res;
    }
}
