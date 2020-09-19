package com.wistron.wcd;

import javax.swing.*;
import java.awt.*;

/**
 * Hello world!
 *
 */
public class App 
{
    JFrame frame = new JFrame("文本替换");
    // 定义一个按钮,并为之指定图标
//    Icon okIcon = new ImageIcon("ico/ok.png");
    JButton ok = new JButton("确认" );
    // 定义一个8行、20列的多行文本域
//    JTextArea ta = new JTextArea(1, 20);
    // 定义一个40列的单行文本域
    JTextField ta = new JTextField(30);
    // 定义一个40列的单行文本域
    JTextField name = new JTextField(30);
    JMenuBar mb = new JMenuBar();
    JMenu replaceDescLabel = new JMenu("旧单词");
    JMenu newDescLabel = new JMenu("新单词");
    // 定义一个右键菜单用于设置程序风格
    JPopupMenu pop = new JPopupMenu();
    // -----------------用于执行界面初始化的init方法---------------------
    public void init()
    {
        // 创建一个装载了文本框、按钮的JPanel
        JPanel bottom = new JPanel();
        bottom.add(name);
        bottom.add(ok);
        frame.add(bottom , BorderLayout.SOUTH);
        // 创建一个垂直排列组件的Box，盛装多行文本域JPanel
        Box topLeft = Box.createVerticalBox();
        // 使用JScrollPane作为普通组件的JViewPort
        JScrollPane taJsp = new JScrollPane(ta);     //⑤
        topLeft.add(taJsp);

        // 创建一个水平排列组件的Box，盛装topLeft、colorList
        Box top = Box.createHorizontalBox();
        top.add(topLeft);
        // 将top Box容器添加到窗口的中间
        frame.add(top);
        // -----------下面开始组合菜单、并为菜单添加监听器----------
        // 将file、edit菜单添加到mb菜单条中
        mb.add(replaceDescLabel);
        // 为f窗口设置菜单条
        frame.setJMenuBar(mb);
        // 设置关闭窗口时，退出程序
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    public static void main(String[] args)
    {
        // 设置Swing窗口使用Java风格
        //JFrame.setDefaultLookAndFeelDecorated(true);   //③
        new App().init();
    }
}
