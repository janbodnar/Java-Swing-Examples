package com.zetcode;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.EventQueue;

public class LabelEx2 extends JFrame {

    public LabelEx2() {

        initUI();
    }

    private void initUI() {

        var lbl1 = new JLabel(new ImageIcon("src/resources/cpu.png"));
        var lbl2 = new JLabel(new ImageIcon("src/resources/drive.png"));
        var lbl3 = new JLabel(new ImageIcon("src/resources/laptop.png"));
        var lbl4 = new JLabel(new ImageIcon("src/resources/player.png"));

        createLayout(lbl1, lbl2, lbl3, lbl4);

        setTitle("Icons");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void createLayout(JComponent... arg) {

        var pane = getContentPane();
        var gl = new GroupLayout(pane);
        pane.setLayout(gl);

        gl.setAutoCreateContainerGaps(true);
        gl.setAutoCreateGaps(true);

        gl.setHorizontalGroup(gl.createSequentialGroup()
                .addComponent(arg[0])
                .addComponent(arg[1])
                .addComponent(arg[2])
                .addComponent(arg[3])
        );

        gl.setVerticalGroup(gl.createParallelGroup()
                .addComponent(arg[0])
                .addComponent(arg[1])
                .addComponent(arg[2])
                .addComponent(arg[3])
        );

        pack();
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {

            var ex = new LabelEx2();
            ex.setVisible(true);
        });
    }
}
