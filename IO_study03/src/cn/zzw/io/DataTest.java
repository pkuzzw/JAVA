package cn.zzw.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
/**
 * 测试DataInputStream DataOutputStream
 * 1 写出后读取
 * 2 读取的顺序与写出的顺序一致
 * DataInputStream
 * DataOutputStream
 * 
 * @author zzw
 *
 */
public class DataTest {

	public static void main(String[] args) throws IOException {
		//先写出
		ByteArrayOutputStream baos= new ByteArrayOutputStream();
		DataOutputStream dos=new DataOutputStream(new BufferedOutputStream(baos));
		//操作数据类型+数据
		dos.writeUTF("编码辛酸泪");
		dos.writeChar('c');
		dos.writeInt(5);
		dos.writeBoolean(true);
		dos.flush();
		byte[] datas= baos.toByteArray();
		//再读取
		DataInputStream dis=new DataInputStream(new BufferedInputStream(new ByteArrayInputStream(datas)));
		String str=dis.readUTF();
		char c=dis.readChar();
		int i=dis.readInt();
		boolean b=dis.readBoolean();
		System.out.println("str:\t"+str);
		System.out.println("char:\t"+c);
		System.out.println("int:\t"+i);
		System.out.println("boolean:\t"+b);
	}
}
