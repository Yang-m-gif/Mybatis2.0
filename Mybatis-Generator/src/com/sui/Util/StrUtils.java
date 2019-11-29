package com.sui.Util;

import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串处理常用方法类
 * @author alan
 *
 */
public class StrUtils {

  /**
 * 分割字符串
 * @param line  字符串
 * @param seperator 分隔字符串
 */
  @SuppressWarnings("unchecked")
public static String[] split(String line, String seperator) {
  if (line == null) {
  return null;
  }
  line = line.trim();
  if (line.length() == 0) {
  return null;
  }
  java.util.Vector v = new java.util.Vector();
  int i = 0, j;
  while ( (j = line.indexOf(seperator, i)) >= 0) {
  v.addElement(line.substring(i, j).trim());
  i = j + seperator.length();
  }
  v.addElement(line.substring(i).trim());
  int size = v.size();
  String[] ps = new String[size];
  if (size > 0) {
  v.copyInto(ps);
  }
  return ps;
  }
  
  /**
 * 合并一个数组.输出一个串
 * 
 * @return
 */
  public static String merge(String[] arr){
	  String result="";
	  for (String s:arr) 
		  result+=s+",";
	  if(result.length()>0)
		  result = result.substring(0, result.length()-1);
	  return result;
  }
  
  public static String padEmpty(String value, int length){
	  return padMark(value,length,"&nbsp;");
  }
  public static String padMark(String value, int length,String mark){
	  if (value.length()>=length ){
		  return value;
	  }
	  int halflen = (length - value.length())/2;
	  StringBuffer sb = new StringBuffer();
	  for (int i=0 ;i < halflen;i++){
		  sb.append(mark);
	  }
	  return sb.toString()+ value + sb.toString(); 
  }
  
  public static String nullToEmpty(String value){
	  if (value == null){
		  return "";
	  } else {
		  return value;
	  }
  } 
  
  public static String leftPadMark(String value, int length,String mark){
	  if (value.length()>=length ){
		  return value;
	  }
	  int halflen = (length - value.length())/2;
	  StringBuffer sb = new StringBuffer();
	  for (int i=0 ;i < halflen;i++){
		  sb.append(mark);
	  }
	  return sb.toString()+ value ; 
  }
  public static String rightPadMark(String value, int length,String mark){
	  if (value.length()>=length ){
		  return value;
	  }
	  int halflen = (length - value.length())/2;
	  StringBuffer sb = new StringBuffer();
	  for (int i=0 ;i < halflen;i++){
		  sb.append(mark);
	  }
	  return value + sb.toString() ; 
  }
  /**
 *  判断字符串是否为 null 或为空字符串
 */
  public static final boolean isEmpty(String s) {
  return (s == null || s.trim().length() == 0);
  }

  /**
 * 判断两字符串是否严格相等（包括字符串为 null 为空字符串的情况）
 */
  public static boolean equals(String s1, String s2) {
  if (isEmpty(s1)) {
  return isEmpty(s2);
  }
  return s1.equals(s2);

  }

  /**
 * 判断两字符串是否相等（不区分大小写），包括字符串为 null 为空字符串的情况
 */
  public static boolean equalsIgnoreCase(String s1, String s2) {
  if (isEmpty(s1)) {
  return isEmpty(s2);
  }
  return s1.equalsIgnoreCase(s2);
  }

  /**
 * 格式化 sm 为 “￥123,456.00”格式
 */
  public static String formatCurrency(double sm) {
  return NumberFormat.getCurrencyInstance().format(sm);
  }

  /**
 * 格式化double值为“123456.00”
 * @param int - 指定格式化的小数位数
 */
  public static String formatNumber(double value, int digit) {
  String pattern = "###0";
  if (digit > 0) {
  pattern += ".";
  for (int i = 0; i < digit; i++) {
    pattern += "0";
  }
  }
  return new DecimalFormat(pattern).format(value);
  }
  /**
   * 格式化double值为“123,456.00”
   * @param int - 指定格式化的小数位数
   */
    public static String formatMoney(double value) {
    String pattern = "#,##0.00";
    
    return new DecimalFormat(pattern).format(value);
    }
  //替换字符串
  public static String replace(String str, String oldChars, String newChars) {
  int len;
  int pos;
  int lastPos;

  len = newChars.length();
  pos = str.indexOf(oldChars);
  lastPos = pos;

  while (pos > -1) {
  String firstPart;
  String lastPart;

  firstPart = str.substring(0, pos);
  lastPart = str.substring(pos + oldChars.length(), str.length());
  str = firstPart + newChars + lastPart;
  lastPos = pos + len;
  pos = str.indexOf(oldChars, lastPos);
  }

  return (str);
  }

