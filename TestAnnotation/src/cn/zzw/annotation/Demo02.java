package cn.zzw.annotation;


@MyAnnotation01
public class Demo02 {
	
	@MyAnnotation01(age=19,studentName="zzw",id=101,schools= {"暨南大学","北京大学"})
	public void test1() {
		System.out.println("----test MyAnnotation1-----------");
	}
	
	@MyAnnotation02("大学生")
	public void test2() {
		System.out.println("----test MyAnnotation2-----------");
	}
	
	
	public static void main(String[] args) {
		
	}

}
