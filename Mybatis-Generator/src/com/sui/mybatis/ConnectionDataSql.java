package com.sui.mybatis;

import com.sui.Util.Info;

import java.sql.*;
import java.util.*;

public class ConnectionDataSql {

    private static ResourceBundle parameter = ResourceBundle.getBundle("mybatis");
    
    /**
     * 连接数据库
     */
    public static Connection getConnection(){
        Connection conn = null;
        try {
            Class.forName(parameter.getString("mysql.driver"));
            String url = parameter.getString("mysql.url");
            String user = parameter.getString("mysql.username");
            String pass = parameter.getString("mysql.password");
            conn = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }

    /**
     * 获取表结构
     */
    public static List<Info> getInfoList(){
        PreparedStatement stmt;
        Connection conn = getConnection();
        String sql = "SELECT * FROM "+ parameter.getString("project.table");
        List<Info> infoList = new ArrayList<Info>();
        try {
            stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);
            ResultSetMetaData data = rs.getMetaData();
            rs.close();
            sql = "show full columns from "+ parameter.getString("project.table");
            rs = stmt.executeQuery(sql);
            int count=1;
            while (rs.next()){
                String className = data.getColumnClassName(count++);
                String columntype = className.substring(className.lastIndexOf(".") + 1);
                Info info = new Info();
                info.setColumn(rs.getString("Field"));
                info.setNotes(rs.getString("Comment"));
                if("timestamp".equals(columntype.toLowerCase())) info.setColumntype("Date");
                else  info.setColumntype(columntype);

                infoList.add(info);
            }
            conn.close();
            return infoList;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("数据库字段获取失败");
            return null;
        }
    }




    public static void main(String[] args) {
       List<Info> info= getInfoList();
    }



    // 获取某列对应的表名
    /* String tableName = data.getTableName(1);
    System.out.println(tableName);
    for (int i = 1; i <= data.getColumnCount(); i++) {
        // 获得指定列的列名
        String columnName = data.getColumnName(i);
        // 对应数据类型的类
        String columnClassName = data.getColumnClassName(i);
        System.out.println(columnName);
        System.out.println(columnClassName);
    }*/
    // 获得所有列的数目及实际列数
    //int columnCount = data.getColumnCount();
    // 获得指定列的列值
    //int columnType = data.getColumnType(i);
    // 获得指定列的数据类型名
    //String columnTypeName = data.getColumnTypeName(i);
    // 所在的Catalog名字
    //String catalogName = data.getCatalogName(i);
    // 在数据库中类型的最大字符个数
    //int columnDisplaySize = data.getColumnDisplaySize(i);
    // 获得列的模式
    //String schemaName = data.getSchemaName(i);
    // 某列类型的精确度(类型的长度)
    //int precision = data.getPrecision(i);
    // 小数点后的位数
    //int scale = data.getScale(i);
    // 在数据库中是否为货币型
    //boolean isCurrency = data.isCurrency(i);
    // 是否为空
    //int isNullable = data.isNullable(i);
    // 是否为只读
    //boolean isReadOnly = data.isReadOnly(i);
    // 能否出现在where中
    //boolean isSearchable = data.isSearchable(i);
    // 是否自动递增
    //boolean isAutoInctement = data.isAutoIncrement(i);
    // 默认的列的标题
    //String columnLabel = data.getColumnLabel(i);
}
