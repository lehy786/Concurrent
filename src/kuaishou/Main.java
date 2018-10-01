package kuaishou;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //this is for 。。。
        Scanner sc = new Scanner(System.in);
        String [] s1 = sc.nextLine().split(" ");
        String [] s2 = sc.nextLine().split(" ");
        int [] a1 = new int [s1.length];
        int [] a2 = new int [s2.length];
        for(int i = 0; i < s1.length; i++){
            a1[i] = Integer.parseInt(s1[i]);
            a2[i] = Integer.parseInt(s2[i]);
        }

        //...........
        TreeNode tree = reBuild(a1,0,a1.length-1,a2,0,a2.length-1);

        //...........
        dfsAgain(tree);
        List<Integer> list = new ArrayList<>();
        order(tree,list);
        for(int i = 0; i < list.size(); i++){
            if(i == 0)
                System.out.print(list.get(i));
            else
                System.out.print(" " + list.get(i));
        }
    }

    public static void order(TreeNode root, List<Integer> list){
        if(root == null)
            return;
        order(root.left,list);
        list.add(root.value);
        order(root.right,list);
    }

    public static int dfsAgain(TreeNode root){
        if(root == null)
            return 0;
        int left = dfsAgain(root.left);
        int right = dfsAgain(root.right);
        int temp = root.value;
        root.value = left + right;

        return temp+root.value;
    }


    public static TreeNode reBuild(int [] pre, int startPre, int endPre, int [] in, int startIn, int endIn) {
        if(startPre>endPre||startIn>endIn) {
            return null;
        }

        TreeNode root = new TreeNode(pre[startPre]);
        for(int i=startIn;i<in.length;i++) {
            if(pre[startPre]==in[i]) {
                root.left = reBuild(pre,startPre+1,startPre+(i-startIn),in,startIn,i-1);
                root.right = reBuild(pre,startPre+i-startIn+1,endPre,in,i+1,endIn);
            }
        }

        return root;
    }


}

class TreeNode{
    TreeNode left = null;
    TreeNode right = null;
    int value = 0;
    public TreeNode(int value){
        this.value = value;
    }
}
