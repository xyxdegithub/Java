package view;

import service.StuScoreService;
import service.StuService;
import utils.MyTable;
import utils.Utils;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
 * @author: xyx & yx282947664@163.com
 * @date 2023/7/30 030 20:33
 * @description: TODO
 */
public class QueryAllScoreView extends JFrame {
    DefaultTableModel model = new DefaultTableModel(); //定义表格
    JTable allStu = new JTable(model);
    JScrollPane jScrollPane = new JScrollPane(allStu); //添加滚动条
    JButton fanhui = new JButton("返回主页面");

    JPanel p1 = new JPanel();

    public QueryAllScoreView() throws HeadlessException {
        this.setTitle("所有学生信息");
        this.setSize(1000,700);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String[] columnname={"学号","姓名","语文成绩","数学成绩","英语成绩"};
        //设置表格列名
        model.setColumnIdentifiers(columnname);
        //System.out.println(model);  //输出地址
        //表格信息文字居中对齐
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer)allStu.getDefaultRenderer(Object.class);
        renderer.setHorizontalAlignment(JLabel.CENTER);

        MyTable.setTable(allStu);
        p1.setLayout(new BoxLayout(p1, BoxLayout.Y_AXIS)); //这行代码不错

        fanhui.setFont(Utils.f3);

        p1.add(jScrollPane);
        p1.add(fanhui);
        this.add(p1);


        try {
            StuScoreService.queryAll(model);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"查询失败","警告",JOptionPane.WARNING_MESSAGE);
            throw new RuntimeException(e);
        }

        fanhui.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}
