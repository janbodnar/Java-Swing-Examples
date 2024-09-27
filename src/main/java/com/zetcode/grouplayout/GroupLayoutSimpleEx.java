package com.zetcode.grouplayout;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.EventQueue;

import static javax.swing.GroupLayout.Alignment.LEADING;
import static javax.swing.LayoutStyle.ComponentPlacement.RELATED;

public class GroupLayoutSimpleEx extends JFrame {

    public GroupLayoutSimpleEx() {

        initUI();
    }

    private void initUI() {

        var pane = getContentPane();
        var gl = new GroupLayout(pane);
        pane.setLayout(gl);

        var lbl = new JLabel("Name:");
        var field = new JTextField(15);

        GroupLayout.SequentialGroup sg = gl.createSequentialGroup();

        sg.addComponent(lbl).addPreferredGap(RELATED).addComponent(field,
                GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
                GroupLayout.PREFERRED_SIZE);

        gl.setHorizontalGroup(sg);

        GroupLayout.ParallelGroup pg = gl.createParallelGroup(
                LEADING, false);

        pg.addComponent(lbl).addComponent(field);
        gl.setVerticalGroup(pg);

        gl.setAutoCreateContainerGaps(true);

        pack();

        setTitle("Simple");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            var ex = new GroupLayoutSimpleEx();
            ex.setVisible(true);
        });
    }
}
