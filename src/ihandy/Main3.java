package ihandy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<StringBuilder> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            list.add(new StringBuilder(sc.next()));
        }

        int count = n;
        boolean [] flag = new boolean[n];
        List<StringBuilder> res = new ArrayList<>();
        while (count-- > 0){
            StringBuilder max = new StringBuilder("0");
            int index = 0;
            for(int i = 0; i < n; i++){
                if(!flag[i]){
                    int a = 0, b = 0;
                    while(a < list.get(i).length() && b < max.length()){
                        if(list.get(i).charAt(a) < max.charAt(b)){
                            break;
                        }
                        else if(list.get(i).charAt(a) > max.charAt(b)){
                            max = list.get(i);
                            index = i;
                            break;
                        }
                        a++;
                        b++;
                    }
                    if(a >= list.get(i).length()){
                        for(int j = 0; j < n; j++){

                        }
                    }
                    else if( b >= max.length()){

                    }
                }
            }
            flag[index] = true;
            res.add(list.get(index));
        }


        for(int i = 0; i < n;  i++)
            System.out.print(res.get(i).toString());
    }
}
