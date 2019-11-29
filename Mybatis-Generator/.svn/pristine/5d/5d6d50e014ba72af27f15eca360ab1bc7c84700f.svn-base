package com.sui.Util;

//import java.io.ByteArrayOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;


/**
 * Created on 2003-2-11
 * Version on version
 * Author Administrator
 * changed on 2003-2-11 15:00:06 
 */
public class FileManager {
	public static String basicPath = "";		//基本存储路径（知识库）
	public static String policyPath="";         //公司规章制度
	
	private static final String FORBIDDEN_FILE_EXTENSION = "|jsp|asp|php|html|htm|shtml|css|js|do|action|dll|ocx|bat|bin|exe";
	private static final String PICTURE_FILE_EXTENSION = "|jpg|jpeg|gif|bmp";
	
	/**
	 * 为系统基本文件路径赋值
	 */
	public static void setBasicPath(String path){
		basicPath = path;
	}
	/**
	 * Method createDir.
	 * @param path
	 * 建立一个目录
	 */
	public static void createDir(String path)  {
		try {			
					
			File file = new File(path);	
			String filename = file.getName();
			if(filename.indexOf(".")>0){
				file = new File(path.substring(0,path.length()-filename.length()));
			}
			if (!file.exists())
			{
				if(!file.mkdirs()){
					createDir(file.getParent()+File.separator);					
				}
			}				
			
		} catch (Exception e) {
			e.printStackTrace();
			//throw e;
		}
	}
	/**
	 * 是否是禁止上传的文件类型
	 * @param fileName
	 * @return
	 */
	public static boolean isForbidden(String fileName){
		try {
			String FileExtName = (fileName.lastIndexOf(".") < 0) ? fileName :
				fileName.substring(fileName.lastIndexOf(".")+1, fileName.length());
			if(FORBIDDEN_FILE_EXTENSION.indexOf(FileExtName.toLowerCase())<0){
				return false;
			}
			else{
				return true;
			}
		} catch (Exception e) {
			
			return true;
		}
	}
	/**
	 * 是否是图片文件
	 * @param fileName
	 * @return
	 */
	public static boolean isImage(String fileName){
		try {
			String FileExtName = (fileName.lastIndexOf(".") < 0) ? fileName :
				fileName.substring(fileName.lastIndexOf(".")+1, fileName.length());
			if(PICTURE_FILE_EXTENSION.indexOf(FileExtName.toLowerCase())<0){
				return false;
			}
			else{
				return true;
			}
		} catch (Exception e) {
			
			return false;
		}
	}
	
	/**
	 * 写入到文件
	 * 
	 * @param body
	 * @param fileName
	 *           path+filename
	 * @throws IOException
	 */
	public static void writeFile(String body, String fileName) throws IOException {
		FileWriter writer = null;
		try {
			FileManager.createDir(fileName);
			writer = new FileWriter(fileName);
			writer.write(body);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			writer.close();
		}
	}

	/**
	 * 读文件
	 * 
	 * @param fileName
	 * @return
	 * @throws IOException
	 */
	public static String readFile(String fileName) throws IOException {
		StringBuffer body = new StringBuffer();
		FileReader in = new FileReader(fileName);
		BufferedReader br = new BufferedReader(in);
		String line = br.readLine();
		body.append(line);
		while (line != null) {
			line = br.readLine();
			body.append(line);
		}
		br.close();
		in.close();	
		return body.toString();
	}

	/**
	 * 载入属性文件
	 * @param file
	 */
	public static Properties loadProperties(String file) {
		Properties props = new Properties();
		try {
			InputStream in = FileManager.class.getClassLoader().getResourceAsStream(file);
			props.load(in);
		} catch (FileNotFoundException e) {
			System.err.println("配置文件" + file + "不存在!");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("读取配置文件时发生错误!");
			e.printStackTrace();
		}
		return props;
	}
	
	/**
	 * 
	 * @param fileName
	 * @return
	 */
	public static boolean deleteFile(String fileName) {
		File file = new File(fileName);
		if (file.isFile() && file.exists()) {
			file.delete();
			return true;
		} else {
			return false;
		}
	}    

}
