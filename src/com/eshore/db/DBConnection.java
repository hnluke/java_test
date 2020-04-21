package com.eshore.db;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 数据库连接类，定义数据库的连接与关闭
 */
public class DBConnection {
    // MySql数据库的驱动字符串
    //private static final String Driver = "com.mysql.jdbc.Driver";  // MySql 5.1.47及以下版本的驱动
    private static final String Driver = "com.mysql.cj.jdbc.Driver"; // MySql 6.0.6版驱动
    // 连接需要的数据库的URL,其中mydata为数据库名
    private static final String URL = "jdbc:mysql://localhost:3306/mydata";
    // 连接数据库的用户和密码
    private static final String USER = "root";
    private static final String PASSWORD = "888";
    private Connection conn = null;
    public DBConnection() throws Exception{
        try {
            Class.forName(Driver); // 加载数据库驱动
            // 建立数据库的连接
            this.conn = DriverManager.getConnection(URL, USER, PASSWORD);
        }catch(Exception e) {
            throw e;
        }
    }

    public Connection getConn() {
        return this.conn;
    }
    
    public void close() throws Exception{
        if(this.conn != null) {
            try {
                this.conn.close();
            }catch(Exception e) {
                throw e;
            }
        }
    }
}
