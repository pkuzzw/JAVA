package cn.zzw.io;


/**
 * 模拟咖啡
 * @author zzw
 *
 */

public class Decorate01 {
	public static void main(String[] args) {
		Person p=new Person();
		p.say();
		
		System.out.println("经过装饰之后");
		Amplifier am= new Amplifier(p);
		am.say();
	}

}
interface Say{
	//接口不能有具体实现
	void say();
}
class Person implements Say{
	private int voice=10;
	

	public int getVoice() {
		return voice;
	}


	public void setVoice(int voice) {
		this.voice = voice;
	}


	@Override
	public void say() {
		System.out.println("人的声音为:"+this.getVoice());
	}
	
}

class Amplifier implements Say{
	private Person p;
	public Amplifier(Person p){
		this.p=p;
	}

	@Override
	public void say() {
		System.out.println("人的声音为:"+p.getVoice()*10);

	}
}