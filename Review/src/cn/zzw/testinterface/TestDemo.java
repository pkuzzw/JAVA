package cn.zzw.testinterface;

abstract class A{//定义一个抽象类

    static abstract class B{//static定义的内部类属于外部类
        public abstract void print();
    }

}

class C extends A.B{

    public void print(){
        System.out.println("**********");
    }
}
public class TestDemo {

    public static void main(String[] args) {
        A.B ab = new C();//向上转型
        ab.print();
    }

}