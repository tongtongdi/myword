package jvm.lenambda;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.sql.SQLOutput;

/**
 * @Description:
 * @Date: 2019/7/16
 * @Author 王通
 * @Version 1.0
 */

public class Main extends JFrame {

    private JButton jb;
    public Main(){

        this.setBounds(200, 200, 200, 200);
        this.setTitle("lambda测试");
        jb = new JButton("click");
        this.add(jb);
        jb.addActionListener(mae ->{
            System.out.println("admin is good!");
        });
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        new Main();
    }

}
