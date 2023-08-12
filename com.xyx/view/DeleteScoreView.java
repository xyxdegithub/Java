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
public class DeleteScoreView extends JFrame {
    JLabel id = new JLabel("请输入学生学号：");
    JLabel name = new JLabel("请输入学生姓名：");
    JTextField textid = new JTextField(12);
    JTextField textname = new JTextField(12);
    JButton confirm = new JButton("确定");
    JButton cancel = new JButton("取消");
    JPanel p1 = new JPanel();
    JPanel p2 = new JPanel();
    JPanel p3 = new JPanel();

    public DeleteScoreView() throws HeadlessException {
        this.setSize(500, 300);
        this.setTitle("删除学生成绩信息");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(3, 1, 1, 1));

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

        confirm.setFont(font);
        cancel.setFont(font);
        p3.add(confirm);
        p3.add(cancel);
        this.add(p3);

        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    StuScoreService.delete(textid.getText(),textname.getText());
                    JOptionPane.showMessageDialog(null,"删除成功","通知",JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null,"删除失败","警告",JOptionPane.WARNING_MESSAGE);
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
