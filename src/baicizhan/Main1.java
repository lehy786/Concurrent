package baicizhan;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        if(s.equals("") || s.length() <= 0)
            System.out.println("0");
        else{
            int len = s.length()-1;
            boolean neg = s.charAt(0)=='-';
            StringBuilder sb = new StringBuilder();
            while(len>=0){
                if(s.charAt(len)=='0')
                    s = s.substring(0,len);
                else
                    break;
                len--;
            }

            while(len>=0){
                if(len == 0 && s.charAt(len)=='-')
                    break;
                else
                    sb.append(s.charAt(len));
                len--;
            }

            System.out.println((neg ? '-' : "") + sb.toString());
        }


    }
}
