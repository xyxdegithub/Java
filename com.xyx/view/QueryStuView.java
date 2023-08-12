package view;

import service.StuService;
import utils.MyTable;
import utils.Utils;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author: xyx & yx282947664@163.com
 * @date 2023/7/30 030 20:30
 * @description: TODO
 */
public class QueryStuView extends JFrame {
    JLabel id = new JLabel("请输入学生的学号：");
    JTextField idText = new JTextField(12);
    JButton confirm = new JButton("查找");
    JPanel p1 = new JPanel();
    JPanel p2 = new JPanel();
    DefaultTableModel model = new DefaultTableModel(); //定义表格
    JTable allStu = new JTable(model);
    JScrollPane jScrollPane = new JScrollPane(allStu); //添加滚动条
    JButton fanhui = new JButton("返回主页面");

    public QueryStuView() throws HeadlessException {
        this.setTitle("查询学生信息");
        this.setSize(1000, 350);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(2,1,0,0));

        id.setFont(Utils.f3);
        idText.setFont(Utils.f3);
        confirm.setFont(Utils.f3);
        p1.add(id);
        p1.add(idText);
        p1.add(confirm);
        this.add(p1);

        String[] columnname = {"学号", "姓名", "年龄", "性别", "班级"};
        //设置表格列名
        model.setColumnIdentifiers(columnname);
        //表格信息文字居中对齐
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) allStu.getDefaultRenderer(Object.class);
        renderer.setHorizontalAlignment(JLabel.CENTER);
        //设置表格列宽等
        MyTable.setTable(allStu);
        //设置p2布局
        p2.setLayout(new BoxLayout(p2, BoxLayout.Y_AXIS));

        fanhui.setFont(Utils.f3);

        p2.add(jScrollPane);
        p2.add(fanhui);
        this.add(p2);


        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    //数据库添加
                    StuService.queryStu(idText.getText(), model);
                    JOptionPane.showMessageDialog(null, "查找成功", "通知", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "查找失败", "警告", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        fanhui.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

    }
}
