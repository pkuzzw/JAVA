/**
   复习 Interface的使用
   定义格式
   [可见度] interface  接口名称 [extends 父接口] {
      //声明变量
      //抽象方法
   }
   接口有以下特性：
	接口是隐式抽象的，当声明一个接口的时候，不必使用abstract关键字。
	接口中每一个方法也是隐式抽象的，声明时同样不需要abstract关键字。
	接口中的方法都是公有的。

 * 
 */
package cn.zzw.testinterface;

/**
 * @author zzw
 *
 */
public interface NameOfInterface {
	public static final int countName=0;
	public abstract void eat();
	public void shout();
}
