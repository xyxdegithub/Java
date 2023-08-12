package view;

import service.StuScoreService;
import service.StuService;
import utils.Utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author: xyx & yx282947664@163.com
 * @date 2023/7/30 030 20:31
 * @description: TODO
 */
public class UpdateScoreView extends JFrame {
    JLabel id=new JLabel("更改成绩的学生学号是：");
    JLabel name = new JLabel("更改成绩的学生姓名：");
    JLabel chinese = new JLabel("请输入语文成绩：");
    JLabel math = new JLabel("请输入数学成绩：");
    JLabel english = new JLabel("请输入英语成绩：");

    JTextField textid = new JTextField(12);
    JTextField textname = new JTextField(12);
    JTextField textchinese = new JTextField(12);
    JTextField textmath = new JTextField(12);
    JTextField textenglish = new JTextField(12);

    JButton confirm = new JButton("确定");
    JButton cancel = new JButton("取消");
    JPanel p1 = new JPanel();
    JPanel p2 = new JPanel();
    JPanel p3 = new JPanel();
    JPanel p4 = new JPanel();
    JPanel p5 = new JPanel();
    JPanel p6 = new JPanel();

    public UpdateScoreView() throws HeadlessException {
        this.setSize(600, 600);
        this.setTitle("更改学生成绩信息");
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

        chinese.setFont(font);
        textchinese.setFont(font);
        p3.add(chinese);
        p3.add(textchinese);
        this.add(p3);

        math.setFont(font);
        textmath.setFont(font);
        p4.add(math);
        p4.add(textmath);
        this.add(p4);

        english.setFont(font);
        textenglish.setFont(font);
        p5.add(english);
        p5.add(textenglish);
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
                    StuScoreService.update(textid.getText(),textname.getText(),textchinese.getText(),textmath.getText(),textenglish.getText());
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