  private static final char[] HEX_DIGITS = {
  '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E',
  'F'
  };

  public static byte[] hexFromString(String hex) {
  int len = hex.length();
  //System.out.println("hex" + hex);
  //System.out.println(len);
  byte[] buf = new byte[ ( (len + 1) / 2)];

  int i = 0, j = 0;
  if ( (len % 2) == 1) {
  buf[j++] = (byte) fromDigit(hex.charAt(i++));

  }
  while (i < len) {
  buf[j++] = (byte) ( (fromDigit(hex.charAt(i++)) << 4) |
         fromDigit(hex.charAt(i++)));
  }
  return buf;
  }

  public static int fromDigit(char ch) {
  if (ch >= '0' && ch <= '9') {
  return ch - '0';
  }
  if (ch >= 'A' && ch <= 'F') {
  return ch - 'A' + 10;
  }
  if (ch >= 'a' && ch <= 'f') {
  return ch - 'a' + 10;
  }

  throw new IllegalArgumentException("invalid hex digit '" + ch + "'");
  }

  public static String byteArrayToString(byte[] ba) {
  int length = ba.length;
  char[] buf = new char[length * 2];
  for (int i = 0, j = 0, k; i < length; ) {
  k = ba[i++];
  buf[j++] = HEX_DIGITS[ (k >>> 4) & 0x0F];
  buf[j++] = HEX_DIGITS[k & 0x0F];
  }
  return new String(buf);
  }

  public static String modelToString(String str) {
  String temp = "";
  if (str == null || str.trim().length() == 0) {
  temp = "";
  }
  else {
  temp = str;
  }
  return temp;

  }

  public static String formatCode(int n, char ch, int len) {
  StringBuffer sbf = new StringBuffer(len + 1);
  String strn = "" + n;
  int loop = 0;
  for (loop = len; loop > strn.length(); loop--) {
  sbf.append(ch);
  }
  sbf.append(strn);
  return sbf.toString();
  }

  public static String checkError(String oracleErr) {
  int i = oracleErr.indexOf(":") + 1;
  return oracleErr.substring(i, oracleErr.length());
  }

 	/**
 	 * 把一个串多余的部分去掉,不然页面显示不了
 	 * 支持中文过滤
 	 * formatChar('abcdefghijklmn',8)--'abcdefgh..'
 	 * formatChar('我是谁谁',6)---'我是谁..'
 	 * @param src
 	 * @param size
 	 */
 	public static String formatChar(String src,int size){
 		if(isEmpty(src)) return "";
 		src = clearHTML(src,size);//去除html标签
 		if(size <=0) return src;
 		if(size % 2 >0) size = size-1;
 		if(src==null||src.length()<size/2)
 			return src;
 		int length = size;
 		for(int i=0;i<size&&i<length&&i<src.length();i++)
 			if(src.charAt(i)>255)
 				length--;
 		length = length>src.length()?src.length():length;
 		String value = src.substring(0, length);
 		if(value.length()<src.length())
 			value+="..";
 		value = value.replace("?"," ");
 		return value;
 	}
 	/**
 	 * 去除html标签，直到前size的字符都不含有html标签
 	 * @param src
 	 * @param size
 	 * @return
 	 */
 	public static String clearHTML(String src,int size){
 		String result = src;
 		try {
 			if(size <=0) size = src.length();
 			
 	 		String temp;
 	 		int pos1,pos2;
 	 		result = result.replace("&nbsp;","");
 	 		result = result.replace("<br>","");
 	 		result = result.replace("<P>","");
 	 		if(size>=result.length()) size = result.length();
 	 		while(result.substring(0,size-1).indexOf("<")>=0){
 	 			pos1 = result.indexOf("<"); 	 			
 	 			pos2 = result.indexOf(">");
 	 			if(pos2<pos1) break;
 	 			if(result.substring(0,pos1).length()>=size) break;
 	 			temp = result.substring(pos1,pos2+1); 	 			
 	 			result = result.replace(temp,"");
 	 			//System.out.println(temp);
 	 			//System.out.println(result);
 	 			if(size>=result.length()) size = result.length();
 	 		}
 	 		return result;
		} catch (StringIndexOutOfBoundsException e) {
			System.out.println("clearHTML:" + e.toString());
			return result;
			
		}
 		
 	}
 	
