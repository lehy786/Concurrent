package mogujie;

import java.util.*;

public class Main2 {
    public static ArrayList<String> result = new ArrayList<String>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line1 = sc.nextLine();
        String line2 = sc.nextLine();
        for(int i = 0; i < line1.length(); i++)
            if(line1.charAt(i) == '"')
                line1 = line1.substring(i+1,line1.length()-1);

        String [] s = line2.split("\"");
        Set<String> set = new HashSet<>();
        for(int i = 1; i < s.length; i+=2)
            set.add(s[i]);

        wordBreak(line1,set);
        for(int i = 0; i < result.size(); i++){
            if(i == 0)
                System.out.print("[" + result.get(i));
            else
                System.out.print(", " + result.get(i));
        }
        System.out.println("]");

    }

    public static void helper(String s, Set<String> dict, int start, String item){
        if(start<=0){
            result.add(item.substring(0,item.length()-1));
            return;
        }

        for(int i = start; i>=0; i--){
            if(dict.contains(s.substring(i,start))){
                helper(s,dict,i,s.substring(i,start)+" "+item);
            }
        }
    }
    public static ArrayList<String> wordBreak(String s, Set<String> dict) {
        helper(s,dict,s.length(),"");
        return result;
    }
}
