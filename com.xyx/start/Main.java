package start;

import entity.Admin;
import service.AdminService;
import utils.Utils;
import view.MainView;
import view.ZhuceView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.HashMap;

/**
 * @author: xyx & yx282947664@163.com
 * @date 2023/7/29 029 19:02
 * @description: 程序开始的地方
 */
public class Main extends JFrame {
    public String systemTitle = Utils.title;

    JPanel p1 = new JPanel();
    JPanel p2 = new JPanel();
    JPanel p3 = new JPanel();
    JPanel p4 = new JPanel();

    JLabel welcome = new JLabel("欢迎来到xyx中学学生信息管理系统");
    JLabel username = new JLabel("账号：");
    JLabel password = new JLabel("密码：");

    JTextField usernameText = new JTextField(12);
    JTextField passwordText = new JTextField(12);

    //    按钮
    JButton zhuce = new JButton("注册");
    JButton denglu = new JButton("登录");
    JButton tuichu = new JButton("退出");

    public Main() {
        //    构造方法
        this.setVisible(true);
        // 设置标题
        this.setTitle(systemTitle);
        // 设置窗口大小
        this.setSize(1000, 400);
//        jframe居中
        this.setLocationRelativeTo(null);
//        添加面板布局规则
        this.setLayout(new GridLayout(4, 1, 3, 3));
//        点击❌号，关闭程序
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        welcome.setFont(Utils.f);
        welcome.setForeground(Color.red);
//        面板上加上标签
        p1.add(welcome);
//        面板加到frame上
        this.add(p1);

        username.setFont(Utils.f2);
        usernameText.setFont(Utils.f2);
        p2.add(username);
        p2.add(usernameText);
        this.add(p2);

        password.setFont(Utils.f2);
        passwordText.setFont(Utils.f2);
        p3.add(password);
        p3.add(passwordText);
        this.add(p3);

        zhuce.setFont(Utils.f2);
        denglu.setFont(Utils.f2);
        tuichu.setFont(Utils.f2);
        p4.add(denglu);
        p4.add(zhuce);
        p4.add(tuichu);
        this.add(p4);

//        点击注册时，增加动作监听
        zhuce.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == zhuce) {
//                    JOptionPane.showMessageDialog(null, "注册请联系xyx中学(yx282947664@163.com)", "通知", JOptionPane.WARNING_MESSAGE);
                    ZhuceView zhuceView = new ZhuceView();
                    zhuceView.setVisible(true);
                }
            }
        });

        //        点击登录时，增加动作监听
        denglu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == denglu) {
//                    判断是否有用户名或密码
                    String utext = usernameText.getText();
                    String ptext = passwordText.getText();
                    System.out.println(utext + "  " + ptext);
//                    System.out.println((utext == null)+"  "+(ptext == null));
                    if ((utext.equals("")) || (ptext.equals(""))) {
                        //判断账号和密码是否填写
                        JOptionPane.showMessageDialog(null, "账号或密码为空，请输入账号和密码", "警告", JOptionPane.WARNING_MESSAGE);
                    } else {
                        try {
                            Admin admin = AdminService.denglu(utext, ptext);
                            if ((admin.getUsername().equals(utext)) && (admin.getPassword().equals(ptext))) {
                                JOptionPane.showMessageDialog(null, "登录成功！", "通知", JOptionPane.INFORMATION_MESSAGE);
//                            关闭资源
                                dispose();
//                            跳转到登录成功界面
                                MainView mainView = new MainView();
                                mainView.setVisible(true);
                            }
                        } catch (SQLException ex) {
                            //登录失败
                            JOptionPane.showMessageDialog(null, "账号或密码错误", "警告", JOptionPane.WARNING_MESSAGE);
                            throw new RuntimeException(ex);
                        }
                    }
                }
            }
        });
//        点击推出时，增加动作监听
        tuichu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                0:将整个虚拟机里的内容都关掉，内存都释放掉！正常退出程序
                System.exit(0);
            }
        });
        //输入登录账号密码是隐藏信息
//        usernameText.addKeyListener(new KeyAdapter() {
//            public void keyTyped(KeyEvent e) {
//                String text = usernameText.getText();
//                usernameText.setText(new String(new char[text.length()]).replace("\0", "*"));
//            }
//        });
//
//        passwordText.addKeyListener(new KeyAdapter() {
//            public void keyTyped(KeyEvent e) {
//                String text = passwordText.getText();
//                passwordText.setText(new String(new char[text.length()]).replace("\0", "*"));
//            }
//        });


    }

    //    程序入口
    public static void main(String[] args) {
//        生成对象
        Main main = new Main();
    }


}
