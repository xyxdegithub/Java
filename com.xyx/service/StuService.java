package service;

import utils.JDBCMysql;
import utils.Utils;

import javax.swing.table.DefaultTableModel;
import java.sql.*;

/**
 * @author: xyx & yx282947664@163.com
 * @date 2023/7/30 030 23:25
 * @description: 公有静态外部类可以直接访问
 * sql语句语法要对
 */
public class StuService {
    public static void insertStu(String id, String name, String age, String gender, String classes) throws SQLException {
        System.out.println(id);
        System.out.println(name);
        System.out.println(age);
        System.out.println(gender);
        System.out.println(classes);
        Connection connection = JDBCMysql.getConnection(); //得到连接
        String sql = "insert into students(id,name,age,sex,classes) values (?,?,?,?,?)";
        //用PreparedStatement防止sql注入,带参数的sql语句
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, id);
        preparedStatement.setString(2, name);
        //类型转换
        int iage = Integer.parseInt(age);
        preparedStatement.setInt(3, iage);
        preparedStatement.setString(4, gender);
        preparedStatement.setString(5, classes);
//        System.out.println(preparedStatement);
        //执行sql更新语句
        int count = preparedStatement.executeUpdate();
        if (count == 1) {
            System.out.println(count);
            System.out.println("增加学生信息成功！");
        }
        //关闭连接
        JDBCMysql.Close(preparedStatement, connection);
        System.out.println("---------------------------------------------");
    }

    public static void deleteStu(String id, String name) throws SQLException {
        Connection connection = JDBCMysql.getConnection(); //得到连接
        String sql = "delete from students where id=? and name=?";
        //用PreparedStatement防止sql注入,带参数的sql语句
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, id);
        preparedStatement.setString(2, name);

        //执行sql更新语句
        int count = preparedStatement.executeUpdate();
        if (count == 1) {
            System.out.println(count);
            System.out.println("删除学生信息成功！");
        }
        //关闭连接
        JDBCMysql.Close(preparedStatement, connection);
        System.out.println("---------------------------------------------");
    }

    public static void updateStu(String id, String name, String age, String gender, String classes) throws SQLException {
        Connection connection = JDBCMysql.getConnection(); //得到连接
        String sql = "update students set name=?,age=?,sex=?,classes=? where id=?";
        //用PreparedStatement防止sql注入,带参数的sql语句
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, name);
        //类型转换
        int iage = Integer.parseInt(age);
        preparedStatement.setInt(2, iage);
        preparedStatement.setString(3, gender);
        preparedStatement.setString(4, classes);
        preparedStatement.setString(5, id);
//        System.out.println(preparedStatement);
        //执行sql更新语句
        int count = preparedStatement.executeUpdate();
        if (count == 1) {
            System.out.println(count);
            System.out.println("更新学生信息成功！");
        }
        //关闭连接
        JDBCMysql.Close(preparedStatement, connection);
        System.out.println("---------------------------------------------");
    }

    public static void queryStu(String id,DefaultTableModel model) throws SQLException {
        Connection connection = JDBCMysql.getConnection();
        String sql = "select id,name,age,sex,classes from students where id=?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, id);

        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            String id2 = rs.getString("id");
            String name = rs.getString("name");
            int age = rs.getInt("age");
            String gender = rs.getString("sex");
            String classes = rs.getString("classes");

            System.out.println(id2 + "  " + name + "  " + age + "  " + gender + "  " + classes);
            //添加到表格中
            model.addRow(new Object[]{id, name, age, gender, classes});
        }
        System.out.println("查找学生信息成功！");
        JDBCMysql.Close(preparedStatement, connection);
        System.out.println("---------------------------------------------");

    }

    public static void queryAllStu(DefaultTableModel model) throws SQLException {
        Connection connection = JDBCMysql.getConnection();
        Statement statement = connection.createStatement();

        String sql = "select id,name,age,sex,classes from students";

        ResultSet rs = statement.executeQuery(sql);
//        System.out.println(sql);
//        System.out.println(rs);
//        System.out.println(rs.next());

        while (rs.next()) {
            String id = rs.getString("id");
            String name = rs.getString("name");
            int age = rs.getInt("age");
            String gender = rs.getString("sex");
            String classes = rs.getString("classes");

            System.out.println(id + "  " + name + "  " + age + "  " + gender + "  " + classes);
            //添加到表格中
            model.addRow(new Object[]{id, name, age, gender, classes});
        }
        System.out.println("查看所有学生信息成功！");
        JDBCMysql.Close(statement, connection);
        System.out.println("---------------------------------------------");

    }


}
