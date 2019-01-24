package cn.zzw.server;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WebContext {
	private List<Entity> entities=null;
	private List<Mapping> mappings=null;
	
	//创建两个字典
	//key--->servlet-name  value-->servlet-class
	private Map<String,String> entityMap=new HashMap<String,String>();
	
	
	//key-->url-pattern value-->servlet-name
	private Map<String,String> mappingMap=new HashMap<String,String>();
	
	public WebContext() {
	
	}
	public WebContext(List<Entity> entities, List<Mapping> mappings) {
		this.entities = entities;
		for (Entity entity : entities) {
			entityMap.put(entity.getName(), entity.getClz());
		}
		this.mappings = mappings;
		for (Mapping mapping : mappings) {
			Set<String> patterns=mapping.getPatterns();
			for (String pattern : patterns) {
				mappingMap.put(pattern, mapping.getName());
			}
		}
	}
	
	public String getClz(String pattern) {
		return entityMap.get(mappingMap.get(pattern));
	}
	
	

}
