package service;

import utils.JDBCMysql;

import javax.swing.table.DefaultTableModel;
import java.sql.*;

/**
 * @author: xyx & yx282947664@163.com
 * @date 2023/7/31 031 18:09
 * @description: TODO
 */
public class StuScoreService {
    public static void insert(String id, String name, String chinese, String math, String english) throws SQLException {
        System.out.println(id + " " + name + ' ' + chinese + ' ' + math + ' ' + english);
        Connection connection = JDBCMysql.getConnection(); //得到连接
        //这里使用update语句来逻辑实现插入功能
        String sql = "update students set chinese=?,math=?,english=? where id=? and name=?";
        //用PreparedStatement防止sql注入,带参数的sql语句
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, chinese);
        preparedStatement.setString(2, math);
        preparedStatement.setString(3, english);
        preparedStatement.setString(4, id);
        preparedStatement.setString(5, name);

        //执行sql更新语句
        int count = preparedStatement.executeUpdate();
        if (count == 1) {
            System.out.println(count);
            System.out.println(id + "  " + name + "  " + chinese + "  " + math + "  " + english);
            System.out.println("增加学生成绩信息成功！");
        }
        //关闭连接
        JDBCMysql.Close(preparedStatement, connection);
        System.out.println("---------------------------------------------");
    }

    public static void delete(String id, String name) throws SQLException {
        Connection connection = JDBCMysql.getConnection(); //得到连接
        //使用 UPDATE 语句将字段的值设置为 NULL 或默认值,以清空字段数据
        String sql = "update students set chinese=NULL,math=NULL,english=NULL where id=? and name=?";
        //用PreparedStatement防止sql注入,带参数的sql语句
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, id);
        preparedStatement.setString(2, name);

        //执行sql更新语句
        int count = preparedStatement.executeUpdate();
        if (count == 1) {
            System.out.println(count);
            System.out.println("删除学生成绩信息成功！");
        }
        //关闭连接
        JDBCMysql.Close(preparedStatement, connection);
        System.out.println("---------------------------------------------");
    }

    public static void update(String id, String name, String chinese, String math, String english) throws SQLException {
        Connection connection = JDBCMysql.getConnection(); //得到连接
        String sql = "update students set chinese=?,math=?,english=? where id=? and name=?";
        //用PreparedStatement防止sql注入,带参数的sql语句
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, chinese);
        preparedStatement.setString(2, math);
        preparedStatement.setString(3, english);
        preparedStatement.setString(4, id);
        preparedStatement.setString(5, name);
//        System.out.println(preparedStatement);
        //执行sql更新语句
        int count = preparedStatement.executeUpdate();
        if (count == 1) {
            System.out.println(count);
            System.out.println("更新学生信息成功！");
            System.out.println(id + ' ' + name + ' ' + chinese + ' ' + math + ' ' + english);
        }
        //关闭连接
        JDBCMysql.Close(preparedStatement, connection);
        System.out.println("---------------------------------------------");
    }

    public static void query(String id, DefaultTableModel model) throws SQLException {
        Connection connection = JDBCMysql.getConnection();
        String sql = "select id,name,chinese,math,english from students where id=?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, id);

        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            String id2 = rs.getString("id");
            String name = rs.getString("name");
            String chinese = rs.getString("chinese");
            String math = rs.getString("math");
            String english = rs.getString("english");

            System.out.println(id2 + "  " + name + "  " + chinese + "  " + math + "  " + english);
            //添加到表格中
            model.addRow(new Object[]{id, name, chinese, math, english});
        }
        System.out.println("查找学生成绩信息成功！");
        JDBCMysql.Close(preparedStatement, connection);
        System.out.println("---------------------------------------------");

    }

    public static void queryAll(DefaultTableModel model) throws SQLException {
        Connection connection = JDBCMysql.getConnection();
        Statement statement = connection.createStatement();

        String sql = "select id,name,chinese,math,english from students";

        ResultSet rs = statement.executeQuery(sql);
//        System.out.println(sql);
//        System.out.println(rs);
//        System.out.println(rs.next());

        while (rs.next()) {
            String id = rs.getString("id");
            String name = rs.getString("name");
            String chinese = rs.getString("chinese");
            String math = rs.getString("math");
            String english = rs.getString("english");

            System.out.println(id + "  " + name + "  " + chinese + "  " + math + "  " + english);
            //添加到表格中
            model.addRow(new Object[]{id, name, chinese, math, english});
        }
        System.out.println("查看所有学生信息成功！");
        JDBCMysql.Close(statement, connection);
        System.out.println("---------------------------------------------");

    }
}
