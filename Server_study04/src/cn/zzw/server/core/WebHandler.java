package cn.zzw.server.core;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
/**
 * 处理器
 * @author zzw
 *
 */
//文档处理器
public class WebHandler extends DefaultHandler{
	
	private List<Entity> entities;
	private List<Mapping> mappings;
	private Entity entity;
	private Mapping mapping;
	private String tag;//存储操作标签
	private String tag1;
	//解析文档开始
	@Override
	public void startDocument() throws SAXException {
		entities=new ArrayList<Entity>();
		mappings=new ArrayList<Mapping>(); 
		System.out.println("解析文档开始");
	}
	
	//解析文档结束
	@Override
	public void endDocument() throws SAXException {
		System.out.println("解析文档结束");
	}
	
	

	public List<Entity> getEntities() {
		return entities;
	}

	public void setEntities(List<Entity> entities) {
		this.entities = entities;
	}

	public List<Mapping> getMappings() {
		return mappings;
	}

	public void setMappings(List<Mapping> mappings) {
		this.mappings = mappings;
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
//		System.out.println("startElement:\tqNname:\t"+qName);
		if (null!=qName) {
			if (qName.equals("servlet")) {//处理servlet
				//初始化servlet
//				System.out.println("initialize servlet");
				tag=qName;//存储标签名
				entity=new Entity();
			}else if (qName.equals("servlet-mapping")) {//处理servlet-mapping
				//初始化servlet-mapping
//				System.out.println("initialize servlet-mapping");
				tag=qName;//存储标签名
				mapping=new Mapping();
			}
			tag1=qName;
		}
	}
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String contents=new String(ch, start, length).trim();
//		System.out.println("start characters:\t tag:\t"+tag+"\ttag1:\t"+tag1+"\tcontents:\t"+contents);
		if (tag!=null) {
			if (tag.equals("servlet")) {//处理的内容属于servlet
				if (null!=tag1) {
					if (tag1.equals("servlet-name")) {
						if (contents.length()>0) {
							entity.setName(contents);
						}
					}else if (tag1.equals("servlet-class")) {
						if (contents.length()>0) {
							entity.setClz(contents);
						}
					}
				}
			}else if (tag.equals("servlet-mapping")) {//处理的是mapping
				if (null!=tag1) {
					if (tag1.equals("servlet-name")) {
						if (contents.length()>0) {
							mapping.setName(contents);
						}
					}else if (tag1.equals("url-pattern")) {
						mapping.addPattern(contents);				
					}else if (tag1.equals("servlet-pattern")) {
						mapping.addPattern(contents);
					}
				}
			}
		}
	}
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
//		System.out.println("endElement:\tqNname:\t"+qName);
		if (qName!=null) {
			if (qName.equals("servlet")) {//一个servlet数据已经添加完毕,准备重新读取下一个数据
				entities.add(entity);
				tag=null;
			}else if (qName.equals("servlet-mapping")) {//一个servlet-mapping数据解析完毕 准备重新读取下一个数据
				mappings.add(mapping);
				tag=null;
			}else if (qName.equals("servlet-name")|| qName.equals("servlet-class")|| qName.equals("url-pattern")||qName.equals("servlet-pattern")) {
				tag1=null;
			}
		}
	}
}
