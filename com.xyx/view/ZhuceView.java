package view;

import service.AdminService;
import service.StuService;
import utils.Utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author: xyx & yx282947664@163.com
 * @date 2023/7/31 031 14:17
 * @description: TODO
 */
public class ZhuceView extends JFrame {

    JLabel name = new JLabel("请输入账号：");
    JLabel passw = new JLabel("请输入密码：");

    JTextField textname = new JTextField(12);
    JTextField textpassw = new JTextField(12);

    JButton confirm = new JButton("确定");
    JButton cancel = new JButton("取消");
    JButton fanhui = new JButton("返回");
    JPanel p1 = new JPanel();
    JPanel p2 = new JPanel();
    JPanel p3 = new JPanel();
    JPanel p4 = new JPanel();


    JLabel tongzhi=new JLabel("学校信息不对外公开");
    JLabel tongzhi2=new JLabel("如需注册请向xyx中学咨询");
    JLabel tongzhi3=new JLabel("电子邮箱:yx282947664@163.com");
    public ZhuceView() throws HeadlessException {
//        this.setSize(500, 230);
//        this.setTitle("系统用户注册");
//        this.setLocationRelativeTo(null);
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        this.setLayout(new GridLayout(3, 1, 1, 1));
//
        Font font = Utils.f3;
//
//        name.setFont(font);
//        textname.setFont(font);
//        p1.add(name);
//        p1.add(textname);
//        this.add(p1);
//
//        passw.setFont(font);
//        textpassw.setFont(font);
//        p2.add(passw);
//        p2.add(textpassw);
//        this.add(p2);
//
//        confirm.setFont(font);
//        cancel.setFont(font);
//        p3.add(confirm);
//        p3.add(cancel);
//        this.add(p3);
//
//        confirm.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                try {
//                    //数据库添加
//                    AdminService.zhuce(textname.getText(),textpassw.getText());
//                    JOptionPane.showMessageDialog(null,"注册成功,请去登录","通知",JOptionPane.INFORMATION_MESSAGE);
//                } catch (Exception ex) {
//                    JOptionPane.showMessageDialog(null,"添加失败","警告",JOptionPane.WARNING_MESSAGE);
//                }
//                dispose();
//            }
//        });


        //另一种情况
        this.setSize(500, 280);
        this.setTitle("系统用户注册");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(4, 1, 1, 1));

        tongzhi.setFont(font);
        tongzhi.setForeground(Color.red);
        p1.add(tongzhi);
        tongzhi2.setFont(font);
        tongzhi2.setForeground(Color.red);
        p2.add(tongzhi2);
        tongzhi3.setFont(font);
        tongzhi3.setForeground(Color.red);
        p3.add(tongzhi3);

        this.add(p1);
        this.add(p2);
        this.add(p3);

        fanhui.setFont(font);
        p4.add(fanhui);
        this.add(p4);

        fanhui.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });



    }
}
