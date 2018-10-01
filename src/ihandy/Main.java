package ihandy;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String [] s = line.split(" ");
        System.out.println(s[s.length-1].length());
    }
}
