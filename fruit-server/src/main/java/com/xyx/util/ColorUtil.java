package com.xyx.util;

/**
 * @author: xyx & yx282947664@163.com
 * @date 2023/8/12 012 21:56
 * @description: TODO
 */
public class ColorUtil {
    public static final String WATERMELON = "#FF3366";
    public static final String KIWI = "#99CC00";
    public static final String ORANGE = "#FF9900";
    public static final String DRAGON_FRUIT = "#FF33CC";
    public static final String MANGO = "#FFFF00";
    public static final String BANANA = "#FFFF00";

    public static String getColor(String name) {
        if (name.equals("西瓜")) {
            return WATERMELON;
        } else if (name.equals("奇异果")) {
            return KIWI;
        } else if (name.equals("橘子")) {
            return ORANGE;
        } else if (name.equals("火龙果")) {
            return DRAGON_FRUIT;
        } else if (name.equals("芒果")) {
            return MANGO;
        }else if (name.equals("香蕉")){
            return BANANA;
        }else {
            return "#000000";
        }
    }
}
