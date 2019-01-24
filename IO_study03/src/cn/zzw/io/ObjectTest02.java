package cn.zzw.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;


/**
 * 测试DataInputStream DataOutputStream
 * 1 写出后读取
 * 2 读出与写入顺序要一致
 *  
 *  ObjectInputStream
 *  ObjectOutputStream
 *  不是所有的对象都可以序列化,必须实现Serializable接口
 * 
 * @author zzw
 *
 */
public class ObjectTest02 {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		//先写出  序列化
		ByteArrayOutputStream baos= new ByteArrayOutputStream();
		ObjectOutputStream oos=new ObjectOutputStream(new BufferedOutputStream(baos));
		//操作数据类型+数据
		oos.writeUTF("编码辛酸泪");
		oos.writeChar('c');
		oos.writeInt(5);
		oos.writeBoolean(true);
		//加入对象
		oos.writeObject("谁解其中味");
		oos.writeObject(new Date());
		Employee employee=new Employee("马云", 50);
		oos.writeObject(employee);
		
		
		oos.flush();
		byte[] datas= baos.toByteArray();
		//读取  反序列化
		ObjectInputStream ois=new ObjectInputStream(new BufferedInputStream(new ByteArrayInputStream(datas)));
		String str=ois.readUTF();
		char c=ois.readChar();
		int i=ois.readInt();
		boolean b=ois.readBoolean();
		Object strObject=ois.readObject();
		Object dateObject=ois.readObject();
		Object emplObject=ois.readObject();

	
		
		System.out.println("str:\t"+str);
		System.out.println("char:\t"+c);
		System.out.println("int:\t"+i);
		System.out.println("boolean:\t"+b);
		if (strObject instanceof String) {
			System.out.println((String)strObject);
		}
		if (dateObject instanceof Date) {
			System.out.println((Date)dateObject);
		}
		if (emplObject instanceof Employee) {
			System.out.println((Employee)emplObject);
		}
	}
}

//javabean用来封装数据

class Employer implements java.io.Serializable{
	private String nameString;
	private int age;
	public Employer() {
	
	}
	public Employer(String nameString, int age) {
		super();
		this.nameString = nameString;
		this.age = age;
	}
	public String getNameString() {
		return nameString;
	}
	public void setNameString(String nameString) {
		this.nameString = nameString;
	}
	public int getAge() {
		return this.age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "EmployeeName:\t"+this.nameString+"\nEmployeeAge:\t"+this.age;
		
	}
	
}

