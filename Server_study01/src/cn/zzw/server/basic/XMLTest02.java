package cn.zzw.server.basic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
public class XMLTest02 {
	
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		//SAX解析
		//1 获取解析工厂
		SAXParserFactory factory=SAXParserFactory.newInstance();
		//2 从解析工厂获取解析器
		SAXParser parser=factory.newSAXParser();
		//3 编写文档处理器
		
		
		//4 加载文档Document注册处理器
		PersonHandler handler=new PersonHandler(); 
		
		//5 解析
		parser.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("cn/zzw/server/basic/p.xml"), handler);
		
		
		//6 获取数据
		System.out.println("---------------查看获取的数据------------");
		List<Person> persons=handler.getPersons();
		for (Person person : persons) {
			System.out.println(person);
		}
	}

}

//文档处理器
class PersonHandler extends DefaultHandler{
	
	private List<Person> persons;
	private Person person;
	private String tag;//存储操作标签
	//解析文档开始
	@Override
	public void startDocument() throws SAXException {
		persons=new ArrayList<Person>();
		System.out.println("解析文档开始");
	}
	
	//解析文档结束
	@Override
	public void endDocument() throws SAXException {
		System.out.println("解析文档结束");
	}
	
	
	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

		if (null!=qName) {
			tag=qName;//存储标签名
			if (tag.equals("person")) {
				person=new Person();
			}
		}
	}
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String contents=new String(ch, start, length).trim();
		if (null!=tag) {//处理了空的问题
			if (tag.equals("name")) {
				if (contents.length()>0) {
					person.setName(contents);
				}
			} else if (tag.equals("age")) {
				
				if (contents.length()>0) {

					person.setAge(Integer.valueOf(contents));
				}
			}
		}//if
	}
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (qName!=null) {
			if (qName.equals("person")) {
				persons.add(person);
			}
			tag=null;			
		}
	}
}
