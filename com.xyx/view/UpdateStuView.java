package view;

import service.StuService;
import utils.Utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author: xyx & yx282947664@163.com
 * @date 2023/7/30 030 20:30
 * @description: TODO
 */
public class UpdateStuView extends JFrame {
    JLabel id=new JLabel("更改信息的学生学号是：");
    JLabel name = new JLabel("请输入姓名：");
    JLabel classes = new JLabel("请输入班级：");
    JLabel age = new JLabel("请输入年龄：");
    JLabel gender = new JLabel("请输入性别：");

    JTextField textid = new JTextField(12);
    JTextField textname = new JTextField(12);
    JTextField textclasses = new JTextField(12);
    JTextField textage = new JTextField(12);
    JTextField textgender = new JTextField(12);

    JButton confirm = new JButton("确定");
    JButton cancel = new JButton("取消");
    JPanel p1 = new JPanel();
    JPanel p2 = new JPanel();
    JPanel p3 = new JPanel();
    JPanel p4 = new JPanel();
    JPanel p5 = new JPanel();
    JPanel p6 = new JPanel();

    public UpdateStuView() throws HeadlessException {
        this.setSize(600, 600);
        this.setTitle("更改学生信息");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(6, 1, 1, 1));

        Font font = Utils.f3;

        id.setFont(font);
        textid.setFont(font);
        p1.add(id);
        p1.add(textid);
        this.add(p1);

        name.setFont(font);
        textname.setFont(font);
        p2.add(name);
        p2.add(textname);
        this.add(p2);

        age.setFont(font);
        textage.setFont(font);
        p3.add(age);
        p3.add(textage);
        this.add(p3);

        gender.setFont(font);
        textgender.setFont(font);
        p4.add(gender);
        p4.add(textgender);
        this.add(p4);

        classes.setFont(font);
        textclasses.setFont(font);
        p5.add(classes);
        p5.add(textclasses);
        this.add(p5);

        confirm.setFont(font);
        cancel.setFont(font);
        p6.add(confirm);
        p6.add(cancel);
        this.add(p6);

        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    //数据库添加
                    StuService.updateStu(textid.getText(),textname.getText(),textage.getText(),textgender.getText(),textclasses.getText());
                    JOptionPane.showMessageDialog(null,"修改成功","通知",JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null,"修改失败","警告",JOptionPane.WARNING_MESSAGE);
                }
                dispose();
            }
        });
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

    }
}
