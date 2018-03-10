package com.zetcode;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Container;
import java.awt.EventQueue;

public class ImageIconButtonEx extends JFrame {

    public ImageIconButtonEx() {

        initUI();
    }

    private void initUI() {

        ImageIcon saveIcon = new ImageIcon("src/main/resources/save.png");
        ImageIcon homeIcon = new ImageIcon("src/main/resources/home.png");

        JButton quitBtn = new JButton("Quit");
        JButton saveBtn = new JButton(saveIcon);
        JButton homeBtn = new JButton("Home", homeIcon);

        createLayout(quitBtn, saveBtn, homeBtn);

        setTitle("JButtons");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void createLayout(JComponent... arg) {

        Container pane = getContentPane();
        GroupLayout gl = new GroupLayout(pane);
        pane.setLayout(gl);

        gl.setAutoCreateContainerGaps(true);
        gl.setAutoCreateGaps(true);

        gl.setHorizontalGroup(gl.createSequentialGroup()
                .addComponent(arg[0])
                .addComponent(arg[1])
                .addComponent(arg[2])
        );

        gl.setVerticalGroup(gl.createParallelGroup()
                .addComponent(arg[0])
                .addComponent(arg[1])
                .addComponent(arg[2])
        );

        gl.linkSize(arg[0], arg[1], arg[2]);

        pack();
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            ImageIconButtonEx ex = new ImageIconButtonEx();
            ex.setVisible(true);
        });
    }
}
