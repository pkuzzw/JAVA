package cn.zzw.basic;

public class Base {
	private void test() {
		String aStr=" One ";
		String bStr=aStr;
		aStr.toUpperCase();
		aStr.trim();
		System.out.println("["+aStr+","+bStr+"]");
	}
	public static void main(String[] args) {
		new Base().test();
		int x=4;
		System.out.println("value is "+ ((x>4) ? 99.9:9));
	}
	

}
