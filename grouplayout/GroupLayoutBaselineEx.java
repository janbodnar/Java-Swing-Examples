package com.zetcode;

import javax.swing.GroupLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Container;
import java.awt.EventQueue;

import static javax.swing.GroupLayout.Alignment.BASELINE;

public class GroupLayoutBaselineEx extends JFrame {

    private JLabel display;
    private JComboBox<String> box;
    private String[] distros;

    public GroupLayoutBaselineEx() {

        initUI();
    }

    private void initUI() {

        Container pane = getContentPane();
        GroupLayout gl = new GroupLayout(pane);
        pane.setLayout(gl);

        distros = new String[] {"Easy", "Medium", "Hard"};
        box = new JComboBox<>(distros);
        display = new JLabel("Level:");

        gl.setAutoCreateContainerGaps(true);
        gl.setAutoCreateGaps(true);

        gl.setHorizontalGroup(gl.createSequentialGroup()
                .addComponent(display)
                .addComponent(box,
                        GroupLayout.DEFAULT_SIZE,
                        GroupLayout.DEFAULT_SIZE,
                        GroupLayout.PREFERRED_SIZE)
        );

        gl.setVerticalGroup(gl.createParallelGroup(BASELINE)
                .addComponent(box, GroupLayout.DEFAULT_SIZE,
                        GroupLayout.DEFAULT_SIZE,
                        GroupLayout.PREFERRED_SIZE)
                .addComponent(display)
        );

        pack();

        setTitle("Baseline alignment");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {

            GroupLayoutBaselineEx ex = new GroupLayoutBaselineEx();
            ex.setVisible(true);
        });
    }
}
