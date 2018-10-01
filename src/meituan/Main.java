package meituan;

import java.util.*;

public class Main {
    static int count = 0;
    public static void main(String[] args) {
        /*
        给定一张包含N个点、N-1条边的无向连通图，
        节点从1到N编号，每条边的长度均为1。假设你从1号节点出发并打算遍历所有节点，
        那么总路程至少是多少？

        第一行包含一个整数N，1≤N≤105。
        接下来N-1行，每行包含两个整数X和Y，表示X号节点和Y号节点之间有一条边，1≤X，Y≤N。

        输出总路程的最小值。
         */

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int t = sc.nextInt();

        int a[] = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }

        System.out.println(solution(a,k,t));
    }

    public static int solution(int [] a, int k, int t){
        if(t > k || a.length < k)
            return 0;

        int n = a.length;
        int left = 0, right = k;
        Set<Integer> set = new HashSet<>();
        Map<Integer,Integer> map = new HashMap<>();

        for(int i = 0; i < k; i++){
            int key = a[i];
            if(set.contains(key))
                map.put(key, map.get(key) + 1);
            else{
                set.add(key);
                map.put(key,1);
            }
        }

        if(max(map) >= t)
            count++;

        while (right < n){
            int key = a[left++];
            if(set.contains(key) && map.containsKey(key)){
                if (map.get(key) > 1){
                    map.put(key,map.get(key) - 1);
                }
                else{
                    map.remove(key);
                    set.remove(key);
                }
            }

            int keyright = a[right++];
            if(set.contains(keyright))
                map.put(keyright, map.get(keyright) + 1);
            else{
                set.add(keyright);
                map.put(keyright,1);
            }

            if(max(map) >= t)
                count++;
        }
        return count;
    }

    public static int max(Map<Integer,Integer> map){
        int max = 0;
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue() > max)
                max = entry.getValue();
        }

        return max;
    }
}
