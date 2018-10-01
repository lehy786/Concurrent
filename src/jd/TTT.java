package jd;

public class TTT {

    public static void main(String[] args) {
        B b = new B();
//        System.out.println(B.s);
    }

}
class A {
    static {
        System.out.println("AA");
    }
}
class B extends A{
    public B(){
        System.out.println("gouzao");
    }
    {
        System.out.println("VV");
    }
    static{
        System.out.println("BB");
    }
//    final static String s = new String("DD");
    final static String s ="DD";
}