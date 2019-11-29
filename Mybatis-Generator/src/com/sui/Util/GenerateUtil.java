package com.sui.Util;

import com.sui.mybatis.ConnectionDataSql;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GenerateUtil {

    private static ResourceBundle parameter = ResourceBundle.getBundle("mybatis");
    private static String pourl = parameter .getString("project.po");
    private static String mapperurl = parameter .getString("project.mapper");
    private static String mymapperurl =parameter .getString("project.mymapper");
    private static String serviceurl =parameter .getString("project.service");
    private static String tablename= lineToHump(parameter .getString("project.table")); //表名驼峰命名

    private static String names= names(parameter .getString("project.table"));
    private static String tablenames= parameter .getString("project.table"); // 表名
    //日期格式
    public static final String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    private static List<Info> infoList = ConnectionDataSql.getInfoList();



    public static void main(String[] args) throws IOException {
        pojogenerate();
        pojoCustomgenerate();
        mymappergenerate();
        mappergenerate();
        mapperxmlgenerate();
        servicegenerate();
        serviceImplgenerate();
        System.out.println("生成完毕");
    }




    //生成pojo.java
    public static void pojogenerate(){
        StringBuffer buffer = new StringBuffer("package "+pourl+";").append("\n").append("\n");

        buffer.append("import lombok.Data;").append("\n");
        buffer.append("import java.util.Date;").append("\n");
        buffer.append("import javax.persistence.Id;").append("\n");
        buffer.append("import javax.persistence.GeneratedValue;").append("\n");
        buffer.append("import org.springframework.format.annotation.DateTimeFormat;").append("\n");
        buffer.append("import com.fasterxml.jackson.annotation.JsonFormat;").append("\n").append("\n");
        buffer.append("@Data").append("\n");
        buffer.append("public class "+tablename+"{").append("\n");

        for(Info info : infoList){
            if(infoList.get(0).getColumn() == info.getColumn()){
                buffer.append("    @Id").append("\n");//主键
                buffer.append("    @GeneratedValue(generator = \"JDBC\")").append("\n");
            }else{
                buffer.append("    /* "+info.getNotes()+" */").append("\n");//注释
            }
            if(info.getColumntype()=="Date"){
                buffer.append("    @DateTimeFormat(pattern = \"yyyy-MM-dd HH:mm:ss\")").append("\n"); // 前台返回后台时间格式
                buffer.append("    @JsonFormat(pattern = \"yyyy-MM-dd HH:mm:ss\",timezone = \"GMT+8\")").append("\n"); // 后台返回前台时间格式
            }
            buffer.append("    private "+info.getColumntype()+" "+info.getColumn().toLowerCase()+";").append("\n").append("\n");//字段
        }
        buffer.append("}");

        try {
            FileManager.writeFile(buffer.toString(),getClassFile(pourl+"."+tablename));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("pojo.java创建失败");
        }
    }

    //生成pojoCustom.java
    public static void pojoCustomgenerate(){
        StringBuffer buffer = new StringBuffer("package "+pourl+";").append("\n").append("\n");
        buffer.append("import lombok.Data;").append("\n").append("\n");
        buffer.append("/**").append("\n");
        buffer.append(" * "+tablename+"表的扩展类").append("\n");
        buffer.append(" * create by 杨明 "+new SimpleDateFormat(DATE_TIME_PATTERN).format(new Date())).append("\n");
        buffer.append(" */").append("\n");
        buffer.append("@Data").append("\n");
        buffer.append("public class "+tablename+"Extend extends "+tablename+"{").append("\n");
        buffer.append("}");

        try {
            FileManager.writeFile(buffer.toString(),getClassFile(pourl+"."+tablename+"Extend"));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("pojoCustom.java创建失败");
        }
    }

    //生成mymapper.java
    public static void mymappergenerate(){

        StringBuffer buffer = new StringBuffer("package "+mymapperurl+";").append("\n").append("\n");
        buffer.append("import tk.mybatis.mapper.common.Mapper;").append("\n");
        buffer.append("import tk.mybatis.mapper.common.MySqlMapper;").append("\n");
        buffer.append("public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {").append("\n");
        buffer.append("}");

        try {
            FileManager.writeFile(buffer.toString(),getClassFile(mymapperurl+".MyMapper"));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("mymapper.java创建失败");
        }

    }

    //生成mapper.java
    public static void mappergenerate(){

        StringBuffer buffer = new StringBuffer("package "+mapperurl+";").append("\n").append("\n");
        buffer.append("import "+pourl+"."+tablename+";").append("\n");
        buffer.append("import "+mymapperurl+".MyMapper;").append("\n");
        buffer.append("import org.apache.ibatis.annotations.Param;").append("\n");
        buffer.append("import org.springframework.stereotype.Component;").append("\n").append("\n");
        buffer.append("import java.util.List;").append("\n").append("\n");
        buffer.append("@Component").append("\n");
        buffer.append("public interface "+tablename+"Mapper extends MyMapper<"+tablename+"> {").append("\n").append("\n");

        // 生成常用的方法
        buffer.append("    /**").append("\n");
        buffer.append("     * 添加"+tablename+"信息").append("\n");
        buffer.append("     * create by 杨明 "+new SimpleDateFormat(DATE_TIME_PATTERN).format(new Date())).append("\n");
        buffer.append("     */").append("\n");
        buffer.append("    public int insert"+tablename+"Info("+tablename+" "+names+");").append("\n").append("\n");
        // 获取对象
        String cond = "";
        for(Info info : infoList){
            if(infoList.get(0).getColumn() == info.getColumn()){
                cond = info.getColumn().toLowerCase();
            }
        }
        buffer.append("    /**").append("\n");
        buffer.append("     * 根据主键删除"+tablename+"信息").append("\n");
        buffer.append("     * create by 杨明 "+new SimpleDateFormat(DATE_TIME_PATTERN).format(new Date())).append("\n");
        buffer.append("     */").append("\n");
        buffer.append("    public int delete"+tablename+"ByPrimaryKey(@Param(\""+cond+"\") Integer "+cond+");").append("\n").append("\n");

        buffer.append("    /**").append("\n");
        buffer.append("     * 修改"+tablename+"信息").append("\n");
        buffer.append("     * create by 杨明 "+new SimpleDateFormat(DATE_TIME_PATTERN).format(new Date())).append("\n");
        buffer.append("     */").append("\n");
        buffer.append("    public int update"+tablename+"ByPrimaryKey("+tablename+" "+names+");").append("\n").append("\n");

        buffer.append("    /**").append("\n");
        buffer.append("     * 获取所有的或者条件获取"+tablename+"信息").append("\n");
        buffer.append("     * create by 杨明 "+new SimpleDateFormat(DATE_TIME_PATTERN).format(new Date())).append("\n");
        buffer.append("     */").append("\n");
        buffer.append("    public List<"+tablename+"> select"+tablename+"ByPrimary("+tablename+" "+names+");").append("\n").append("\n");

//        buffer.append("    /**").append("\n");
//        buffer.append("     * 批量添加"+tablename+"信息").append("\n");
//        buffer.append("     * create by 杨明 "+new SimpleDateFormat(DATE_TIME_PATTERN).format(new Date())).append("\n");
//        buffer.append("     */").append("\n");
//        buffer.append("    public int insert"+tablename+"Batch(List<"+tablename+"> list);").append("\n").append("\n");

        buffer.append("    /**").append("\n");
        buffer.append("     * 批量删除"+tablename+"信息").append("\n");
        buffer.append("     * create by 杨明 "+new SimpleDateFormat(DATE_TIME_PATTERN).format(new Date())).append("\n");
        buffer.append("     */").append("\n");
        buffer.append("    public int delete"+tablename+"BatchByFids(@Param(\"fids\") List<Integer> fids);").append("\n").append("\n");

        buffer.append("    /**").append("\n");
        buffer.append("     * 批量修改"+tablename+"信息").append("\n");
        buffer.append("     * create by 杨明 "+new SimpleDateFormat(DATE_TIME_PATTERN).format(new Date())).append("\n");
        buffer.append("     */").append("\n");
        buffer.append("    public int update"+tablename+"Batch(List<"+tablename+"> list);").append("\n").append("\n");

        buffer.append("    /**").append("\n");
        buffer.append("     * 批量修改"+tablename+"信息").append("\n");
        buffer.append("     * create by 杨明 "+new SimpleDateFormat(DATE_TIME_PATTERN).format(new Date())).append("\n");
        buffer.append("     */").append("\n");
        buffer.append("    public int update"+tablename+"BatchByPrimaryKey(List<"+tablename+"> list);").append("\n").append("\n");

//        buffer.append("    /**").append("\n");
//        buffer.append("     * 批量list查询"+tablename+"信息").append("\n");
//        buffer.append("     * create by 杨明 "+new SimpleDateFormat(DATE_TIME_PATTERN).format(new Date())).append("\n");
//        buffer.append("     */").append("\n");
//        buffer.append("    public int select"+tablename+"BatchList(List<"+tablename+"> list);").append("\n").append("\n");
//        buffer.append("    /**").append("\n");
//        buffer.append("     * 批量arr查询"+tablename+"信息").append("\n");
//        buffer.append("     * create by 杨明 "+new SimpleDateFormat(DATE_TIME_PATTERN).format(new Date())).append("\n");
//        buffer.append("     */").append("\n");
//        buffer.append("    public int select"+tablename+"BatchArr(List<"+tablename+"> list);").append("\n").append("\n");

        buffer.append("}");

        try {
            FileManager.writeFile(buffer.toString(),getClassFile(mapperurl+"."+tablename+"Mapper"));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("mapper.java创建失败");
        }

    }

    //生成mapper.xml
    public static void mapperxmlgenerate(){
        StringBuffer buffer = new StringBuffer("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>").append("\n");
        buffer.append("<!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\" \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\" >").append("\n");
        buffer.append("<mapper namespace=\""+mapperurl+"."+tablename+"Mapper\">").append("\n").append("\n");
        // 常用map
        buffer.append("    <resultMap id=\"BaseResultMap\" type=\""+pourl+"."+tablename+"\" >").append("\n");
        for(Info info : infoList){
            if(infoList.get(0).getColumn() == info.getColumn()){
                buffer.append("        <id column=\""+info.getColumn()+"\" property=\""+info.getColumn()+"\" />").append("\n");//主键
            }else{
                buffer.append("        <result column=\""+info.getColumn().toLowerCase()+"\" property=\""+info.getColumn().toLowerCase()+"\" />").append("\n");
            }
        }
        buffer.append("    </resultMap>").append("\n").append("\n");



        // 扩展map
        buffer.append("    <resultMap id=\"BaseResultExtendMap\" type=\""+pourl+"."+tablename+"Extend"+"\" extends=\"BaseResultMap\" >").append("\n");
        buffer.append("    </resultMap>").append("\n").append("\n");
        // 字段sql片段 1
        buffer.append("    <sql id=\"Base_Column_List\">").append("\n");
        buffer.append("        ");
        for(Info info : infoList){
            buffer.append(""+info.getColumn().toLowerCase()+",");
        }
        buffer.append("\n");
        buffer.append("    </sql>").append("\n").append("\n");
        // 条件SQL片段 2
        buffer.append("    <sql id=\"Base_Where_List\">").append("\n");
        buffer.append("        <where>").append("\n");
        for(Info info : infoList){
            buffer.append("            <if test=\""+info.getColumn().toLowerCase()+" != null and "+info.getColumn().toLowerCase()+" !=''\" >" +info.getColumn().toLowerCase()+",</if>").append("\n");
        }
        buffer.append("        </where>").append("\n");
        buffer.append("    </sql>").append("\n").append("\n");

        String condition = "";
        String condit = "";
        for(Info info : infoList){
            if(infoList.get(0).getColumn() == info.getColumn()){
                condition = "WHERE " + info.getColumn().toLowerCase() + " = #{" + info.getColumn().toLowerCase() + "}";
                condit = "" + info.getColumn().toLowerCase() + "";
            }
        }
        // 添加
        buffer.append("    <!--添加操作-->").append("\n");
        buffer.append("    <insert id=\"insert"+tablename+"Info\">").append("\n");
        buffer.append("         INSERT INTO "+tablenames+"").append("\n");
        buffer.append("         <trim prefix=\"(\" suffix=\")\" suffixOverrides=\",\">").append("\n");
        for(Info info : infoList){
            buffer.append("             <if test=\""+info.getColumn().toLowerCase()+" != null\" >"+info.getColumn().toLowerCase()+",</if>").append("\n");
        }
        buffer.append("          </trim>").append("\n");
        buffer.append("          <trim prefix=\"SELECT \" suffix=\" \" suffixOverrides=\",\">").append("\n");
        for(Info info : infoList){
            buffer.append("             <if test=\""+info.getColumn().toLowerCase()+" != null\" >#{"+info.getColumn().toLowerCase()+"},</if>").append("\n");
        }
        buffer.append("          </trim>").append("\n");
        buffer.append("          FROM DUAL WHERE NOT EXISTS").append("\n");
        buffer.append("          (SELECT `name` FROM "+tablename+"").append("\n");
        buffer.append("           WHERE slk_area_fid = #{slk_area_fid}").append("\n");
        buffer.append("           AND `name` = #{name} )").append("\n");
        buffer.append("    </insert>").append("\n").append("\n");
        //删除

        buffer.append("    <!--删除操作-->").append("\n");
        buffer.append("    <delete id=\"delete"+tablename+"ByPrimaryKey\">").append("\n");
        buffer.append("         DELETE FROM "+tablenames+" "+condition+"").append("\n");
        buffer.append("    </delete>").append("\n").append("\n");
        // 修改
        buffer.append("    <!--修改操作-->").append("\n");
        buffer.append("    <update id=\"update"+tablename+"ByPrimaryKey\">").append("\n");
        buffer.append("         UPDATE "+tablenames+"").append("\n");
        buffer.append("         <trim prefix=\"SET\" suffix=\""+condition+"\" suffixOverrides=\",\">").append("\n");
        for(Info info : infoList){
            buffer.append("             <if test=\""+info.getColumn().toLowerCase()+" != null\" >"+info.getColumn().toLowerCase()+"=#{"+info.getColumn().toLowerCase()+"},</if>").append("\n");
        }
        buffer.append("          </trim>").append("\n");
        buffer.append("          WHERE fid = #{fid} AND ( SELECT a.`name` FROM ( SELECT p.* FROM "+tablename+" p  WHERE").append("\n");
        buffer.append("           p.slk_area_fid = #{slk_area_fid}  AND p.`name` = #{name} AND p.fid != #{fid}) AS a").append("\n");
        buffer.append("           ) is null").append("\n");
        buffer.append("    </update>").append("\n").append("\n");
        // 查询
        buffer.append("    <!--查询操作-->").append("\n");
        buffer.append("    <select id=\"select"+tablename+"ByPrimary\" parameterType=\""+pourl+"."+tablename+"\" resultMap=\"BaseResultExtendMap\" >").append("\n");
        buffer.append("         SELECT").append("\n");
        buffer.append("             <include refid=\"Base_Column_List\" />").append("\n");
        buffer.append("         FROM "+tablenames+"").append("\n");
        buffer.append("         <include refid=\"Base_Where_List\" />").append("\n");
        buffer.append("    </select>").append("\n").append("\n");
        // 批量添加
        buffer.append("    <!--批量添加操作-->").append("\n");
        buffer.append("    <insert id=\"insert"+tablename+"Batch\">").append("\n");
        buffer.append("        INSERT INTO "+tablenames+" (<include refid=\"Base_Column_List\" />)").append("\n");
        buffer.append("        VALUES").append("\n");
        buffer.append("        <foreach collection=\"list\" item=\"item\" separator=\",\">").append("\n");
        buffer.append("            (").append("\n");
        for(Info info : infoList){
            buffer.append("            #{"+info.getColumn().toLowerCase()+"}").append("\n");
        }
        buffer.append("            )").append("\n");
        buffer.append("        </foreach>").append("\n");
        buffer.append("    </insert>").append("\n").append("\n");
        // 批量删除
        buffer.append("    <!--批量删除操作-->").append("\n");
        buffer.append("    <delete id=\"delete"+tablename+"BatchByFids\">").append("\n");
        buffer.append("        DELETE  FROM "+tablenames+"").append("\n");
        buffer.append("        WHERE "+condit+" IN").append("\n");
        buffer.append("        <foreach collection=\"list\" item=\"item\" separator=\",\" open=\"(\" close=\")\" >").append("\n");
        buffer.append("            #{item}").append("\n");
        buffer.append("        </foreach>").append("\n");
        buffer.append("    </delete>").append("\n").append("\n");
        // 批量修改
        buffer.append("    <!--批量修改操作-->").append("\n");
        buffer.append("    <update id=\"update"+tablename+"Batch\">").append("\n");
        buffer.append("        UPDATE "+tablenames+"").append("\n");
        buffer.append("         <trim prefix=\"SET\" suffixOverrides=\",\">").append("\n");
        for(Info info : infoList){
            buffer.append("             <trim prefix=\""+info.getColumn().toLowerCase()+" = case\" suffix=\"end,\">").append("\n");
            buffer.append("                 <foreach collection=\"list\" item=\"item\" index=\"index\" >").append("\n");
            buffer.append("                     <if test=\"item."+info.getColumn().toLowerCase()+" != null and "+info.getColumn().toLowerCase()+" !=''\" >").append("\n");
            buffer.append("                         WHEN "+condit+"=#{item."+condit+"} THEN #{item."+info.getColumn().toLowerCase()+"}").append("\n");
            buffer.append("                     </if>").append("\n");
            buffer.append("                 </foreach>").append("\n");
            buffer.append("             </trim>").append("\n");
        }
        buffer.append("         </trim>").append("\n");
        buffer.append("    </update>").append("\n").append("\n");
        // 批量修改
        buffer.append("    <!--批量修改操作-->").append("\n");
        buffer.append("    <update id=\"update"+tablename+"BatchByPrimaryKey\">").append("\n");
        buffer.append("        UPDATE "+tablenames+" SET (<include refid=\"Base_Column_List\" />)").append("\n");
        buffer.append("        WHERE "+condit+" IN").append("\n");
        buffer.append("        <foreach collection=\"list\" item=\"item\" separator=\",\" open=\"(\" close=\")\" >").append("\n");
        buffer.append("            #{item."+condit+"}").append("\n");
        buffer.append("        </foreach>").append("\n");
        buffer.append("    </update>").append("\n").append("\n");
        /*// 批量查询
        buffer.append("    <!--批量查询操作-->").append("\n");
        buffer.append("    <selece id=\"select"+tablename+"BatchList\" resultMap=\"\">").append("\n");
        buffer.append("        SELECE <include refid=\"Base_Column_List\" />  "+tablenames+"").append("\n");
        buffer.append("        WHERE "+condit+" IN").append("\n");
        buffer.append("        <foreach collection=\"list\" item=\"item\" separator=\",\" open=\"(\" close=\")\" >").append("\n");
        buffer.append("            #{item}").append("\n");
        buffer.append("        </foreach>").append("\n");
        buffer.append("    </update>").append("\n").append("\n");*/

        buffer.append("</mapper>");

        try {
            FileManager.writeFile(buffer.toString(),getXmlFile(mapperurl+"."+tablename+"Mapper"));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("mapper.xml创建失败");
        }
    }

    // 生成service.java
    public static void servicegenerate(){
        StringBuffer content = new StringBuffer("package ");
        content.append(getClssPack(serviceurl)).append(";\n\n");
        content.append("import "+pourl+"."+tablename).append(";\n");
        content.append("import org.apache.ibatis.annotations.Param;").append(";\n\n");
        content.append("import java.util.List;").append(";\n");
        content.append("import java.util.Map;").append(";\n\n");
        content.append("public interface ").append(getClssName(serviceurl)).append(" {").append("\n").append("\n");


        content.append("    /**").append("\n");
        content.append("     * 添加或者修改"+tablename+"信息").append("\n");
        content.append("     * create by 杨明 "+new SimpleDateFormat(DATE_TIME_PATTERN).format(new Date())).append("\n");
        content.append("     */").append("\n");
        content.append("    Map<String, Object> insertOrupdate"+tablename+"Info("+tablename+" "+names+");").append("\n").append("\n");
        String cond = "";
        for(Info info : infoList){
            if(infoList.get(0).getColumn() == info.getColumn()){
                cond = info.getColumn().toLowerCase();
            }
        }
        content.append("    /**").append("\n");
        content.append("     * 根据主键删除"+tablename+"信息").append("\n");
        content.append("     * create by 杨明 "+new SimpleDateFormat(DATE_TIME_PATTERN).format(new Date())).append("\n");
        content.append("     */").append("\n");
        content.append("    Map<String, Object> delete"+tablename+"ByPrimaryKey(Integer "+cond+");").append("\n").append("\n");

        content.append("    /**").append("\n");
        content.append("     * 获取所有的或者条件获取"+tablename+"信息").append("\n");
        content.append("     * create by 杨明 "+new SimpleDateFormat(DATE_TIME_PATTERN).format(new Date())).append("\n");
        content.append("     */").append("\n");
        content.append("    Map<String, Object> select"+tablename+"ByPrimary("+tablename+" "+names+");").append("\n").append("\n");

//        content.append("    /**").append("\n");
//        content.append("     * 批量添加"+tablename+"信息").append("\n");
//        content.append("     * create by 杨明 "+new SimpleDateFormat(DATE_TIME_PATTERN).format(new Date())).append("\n");
//        content.append("     */").append("\n");
//        content.append("    public int insert"+tablename+"Batch(List<"+tablename+"> list);").append("\n").append("\n");
//        content.append("    /**").append("\n");
//        content.append("     * 批量删除"+tablename+"信息").append("\n");
//        content.append("     * create by 杨明 "+new SimpleDateFormat(DATE_TIME_PATTERN).format(new Date())).append("\n");
//        content.append("     */").append("\n");
//        content.append("    public int delete"+tablename+"Batch(List<"+tablename+"> list);").append("\n").append("\n");
//        content.append("    /**").append("\n");
//        content.append("     * 批量修改"+tablename+"信息").append("\n");
//        content.append("     * create by 杨明 "+new SimpleDateFormat(DATE_TIME_PATTERN).format(new Date())).append("\n");
//        content.append("     */").append("\n");
//        content.append("    public int update"+tablename+"Batch(List<"+tablename+"> list);").append("\n").append("\n");
//        content.append("    /**").append("\n");
//        content.append("     * 批量修改"+tablename+"信息").append("\n");
//        content.append("     * create by 杨明 "+new SimpleDateFormat(DATE_TIME_PATTERN).format(new Date())).append("\n");
//        content.append("     */").append("\n");
//        content.append("    public int update"+tablename+"BatchPrimary(List<"+tablename+"> list);").append("\n").append("\n");
//        content.append("    /**").append("\n");
//        content.append("     * 批量list查询"+tablename+"信息").append("\n");
//        content.append("     * create by 杨明 "+new SimpleDateFormat(DATE_TIME_PATTERN).format(new Date())).append("\n");
//        content.append("     */").append("\n");
//        content.append("    public int select"+tablename+"BatchList(List<"+tablename+"> list);").append("\n").append("\n");
//        content.append("    /**").append("\n");
//        content.append("     * 批量arr查询"+tablename+"信息").append("\n");
//        content.append("     * create by 杨明 "+new SimpleDateFormat(DATE_TIME_PATTERN).format(new Date())).append("\n");
//        content.append("     */").append("\n");
//        content.append("    public int select"+tablename+"BatchArr(List<"+tablename+"> list);").append("\n").append("\n");

        content.append("\n}");
        try {
            FileManager.writeFile(content.toString(),getClassFile(serviceurl));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 生成serviceImpl.java
    public static void serviceImplgenerate(){
        int i = serviceurl.lastIndexOf(".");
        String implUrl = serviceurl.substring(0, i) + ".impl" + serviceurl.substring(i)+"Impl";

        StringBuffer content = new StringBuffer("package ");
        String cond = "";
        for(Info info : infoList){
            if(infoList.get(0).getColumn() == info.getColumn()){
                cond = info.getColumn().toLowerCase();
            }
        }

        content.append(getClssPack(implUrl)).append(";\n");
        content.append("import "+ mapperurl +"."+tablename+"Mapper;").append("\n");
        content.append("import "+ serviceurl +";").append("\n");
        content.append("import org.springframework.beans.factory.annotation.Autowired;").append("\n");
        content.append("import org.springframework.stereotype.Service;").append("\n");
        content.append("import org.springframework.transaction.annotation.Transactional;").append("\n").append("\n");
        content.append("@Service").append("\n");
        content.append("@Transactional").append("\n");
        content.append("public class ").append(getClssName(implUrl)).append(" implements "+getClssName(serviceurl)+" {").append("\n").append("\n");
        content.append("	@Autowired").append("\n");
        content.append("	private "+tablename+"Mapper "+tablename.toLowerCase()+"mapper;").append("\n\n");

        content.append("    /**").append("\n");
        content.append("     * 添加或者修改"+tablename+"信息").append("\n");
        content.append("     * create by 杨明 "+new SimpleDateFormat(DATE_TIME_PATTERN).format(new Date())).append("\n");
        content.append("     */").append("\n");
        content.append("     @Override").append("\n");
        content.append("    public Map<String, Object> insertOrupdate"+tablename+"Info("+tablename+" "+names+") {").append("\n");
        content.append("        Map<String, Object> map = new HashMap();").append("\n");
        content.append("        boolean flag = false;").append("\n");
        content.append("        String v = \"添加\";").append("\n");
        content.append("        if (null != "+names+") {").append("\n");
        content.append("            flag = "+tablename.toLowerCase()+"mapper.update"+tablename+"ByPrimaryKey("+names+") > 0;").append("\n");
        content.append("            v = \"修改\";").append("\n");
        content.append("        } else {").append("\n");
        content.append("            flag = "+tablename.toLowerCase()+"mapper.insert"+tablename+"Info("+names+") > 0;").append("\n");
        content.append("        }").append("\n");
        content.append("        map.put(\"flag\",flag);").append("\n");
        content.append("        map.put(\"message\",flag?v+\"成功\":v+\"失败，请稍后重试\");").append("\n");
        content.append("        return map").append("\n");

        content.append("    /**").append("\n");
        content.append("     * 根据主键删除"+tablename+"信息").append("\n");
        content.append("     * create by 杨明 "+new SimpleDateFormat(DATE_TIME_PATTERN).format(new Date())).append("\n");
        content.append("     */").append("\n");
        content.append("     @Override").append("\n");
        content.append("    public Map<String, Object> delete"+tablename+"ByPrimaryKey(Integer "+cond+") {").append("\n");
        content.append("        Map<String, Object> map = new HashMap();").append("\n");
        content.append("        boolean flag = "+tablename.toLowerCase()+"mapper.delete"+tablename+"ByPrimaryKey("+names+") > 0;").append("\n");
        content.append("        map.put(\"flag\",flag);").append("\n");
        content.append("        map.put(\"message\", flag ? \"删除成功\" : \"删除失败，请稍后重试\");").append("\n");
        content.append("        return map").append("\n");

        content.append("\n}");

        try {
            FileManager.writeFile(content.toString(),getClassFile(implUrl));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**下划线转驼峰*/
    private static String lineToHump(String str){
        Matcher matcher = Pattern.compile("_(\\w)").matcher(str.substring(0, 1).toUpperCase()+str.substring(1).toLowerCase());
        StringBuffer sb = new StringBuffer();
        while(matcher.find()){
            matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    private static String names(String str){
        String[]  strs = str.split("_");
        String s = "";
        for(int i=0,len=strs.length;i<len;i++){
            if( (i+1) == strs.length) {
                s = strs[i];
            }
        }
        StringBuffer sb = new StringBuffer();
        sb.append(s);
        return sb.toString();
    }

    private static String getClassFile(String className){
        return getPrePath() + StrUtils.replace(className,".","/") + ".java";
    }
    private static String getXmlFile(String className){
        return getPrePath() + StrUtils.replace(className,".","/") + ".xml";
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
        String path= GenerateUtil.class.getResource("/").getPath();
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
