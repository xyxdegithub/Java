package utils;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 * @author: xyx & yx282947664@163.com
 * @date 2023/7/31 031 10:05
 * @description: 自定义表格
 */
public class MyTable {
    public static void setTable(JTable table) {
        table.setFont(Utils.f3); //设置表格信息字体大小
        table.setRowHeight(40); //设置表格行高

        //得到表格的头
        JTableHeader tableHeader = table.getTableHeader();
        tableHeader.setFont(Utils.f3); //设置表头字体大小

        //得到表格的列模型
        TableColumnModel columnModel = table.getColumnModel();
        //得到第c个列对象
        int ccount = columnModel.getColumnCount();
        System.out.println("ccount："+ccount);

        int cWidth=100;
//
//        TableColumn column1 = columnModel.getColumn(0);
//        column1.setPreferredWidth(130);
//        System.out.println(1);
//
//        TableColumn column2 = columnModel.getColumn(1);
//        column2.setPreferredWidth(130);
//        System.out.println(2);
//
//        TableColumn column3 = columnModel.getColumn(2);
//        column3.setPreferredWidth(130);
//        System.out.println(3);
//
//        TableColumn column4 = columnModel.getColumn(3);
//        column4.setPreferredWidth(130);
//        System.out.println(4);
//
//        TableColumn column5 = columnModel.getColumn(4);
//        column5.setPreferredWidth(130);
//        System.out.println(5);
//
        //设置所有列行高
        for (int c = 0; c < ccount; c++) {
            columnModel.getColumn(c).setPreferredWidth(cWidth);
        }


    }

//    public static void setTableCol(JTable table, int c) {
//        TableColumnModel columnModel = table.getColumnModel();
//        columnModel.getColumn(c).setPreferredWidth();
//    }


}
