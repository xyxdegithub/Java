package utils;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

/**
 * @author: xyx & yx282947664@163.com
 * @date 2023/7/30 030 20:05
 * @description: 继承button类，重写button，绘制形状
 */
public class MyButton extends JButton{
    @Override
    protected void paintComponent(Graphics g) {
//        强制类型转换
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//        设置画笔颜色
        g2.setColor(Color.CYAN);
// 绘制圆角矩形边框
        g2.setStroke(new BasicStroke(10));
        RoundRectangle2D shape = new RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, 20, 20);
        g2.draw(shape);
        // 设置按钮内容区域为透明
        g2.setColor(new Color(0,0,0,0));
        g2.fill(shape);

    }

    public MyButton(String text) {
//        setContentAreaFilled(false);
    }

}
