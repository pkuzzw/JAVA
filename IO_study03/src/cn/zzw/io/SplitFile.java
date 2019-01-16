package cn.zzw.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
/**
 * 面向对象思想-->封装
 * @author zzw
 *
 */
public class SplitFile {
	//源头
	private File src;
	//目的地(文件夹
	private String destDir;
	//所有分割后的文件存储路径
	private List<String> destPaths;
	//每块大小
	private int blockSize;
	//块数
	private int size;
   //构造器
	public SplitFile(String srcPath,String destDir,int blockSize) {
		this.src=new File(srcPath);
		this.destDir=destDir;
		this.blockSize=blockSize;
		this.destPaths=new ArrayList<String>();
		//初始化
		init();
	}
	private void init() {
		//总长度
		long len=this.src.length();
		this.size=(int)Math.ceil(len*1.0/this.blockSize);
		System.out.println("length=\t"+len);
		for (int i = 0; i < size; i++) {
			this.destPaths.add(this.destDir+"/"+i+"-"+this.src.getName());
		}
	}//init()
	/**
	 * 分割
	 * 1 计算每一块的起始位置及大小
	 * 2 分割
	 * @throws IOException 
	 */
	private void split() throws IOException {
		
	long len = src.length();
	int beginPos = 0;
	int actualSize = (int) (blockSize > len ? len : blockSize);
	for (int i = 0; i < size; i++) {
		beginPos = i * blockSize;
		if (i == size - 1) {
			// 最后一块 如果是最后一块就用剩下的
			actualSize = (int) len;
		} else {
			// 不是最后一块,用全部的blockSize
			actualSize = blockSize;
			len -= actualSize;
		}
		splitDetail(i, beginPos, actualSize);
	  }//for

    }//split
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
	
	private void splitDetail(int i,int beginPos,int actualSize) throws IOException {
		RandomAccessFile raf=new RandomAccessFile(this.src, "r");
		RandomAccessFile raf2=new RandomAccessFile(this.destPaths.get(i), "rw");
		//隨機讀取
		//讀取
		raf.seek(beginPos);
		//操作(分段读取)
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
	/**
	 * 
	 *合并文件
	 * @throws IOException 
	 */
	
	public void merge(String destPath) throws IOException {
		//输出流
		OutputStream os=new BufferedOutputStream(new FileOutputStream(destPath,true));
		Vector<InputStream> vi=new Vector<InputStream>();
		SequenceInputStream sis=null;
		//输入流
		for (int i = 0; i < destPaths.size(); i++) {
//			InputStream is= new BufferedInputStream(new FileInputStream(destPaths.get(i)));
			vi.add(new BufferedInputStream(new FileInputStream(destPaths.get(i))));
		}
		sis=new SequenceInputStream(vi.elements());
		
		//c操作
		byte[] flush=new byte[1024];
		int len=-1;
		while((len=sis.read(flush))!=-1) {
			os.write(flush,0,len);
		}
		os.flush();
		sis.close();
		os.close();
	}
	
	public static void main(String[] args) throws IOException {
		SplitFile sf= new SplitFile("baidu.html", "dest", 5);
		sf.split();
		sf.merge("aab.txt");
	}


}//class
