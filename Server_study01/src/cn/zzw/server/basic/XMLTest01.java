package cn.zzw.server.basic;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


/**
 * 熟悉SAX解析流程
 * @author zzw
 *
 */
public class XMLTest01 {
	
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		//SAX解析
		//1 获取解析工厂
		SAXParserFactory factory=SAXParserFactory.newInstance();
		//2 从解析工厂获取解析器
		SAXParser parser=factory.newSAXParser();
		//3 编写文档处理器
		
		
		//4 加载文档Document注册处理器
		PHandler handler=new PHandler(); 
		
		//5 解析
		parser.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("cn/zzw/server/basic/p.xml"), handler);
	}

}

//文档处理器
class PHandler extends DefaultHandler
{
	//解析文档开始
	@Override
	public void startDocument() throws SAXException {
		System.out.println("解析文档开始");
	}
	
	//解析文档结束
	@Override
	public void endDocument() throws SAXException {
		System.out.println("解析文档结束");
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

		System.out.println(" startElement qName:\t"+qName);
	}
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {

		String contents=new String(ch, start, length).trim();
		if (contents.length()>0) {
			System.out.println("内容为;\t"+contents);
		}else {
			System.out.println("内容为:\t空");
		}
		
	}
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		System.out.println("endElement qName:\t"+qName);
	}
	
	
	
}
