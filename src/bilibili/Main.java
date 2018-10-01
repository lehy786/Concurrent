package bilibili;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        while(n >0) {
            if (n % 2 == 0) {
                n = (n-2)/2;
                stack.push('3');
            }
            else{
                n = (n-1)/2;
                stack.push('2');
            }
        }

        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }

        System.out.println(sb.toString());
    }
}
