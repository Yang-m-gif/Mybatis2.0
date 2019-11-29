package com.sui.Util;

import com.sui.mybatis.GeneratorSqlMap;

public class ServiceUtil {
	public static void fillServiceClass(String serverName){
		StringBuffer content = new StringBuffer("package ");

		content.append(getClssPack(serverName)).append(";\n");

		content.append("\n public interface ").append(getClssName(serverName));
		content.append(" {");
	
		content.append("\n}");
		try {
			FileManager.writeFile(content.toString(),getClassFile(serverName));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		fillServiceImplClass(serverName);
	}
	
	private static void fillServiceImplClass(String serverName){
		
		String servera=serverName;
		String serverName2=getClssName(serverName);
		String pageServerName=getClssName2(serverName);
		serverName=pageServerName+"impl."+serverName2+"Impl";
		
		StringBuffer content = new StringBuffer("package ");
		
		content.append(getClssPack(serverName)).append(";\n");
		
		content.append("import org.springframework.stereotype.Service;").append("\n");
		content.append("import "+servera).append(";\n").append("\n");
		
		content.append("@Service");
		content.append("\n public class  ").append(getClssName(serverName));
		content.append(" implements "+serverName2);
		content.append("  {");
	
		content.append("\n}");
		try {
			FileManager.writeFile(content.toString(),getClassFile(serverName));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static String getClassFile(String className){
		return getPrePath() + StrUtils.replace(className,".","/") + ".java";		
		//return filename;
	}
	private static String getPrePath(){
		String filename = "";
		//TODO
		filename=getPath().substring(0,
				getPath().length() - "/bin".length());
		filename = filename + "src/";
		filename = filename.replaceAll("\\%20", " ");
		return filename;		
	}
	
	public static String getPath(){
		String path= GeneratorSqlMap.class.getResource("/").getPath();
		return path;
	}
	private static String getClssPack(String className){
		return className.substring(0,className.lastIndexOf("."));
	}
	private static String getClssName(String className){
		return className.substring(className.lastIndexOf(".")+1,className.length());
	}
	private static String getClssName2(String className){
		return className.substring(0,className.lastIndexOf(".")+1);
	}
}
