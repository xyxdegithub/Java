package view;

import start.Main;
import utils.Utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author: xyx & yx282947664@163.com
 * @date 2023/7/30 030 12:22
 * @description: 登录系统之后的主界面
 */
public class MainView extends JFrame {
    JLabel label = new JLabel("请选择点击操作：");
    JButton insertStu = new JButton("添加学生信息");
    //    MyButton insertStu = new MyButton("添加学生信息");
    JButton deleteStu = new JButton("删除学生信息");
    //    MyButton deleteStu = new MyButton("删除学生信息");
    JButton updateStu = new JButton("修改学生信息");
    JButton queryStu = new JButton("查询学生信息");
    JButton queryAllStu = new JButton("查看所有学生信息");
    JButton insertScore = new JButton("添加成绩信息");
    JButton deleteScore = new JButton("删除成绩信息");
    JButton updateScore = new JButton("修改成绩信息");
    JButton queryScore = new JButton("查询成绩信息");
    JButton queryAllScore = new JButton("查询所有学生成绩信息");

    public MainView() throws HeadlessException {
//        设置Jframe标题
        this.setTitle(Utils.title);

        this.setSize(1000, 500);
        this.setLayout(new GridBagLayout());
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        label.setFont(Utils.f);
        label.setForeground(Color.red);

        insertStu.setFont(Utils.f3);
        deleteStu.setFont(Utils.f3);
        updateStu.setFont(Utils.f3);
        queryStu.setFont(Utils.f3);
        queryAllStu.setFont(Utils.f3);
        insertScore.setFont(Utils.f3);
        deleteScore.setFont(Utils.f3);
        updateScore.setFont(Utils.f3);
        queryScore.setFont(Utils.f3);
        queryAllScore.setFont(Utils.f3);

//通过setPreferredSize()方法来设置按钮大小
        Dimension dimension = new Dimension(350, 50);
        insertStu.setPreferredSize(dimension);
        deleteStu.setPreferredSize(dimension);
        updateStu.setPreferredSize(dimension);
        queryStu.setPreferredSize(dimension);
        queryAllStu.setPreferredSize(dimension);

        insertScore.setPreferredSize(dimension);
        deleteScore.setPreferredSize(dimension);
        updateScore.setPreferredSize(dimension);
        queryScore.setPreferredSize(dimension);
        queryAllScore.setPreferredSize(dimension);

        GridBagConstraints gbc = new GridBagConstraints();
//        gBC.gridx=GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth=2; //占2列
        gbc.anchor = GridBagConstraints.CENTER; // 设置位置居中
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        this.add(label, gbc);

        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.gridx = 0;
        gbc2.gridy = GridBagConstraints.RELATIVE; // 按钮竖着排列
        gbc2.fill = GridBagConstraints.HORIZONTAL;
        gbc2.insets = new Insets(8, 8, 8, 8);

        this.add(insertStu, gbc2);
        this.add(deleteStu, gbc2);
        this.add(updateStu, gbc2);
        this.add(queryStu, gbc2);
        this.add(queryAllStu, gbc2);

        GridBagConstraints gbc3 = new GridBagConstraints();
        gbc3.gridx = 1;
        gbc3.gridy = GridBagConstraints.RELATIVE;
        gbc3.fill = GridBagConstraints.HORIZONTAL;
        gbc3.insets = new Insets(8, 8, 8, 8);

        this.add(insertScore, gbc3);
        this.add(deleteScore, gbc3);
        this.add(updateScore, gbc3);
        this.add(queryScore, gbc3);
        this.add(queryAllScore, gbc3);

        insertStu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InsertStuView insertStuView = new InsertStuView();
                insertStuView.setVisible(true);
            }
        });
        deleteStu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeleteStuView deleteStuView = new DeleteStuView();
                deleteStuView.setVisible(true);
            }
        });
        updateStu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UpdateStuView updateStuView = new UpdateStuView();
                updateStuView.setVisible(true);
            }
        });
        queryStu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                QueryStuView queryStuView = new QueryStuView();
                queryStuView.setVisible(true);
            }
        });
        queryAllStu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                QueryAllStuView queryAllStuView = new QueryAllStuView();
                queryAllStuView.setVisible(true);
            }
        });
        insertScore.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InsertScoreView insertScoreView = new InsertScoreView();
                insertScoreView.setVisible(true);
            }
        });
        deleteScore.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeleteScoreView deleteScoreView = new DeleteScoreView();
                deleteScoreView.setVisible(true);
            }
        });
        updateScore.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UpdateScoreView updateScoreView = new UpdateScoreView();
                updateScoreView.setVisible(true);
            }
        });
        queryScore.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                QueryScoreView queryScoreView = new QueryScoreView();
                queryScoreView.setVisible(true);

            }
        });
        queryAllScore.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                QueryAllScoreView queryAllScoreView = new QueryAllScoreView();
                queryAllScoreView.setVisible(true);

            }
        });


    }
}
