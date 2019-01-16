package cn.zzw.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;



/**
 * 添加输出流,将分割后的内容存入文件
 * 随机读取和写入流 RandomAccessFile
 * 
 * @author zzw
 *
 */

public class RandomTes02 {

	public static void main(String[] args) throws IOException {
		//分多少块
		File src=new File("baidu.html");
		//总长度
		long len=src.length();
		//每块大小
		int blockSize=1500;
		//多少块
		int size=(int)Math.ceil(len*1.0/blockSize);
		System.out.println("length=\t"+len);
		System.out.println("size=\t"+size);
		//起始位置
		int beginPos=0;
		int actualSize=(int)(blockSize>len? len:blockSize);
		for (int i = 0; i < size; i++) {
			beginPos=i*blockSize;
			if (i==size-1) {
				//最后一块 如果是最后一块就用剩下的
				actualSize=(int)len;
				
			} else {
				//不是最后一块,用全部的blockSize
				actualSize=blockSize;
				len-=actualSize;
			}
			System.out.println("Number: "+i+"\t"+beginPos+"-->"+actualSize);
			split(i, beginPos, actualSize);
			
		}

	}
	/**
	 * 指定起始位置以及实际长度
	 * 第i块的起始位置和长度
	 * @param i
	 * @param beginPos
	 * @param actualSize
	 * @throws IOException
	 */
	//分块思想 
	//起始
	//每块大小
	public static void split(int i,int beginPos,int actualSize) throws IOException {
		// TODO Auto-generated method stub
				RandomAccessFile raf=new RandomAccessFile(new File("baidu.html"), "r");
				RandomAccessFile raf2=new RandomAccessFile(new File("dest/"+i+".txt"), "rw");

				//起始位置
				//int beginPos=2;
				//实际大小
				//int actualSize=1026;
				
				raf.seek(beginPos);
				byte[] flush=new byte[1024];
				int len=-1;
				while((len=raf.read(flush))!=-1) {
					if (len < actualSize) {
						//本次读取的全部有效,还不够
						System.out.println(new String(flush,0,len));
						raf2.write(flush, 0, len);
						
						actualSize-=len;
					} else {
						System.out.println(new String(flush,0,actualSize));
						raf2.write(flush, 0, actualSize);
						break;
					}
				}
				raf2.close();
				raf.close();
	}


}//class
