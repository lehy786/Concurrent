package baicizhan;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        char a[][] = new char[m][n];
        for(int i = 0; i < m; i++){
            String s = in.next();
            if(s.length() == n){
                for(int j = 0; j < n; j++)
                    a[i][j] = s.charAt(j);
            }
            else
                System.out.println("error input...");
        }

        String word = in.next();
        char c = word.charAt(0);
        int row = 0, col = 0;
        boolean res = false;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(a[i][j]==c) {
                    row = i;
                    col = j;
                    if(dfs(a,row,col,word,0)) {
                        res = true;
                        break;
                    }
                }
            }
            if(res)
                break;
        }

        //.............
        System.out.println(res);
    }

    public static boolean dfs(char [][] a, int i, int j, String word, int p){
        if(i<0 || j<0 || i>=a.length || j>=a[0].length)
            return false;

        if(word.charAt(p)==a[i][j]){
            if(p==word.length()-1)
                return true;
            else{
                //...................
                int dx[] = {0,0,1,-1};
                int dy[] = {1,-1,0,0};

                for(int m = 0; m < 4; m++){
                    if(dfs(a,i+dx[m],j+dy[m],word,p+1))
                        return true;
                }
                //...................
            }
        }

        return false;
    }
}
