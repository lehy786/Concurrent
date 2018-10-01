package shunfeng;
import java.util.*;
public class Main2{
    static ArrayList<String> result = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int l = sc.nextInt();

        result.clear();
        fullJustify(str.split(","), l,result);
        if(result.isEmpty())
            System.out.println("");
        else {
            for (String s : result) {
                System.out.println("'" + s + "'");
            }
        }
    }

    public static void fullJustify(String[] words, int L,ArrayList<String> list) {
        int length = words.length;
        for(int i = 0;i < length;){
            int len = words[i].length();

            //当前行以遍历到的第i个单词开头
            StringBuilder line = new StringBuilder(words[i]);
            //往后加空格和单词，算出行的总长度，限制在L内
            int j=i+1;
            for(;j < length && len+1+words[j].length()<=L;j++){
                len +=(1+words[j].length());
            }
            //已经加到了最后一个单词,则当前处理行是最后一行
            if(j == length){
                for(int k = i+1; k < length; k++){
                    line.append(" ").append(words[k]);
                }
                while(line.length() < L){
                    line.append(" ");
                }
            }
            //不是最后一行
            else{
                int blank = L-len;//有几个空格要放
                int gap = j-i-1;//j-i为该行单词数，再-1为单词间隔数

                //只有一个单词的行
                if(gap==0){
                    while(line.length()<L){
                        line.append(" ");
                    }
                }else{
                    //正常情况
                    for(int k=i+1;k<j;k++){
                        line.append(" ");
                        for(int m=0;m<blank/gap;m++){
                            line.append(" ");
                        }
                        if(k-i<=blank%gap){
                            line.append(" ");
                        }
                        line.append(words[k]);
                    }
                }
            }
            list.add(line.toString());
            i = j; //当前处理到了第j+1个单词
        }
    }
}
