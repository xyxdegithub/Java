package service;

import entity.Admin;
import utils.JDBCMysql;

import javax.swing.*;
import java.sql.*;

/**
 * @author: xyx & yx282947664@163.com
 * @date 2023/7/31 031 9:37
 * @description: 与mysql数据库交互
 */
public class AdminService {
    public static Admin denglu(String uText, String pText) throws SQLException {
        Admin admin = null;
        Connection connection = JDBCMysql.getConnection();
        //验证登录用户名和密码
        String sql = "select aname,apassword from admins where aname=? and apassword=?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        //把参数传入问号
        System.out.println(uText+"__"+pText);
        preparedStatement.setString(1, uText);
        preparedStatement.setString(2, pText);
        System.out.println(sql);

        //执行sql语句
        ResultSet rs = preparedStatement.executeQuery();
        //结果
        while (rs.next()) {
            String username2 = rs.getString("aname");
            String password2 = rs.getString("apassword");

            System.out.println(username2 + "  " + password2);
            admin = new Admin(username2, password2);
        }
        //关闭连接
        JDBCMysql.Close(preparedStatement, connection);

        if (admin==null){
            JOptionPane.showMessageDialog(null,"该账号还没注册，请去注册","警告",JOptionPane.WARNING_MESSAGE);
            throw new NullPointerException("查询结果为空,该账号还没注册，请去注册!");
        }else {
            return admin;
        }

    }

    public static void zhuce(String uText, String pText) throws SQLException {
//        Admin admin=denglu(uText,pText);
//        if (admin==null){
//            throw new NullPointerException("查询结果为空,该账号还没注册，可以注册!");
//            Connection connection2 = JDBCMysql.getConnection();
//        }


    }
}
