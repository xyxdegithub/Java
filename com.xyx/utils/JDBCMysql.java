package utils;

import java.sql.*;

/**
 * @author: xyx & yx282947664@163.com
 * @date 2023/7/30 030 22:24
 * @description: TODO
 */
public class JDBCMysql {
    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String url = "jdbc:mysql://localhost:3306/xyx_school?characterEncoding=utf8&serverTimezone=Asia/Shanghai";
    public static final String username = "root";
    public static final String password = "root";

    static {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

/**
    * @author: xyx & yx282947664@163.com
    * @date ${DATE} ${TIME}
    * @description: 返回一个连接
    */
    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
        * @author: xyx & yx282947664@163.com
        * @date ${DATE} ${TIME}
        * @description: 关闭数据库连接的2个方法
        */
    public static void Close(Statement statement, Connection connection){
        Close(null,statement,connection);
    }
    public static void Close(ResultSet rs, Statement statement, Connection connection){
        try{
            if(rs!=null&&!rs.isClosed()){
                rs.close();
            }
            if(statement!=null&&!statement.isClosed()){
                statement.close();
            }
            if(connection!=null&&!connection.isClosed()){
                connection.close();
            }
        }catch(Exception e){
            System.out.println("关闭数据连接失败");
        }
    }
}