 	/**
 	 * 
 	 * @param src
 	 * @return
 	 */
 	public static String defaultValue(String src){
 		if(isEmpty(src))
 			return "";
 		return src;
 	}
 	public static String defaultValue(String src,String defValue){
 		if(isEmpty(src))
 			return defValue;
 		return src;
 	}
 	
 	/**
 	 * 转换编码
 	 * @param src
 	 * @return
 	 */
 	public static String enodeGBK(String src){
 		try {
			return new String(src.getBytes("8859_1"),"GBK");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return src;
 	}
 	/**
 	 * 过滤输入的html标签
 	 * @param src
 	 * @return
 	 */
 	public static String hideHTML(String src){
 		if(StrUtils.isEmpty(src)) return src;
 		String result = src;
 		result = result.replaceAll("<","[");
 		result = result.replaceAll(">","]");
 		result = result.replaceAll("\"","“"); //中文引号 		
 		result = result.replaceAll("'","‘"); //中文引号 	
 		return result;
 	}
 	/**
 	 * 显示限定的一些html
 	 * @param src
 	 * @return
 	 */
 	public static String showLimitHtml(String src){
 		String result = src;//hideHTML(src);
 		if(StrUtils.isEmpty(result)) return result; 		
 		result = result.replaceAll("\n","<br>"); //回车换行
 		return result;
 	}
 	
 	public static String changeToBig(double value){
 		char[] hunit={'拾','佰','仟'};//段内位置表示
 		char[] vunit={'万','亿','兆','京','垓'};//段名表示
 		char[] digit={'零','壹','贰','叁','肆','伍','陆','柒','捌','玖'};//数字表示
 		String minus = "";
 		if(value <0) {
 			minus = "负";
 			value = 0 - value;
 		}
 		long midVal = Math.round(value*100);	//转化成整形;COHY:长整形，否则会出现浮点数问题
 		if(midVal==0) return "零圆整";
 		String valStr=String.valueOf(midVal);//转化成字符串
 		
 		String head=""; //取整数部分
 		String rail=""; //取小数部分
 		if (valStr.length()>2){  //含有整数部分
 		   head=valStr.substring(0,valStr.length()-2);
 		   rail=valStr.substring(valStr.length()-2);
 		}else{ 			//不含整数部分
 		   head="";
 		   rail=valStr;
 		}
 		String prefix="";//整数部分转化的结果
 		String suffix="";//小数部分转化的结果
 		//处理小数点后面的数
 		if(rail.equals("00")){//如果小数部分为0
 			suffix="整";
 		} else{
 		    if (rail.length()>1)
 			   suffix=digit[rail.charAt(0)-'0']+"角"+digit[rail.charAt(1)-'0']+"分";//否则把角分转化出来
 			else 
 				suffix=digit[rail.charAt(0)-'0']+"分";//否则把角分转化出来
 		}
 		//处理小数点前面的数
 		char[] chDig=head.toCharArray();//把整数部分转化成字符数组
 		char zero='0';//标志'0'表示出现过0
 		byte zeroSerNum = 0;//连续出现0的次数
 		for(int i=0;i<chDig.length;i++){//循环处理每个数字
 			int idx=(chDig.length-i-1)%4;//取段内位置
 			int vidx=(chDig.length-i-1)/4;//取段位置
 			if(chDig[i]=='0'){//如果当前字符是0
 				zeroSerNum++;//连续0次数递增
 				if(zero == '0'){//标志
 					zero=digit[0];
 				} 
 				//COHY: 无论是否此位数是0，都需要判断4位一次的段名
 				if(idx==0 && vidx >0 &&zeroSerNum < 4){
 					prefix += vunit[vidx-1];
 					zero='0';
 				}
 				continue;
 			}
 			zeroSerNum = 0;//连续0次数清零
 			if(zero != '0'){//如果标志不为0,则加上,例如万,亿什么的
 				prefix+=zero;
 				zero='0';
 			}
 			prefix+=digit[chDig[i]-'0'];//转化该数字表示
 			if(idx > 0) prefix += hunit[idx-1];
 			if(idx==0 && vidx>0){
 				prefix+=vunit[vidx-1];//段结束位置应该加上段名如万,亿 
 			}
 		}

 		if(prefix.length() > 0) prefix += '圆';//如果整数部分存在,则有圆的字样  
 		return minus+prefix+suffix;//返回正确表示  
 	}
 	/**
 	 * 零转换成空
 	 * @param value
 	 * @return
 	 */
 	public static String zeroToEmpty(double value){
 		if(value == 0 || Double.isNaN(value)) return "";
 		return formatMoney(value);
 	}
 	/**
 	 * 零转换成空
 	 * @param value
 	 * @return
 	 */
 	public static String zeroToEmpty(double value,String defValue){
 		return defaultValue(zeroToEmpty(value), defValue);
 		
 	}
 	/**
 	 * 找到字符串中第一个有效的数字字符串，如果没有找到，返回null
 	 * @param source
 	 * @return
 	 */
 	public static String getValidDecimal(String source){
 		Pattern pattern = Pattern.compile("[\\d]+(\\.\\d+)?");
		Matcher matcher = pattern.matcher(source);
		if(matcher.find()){
			return source.substring(matcher.start(),matcher.end());
		}else{//没有数字
			return null;
		}
		
 	}
 	
 	/**
 	 * 得到like 的查询条件值
 	 * @param value
 	 * @return
 	 */
 	public static String getLikeValue(String value){
 		if(isEmpty(value)) return "";
 		return "%" + value + "%";
 	}
 	/**
 	 * 根据传入的整数，转换成A-Z,AA-ZZ这样的字符。最大处理A-ZZZ，即1-26*26*26(17576)
 	 * @param value
 	 * @return
 	 */
 	public static String getAZByInt(int value){ 		
 		if(value <=0 || value > 17576) return "-";
 		String result = "";
 		while(value>0){
 			int mod = value % 26;	//26个字母
 			char c = 'Z';			//默认是没有余数,如果存在余数,会重新计算
 			if(mod >0 ){
 				c = (char)(mod+64);	//A对应char的65
 			}
 			result = String.valueOf(c) + result;
 			value = (int)Math.floor((value-1) / 26);	//排除26本身
 		}
 		return result;
 	}
 	

	/**
	 * 格式化日期/时间,格式自己传进来,有默认格式
	 * 
	 * @param date
	 * @param style
	 * @return
	 */
	public static String formatDate(Date date, String style) {
		if (StrUtils.isEmpty(style))
			style = "yyyy-MM-dd";
		if (date == null) return "";
		if(date.getTime()<86400000) return ""; //比1900-01-01大于不超过1天
		SimpleDateFormat sdf = new SimpleDateFormat(style);
		return sdf.format(date);
	}
 	
	/**
	 * 判断字符串是否为数字字符串
	 * @param str
	 * @return
	 */
	public static boolean isNumeric(String str){
		Pattern pattern = Pattern.compile("[-|+]?[0-9]*(\\.)?[0-9]*");
		Matcher isNum = pattern.matcher(str);
		if( !isNum.matches() ){
			return false;
		}
		return true;
	} 
	
	/**
	 * 生成随机颜色
	 * @return String
	 */
	public static String generateRandomColor(){
		char[] a = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
		String result = "";
		for(int i=0;i<6;i++){
			int j = new Random().nextInt(16);
			result += a[j];
		}
		return result;
	}
//end class
}
