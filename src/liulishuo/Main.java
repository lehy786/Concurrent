package liulishuo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1,5,10,20,50};
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] map = new int[arr.length+1][n+1];
        System.out.println(process(arr,0,n, map));
    }

    public static int process(int[] arr,int index,int aim,int[][] map){
        int res = 0;
        if(index == arr.length){
            res = aim == 0 ? 1:0;
        }else{
            int mapValues = 0;
            for(int i = 0; arr[index] * i <= aim;i++ ){
                mapValues = map[index+1][aim - arr[index]*i];
                if(mapValues != 0) {
                    res += mapValues == -1?0:mapValues;
                }else {
                    res += process(arr,index+1,aim-arr[index]*i,map);
                }
            }
        }
        map[index][aim] = res == 0?-1:res;
        return res;
    }

}
