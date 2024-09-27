package com.zetcode.grouplayout;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import java.awt.EventQueue;

import static javax.swing.LayoutStyle.ComponentPlacement.RELATED;

public class GroupLayoutCornerButtonsEx extends JFrame {

    public GroupLayoutCornerButtonsEx() {

        initUI();
    }

    private void initUI() {

        setPreferredSize(new Dimension(300, 200));

        var cpane = getContentPane();
        var gl = new GroupLayout(cpane);
        cpane.setLayout(gl);

        gl.setAutoCreateGaps(true);
        gl.setAutoCreateContainerGaps(true);

        var okButton = new JButton("OK");
        var closeButton = new JButton("Close");

        gl.setHorizontalGroup(gl.createSequentialGroup()
                .addPreferredGap(RELATED,
                        GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(okButton)
                .addComponent(closeButton)
        );

        gl.setVerticalGroup(gl.createSequentialGroup()
                .addPreferredGap(RELATED,
                        GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(gl.createParallelGroup()
                        .addComponent(okButton)
                        .addComponent(closeButton))
        );

        gl.linkSize(SwingConstants.HORIZONTAL, okButton, closeButton);

        pack();

        setTitle("Buttons");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {

            var ex = new GroupLayoutCornerButtonsEx();
            ex.setVisible(true);
        });
    }
}
